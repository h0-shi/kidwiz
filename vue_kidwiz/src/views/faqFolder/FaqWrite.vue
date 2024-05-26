<template>
  <div class="faqwrite rounded bg-light" style="padding-top:30px;">
    <h3 class="mb-4 text-center" style="font-weight: bolder;">공지사항 게시판</h3><br>
    <form @submit.prevent="write" class="form-horizontal">
      <div class="mb-3 row justify-content-center align-items-center">
        <div class="col-sm-9">
          <input type="text" class="form-control" id="title" v-model="title" required placeholder="제목을 입력해주세요.">
        </div>
      </div>
      <div class="mb-4 row justify-content-center align-items-center">
        <div class="col-sm-9">
          <vue-quill v-model="content" class="quill-editor" placeholder="내용을 입력해주세요." />
        </div>
      </div>
      <div class="row">
        <div class="col-sm-8 offset-sm-2 text-center" style="margin-bottom:40px;">
          <button type="submit" class="btn btn-success" style="background-color: #67BF4E;">글쓰기</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import { QuillEditor } from '@vueup/vue-quill';

export default {
  components: {
    'vue-quill': QuillEditor,
  },
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
  width: 1100px;
  margin: 0 auto;
  background-color: rgb(205, 255, 211);
}
.btn {
  border-color: #67BF4E !important;
  color: white;
  margin: 0 auto;
}
.quill-editor .ql-container {
  height: 300px;
}

.quill-editor{
  background-color: white;
  height: 300px;
  min-height: 200px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}
</style>
