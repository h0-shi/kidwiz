<template>
  <div class="faqwrite container mt-5 p-4 rounded bg-light">
    <h3 class="mb-4 text-left" style="margin-left:100px;">공지사항 게시판</h3><br>
    <form @submit.prevent="write" class="form-horizontal">
      <div class="mb-3 row align-items-center">
        <label for="title" class="col-sm-2 col-form-label">제목</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="title" v-model="title" required>
        </div>
      </div>
      <div class="mb-4 row align-items-center">
        <label for="content" class="col-sm-2 col-form-label">내용</label>
        <div class="col-sm-10">
          <textarea class="form-control" id="content" rows="5" v-model="content" required></textarea>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-10 offset-sm-2">
          <button type="submit" class="btn btn-primary">글쓰기</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "WritePage",
  data() {
    return {
      title: null,
      content: null,
      writer: '관리자', // 임의의 작가 이름 설정
      date: null // 초기화하지 않음
    }
  },
  methods: {
    write() {
      axios.post('http://localhost:3000/api/faqquestions', {
        title: this.title,
        content: this.content,
        writer: this.writer,
        date: new Date().toISOString() // 현재 시간을 ISO 형식으로 설정
      }, 
      {
      })
        .then(response => {
          console.log('글쓰기 성공:', response.data);
          this.$router.push('/faq');
        })
        .catch(error => {
          console.error('글쓰기 오류:', error);
        });
    }
  }
};
</script>


<style>
.faqwrite {
  max-width: 1200px;
  background-color: rgb(205, 255, 211);
}


</style>