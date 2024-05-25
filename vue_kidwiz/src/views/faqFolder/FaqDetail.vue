<template>
  <div class="container-lg mt-5">
    <div class="d-flex justify-content-start mb-5">
      <h3>&gt; FAQ 게시판</h3>
    </div>
    <div class="card shadow-sm">
      <div class="card-header bg-light">
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
        <p class="card-text contents">
          <span v-if="!isUpdating">{{ question.content }}</span>
          <textarea v-else v-model="question.content" class="form-control"></textarea>
        </p>
      </div>
      <div class="card-footer">
        <div class="d-flex justify-content-end">
          <div v-if="isUpdating">
            <button @click="updateQuestion" class="btn btn-success me-2 custom-border">수정 완료</button>
            <button @click="cancelUpdate" class="btn btn-secondary custom-border">취소</button>
          </div>
          <div v-else>
            <button v-if="isAdmin" @click="startUpdate" class="btn btn-warning me-2 custom-border">수정하기</button>
            <button v-if="isAdmin" @click="deleteQuestion" class="btn btn-danger me-2 custom-border">삭제하기</button>
            <button @click="goBack" class="btn btn-secondary me-2 custom-border">게시판으로 돌아가기</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      question: {},
      isUpdating: false,
      dept: null,
      isAdmin: false,
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
        })
        .catch(error => {
          console.error('Error fetching question:', error);
        });
    },
    startUpdate() {
      this.isUpdating = true;
    },
    cancelUpdate() {
      this.isUpdating = false;
      this.fetchQuestion(); // 원래 데이터 가져오기
    },
    updateQuestion() {
      if (!this.isAdmin) {
        alert('관리자만 접근 가능');
        return;
      }
      if (confirm('수정하시겠습니까?')) {
        const questionId = this.$route.params.id;
        axios.put(`http://localhost:3000/api/faqquestions/${questionId}`, this.question)
          .then(() => {
            console.log('Question updated successfully');
            this.isUpdating = false;
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
      this.$router.push('/faq'); // 게시판으로 돌아가기
    }
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
  font-size: x-large; 
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
</style>
