<!-- App.vue -->
<template>
  <div class="faqwrite rounded bg-light">
    <h3 class="mb-4 text-center" style="font-weight: bolder;">공지사항 게시판</h3><br>
    <form @submit.prevent="write" class="form-horizontal">
      <div class="mb-3 row align-items-center">
        <label for="title" class="col-sm-2 col-form-label" style="font-weight: bold;">제목</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="title" v-model="title" required>
        </div>
      </div>
      <div class="mb-4 row align-items-center">
        <label for="content" class="col-sm-2 col-form-label" style="font-weight: bold;">내용</label>
        <div class="col-sm-9">

        </div>
      </div>
      <div class="row">
        <div class="col-sm-8 offset-sm-2" style="margin-bottom:40px;">
          <button type="submit" class="btn btn-success" style="background-color: #67BF4E;">글쓰기</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      title: null,
      content: '',
      writer: '관리자',
    };
  },
  methods: {
    write() {
      axios.post('http://localhost:3000/api/faqquestions', {
        title: this.title,
        content: this.content,
        writer: this.writer,
        date: new Date().toISOString(),
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
  width: 1000px;
  margin: 0 auto;
  background-color: rgb(205, 255, 211);
}
.btn {
  border-color: #67BF4E !important;
  color: white;
  margin: 0 auto;
}
</style>