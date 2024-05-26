<template>
  <div class="container-lg mt-5">
    <div class="d-flex justify-content-start mb-5">
      <h3>&gt; FAQ 게시판</h3>
    </div>
    <div class="card shadow-sm">
      <div class="card-header" style="height: 60px; background-color: #67BF4E; color:white;">
        <div class="title d-flex align-items-left">
          <div class="col-md-6 title-font">
            <span v-if="!isUpdating"><strong>{{ question.title }}</strong></span>
            <input v-else v-model="question.title" class="form-control" />
          </div>
          <div class="col-md-2 writer">
            <strong>{{ question.writer }}</strong>
          </div>
          <div class="col-md-3 date">
            <strong>{{ formattedDate }}</strong> 
          </div>
        </div>
      </div>
      <div class="card-body">
        <div class="card-text contents" v-if="!isUpdating" v-html="question.content"></div>
        <div v-else>
          <div ref="quillContainer" style="height: 300px;"></div> 
        </div>
      </div>
      <div class="card-footer">
        <div class="d-flex justify-content-end">
          <div class="question-editor" :class="{ updating: isUpdating }"> 
            <div v-if="isUpdating" class="question-editor-toolbar">
              <span class="ql-formats"></span>
            </div> 
            <div v-if="isUpdating">
              <button @click="updateQuestion" class="btn btn-success me-2 custom-border">수정 완료</button>
              <button @click="cancelUpdate" class="btn btn-secondary custom-border">취소</button>
            </div>
            <div v-else>
              <button v-if="isAdmin" @click="startUpdate" class="btn btn-warning me-2 custom-border" style="color:white;">수정하기</button>
              <button v-if="isAdmin" @click="deleteQuestion" class="btn btn-danger me-2 custom-border">삭제하기</button>
              <button @click="goBack" class="btn custom-border" style="background-color: #67BF4E; color:white;">게시판으로 돌아가기</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import axios from 'axios';
import Quill from 'quill';

export default {
  data() {
    return {
      question: {},
      isUpdating: false,
      dept: null,
      isAdmin: false,
      quill: null 
    }
  },
  mounted() {
    axios.post("/api/getMemberType", {}, { withCredentials: true }).then((res) => {
      this.dept = res.data.dept;
      this.isAdmin = this.dept === '관리자';
    }).catch(() => {
      this.dept = null;
    });

    this.fetchQuestion();
      // 새로고침 시 isUpdating 플래그를 false로 설정
  this.isUpdating = false;
  },
  computed: {
    formattedDate() {
      return new Date(this.question.date).toLocaleDateString('ko-KR', { 
        year: 'numeric', 
        month: '2-digit', 
        day: '2-digit', 
        hour: '2-digit', 
        minute: '2-digit' 
      });
    }
  },
  methods: {
    fetchQuestion() {
  const questionId = this.$route.params.id;
  axios.get(`http://localhost:3000/api/faqquestions/${questionId}`)
    .then(response => {
      this.question = response.data;
      // isUpdating과 관계없이 항상 Quill 초기화
      this.initQuill(); 
    })
    .catch(error => {
      console.error('Error fetching question:', error);
    });
},
    startUpdate() {
      this.isUpdating = true;
      this.$nextTick(() => { // isUpdating 변경 후 DOM 업데이트 후 Quill 초기화
        this.initQuill(); 
      });
    },
    cancelUpdate() {
    this.isUpdating = false;
    if (this.quill) {
      this.quill.disable(); // Quill 에디터를 비활성화
      this.quill = null; // Quill 인스턴스를 제거
    }
    this.fetchQuestion(); // 원래의 데이터를 다시 가져옴
  },
  updateQuestion() {
  if (!this.isAdmin) {
    alert('관리자만 접근 가능');
    return;
  }
  if (confirm('수정하시겠습니까?')) {
    this.question.content = this.quill.root.innerHTML;

    const questionId = this.$route.params.id;
    axios.put(`http://localhost:3000/api/faqquestions/${questionId}`, this.question)
      .then(() => {
        console.log('Question updated successfully');
        this.isUpdating = false; // 수정 완료 후 isUpdating 플래그를 false로 설정
        if (this.quill) {
          this.quill.disable(); // Quill 에디터를 비활성화
          this.quill = null; // Quill 인스턴스를 제거
        }
        this.fetchQuestion(); // 갱신된 데이터를 다시 가져옴
      })
      .catch(error => {
        console.error('Error updating question:', error);
      });
  }
},


    deleteQuestion() {
      if (!this.isAdmin) {
        alert('관리자만 접근 가능');
        return;
      }
      if (confirm('정말 삭제하시겠습니까?')) {
        const questionId = this.$route.params.id;
        axios.delete(`http://localhost:3000/api/faqquestions/${questionId}`)
          .then(() => {
            console.log('Question deleted successfully');
            this.$router.push('/faq');
          })
          .catch(error => {
            console.error('Error deleting question:', error);
          });
      }
    },
    goBack() {
      this.$router.push('/faq'); 
    },
    initQuill() {
  if (this.quill) {
    this.quill.destroy();
  }
  this.quill = new Quill(this.$refs.quillContainer, {
    theme: 'snow'
  });

  // isUpdating 상태에 따라 처리
  if (this.isUpdating) {
    this.quill.root.innerHTML = this.question.content; // 에디터에 내용 표시
    this.quill.enable();
  } else {
    this.$refs.quillContainer.innerHTML = this.question.content; // 에디터 외부에 내용 표시
    this.quill.disable();
  }
},
  }
}
</script>


<style scoped>
.container-lg {
  width: 1100px;
  margin: 0 auto;
}
.date, .writer {
  align-items: right;
  justify-content: right;
  font-size: small;
}
.title {
  margin-top: 20px;
  margin-bottom: 20px;
  text-align: center;
  margin: 0 auto;
  justify-content: center;
  align-items: center;
}
.title-font {
  font-weight: bold; 
  font-size: large; 
  text-align: left;
  margin-left: 10px;
}
.contents{
  margin:10px 40px 10px 40px;
  text-align: left;
  height: 400px;
}
.contents textarea{
  height: 300px;
}
.custom-border {
  border-color: transparent !important;
}
.card-body{
  background-color: rgb(252, 255, 252);
}
.card-footer{
  background-color: #e7fee1;
}
.question-editor .ql-toolbar {
  display: none; /* 기본적으로 툴바 숨기기 */
}

.question-editor.updating .ql-toolbar {
  display: block; /* .updating 클래스가 있을 때만 툴바 표시 */
}
</style>
