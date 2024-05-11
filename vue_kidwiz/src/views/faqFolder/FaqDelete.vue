<template>
    <div>
      <h1>질문 삭제</h1>
      <p>정말 이 질문을 삭제하시겠습니까?</p>
      <button @click="deleteQuestion">삭제</button>
      <button @click="$router.push('/faq')">취소</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        question: {}
      }
    },
    created() {
      this.fetchQuestion();
    },
    methods: {
      fetchQuestion() {
        const questionId = this.$route.params.id;
        axios.get(`/api/faqquestions/${questionId}`)
          .then(response => {
            this.question = response.data;
          })
          .catch(error => {
            console.error('Error fetching question:', error);
          });
      },
      deleteQuestion() {
        const questionId = this.$route.params.id;
        axios.delete(`/api/faqquestions/${questionId}`)
          .then(() => {
            console.log('Question deleted successfully');
            // Redirect to FAQ page after deletion
            this.$router.push('/faq');
          })
          .catch(error => {
            console.error('Error deleting question:', error);
          });
      }
    }
  }
  </script>
  