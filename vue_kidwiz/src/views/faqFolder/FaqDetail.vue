<template>
  <div>
    <h1>{{ question.title }}</h1>
    <p>{{ question.content }}</p>
    <p>작성자: {{ question.writer }}</p>
    <p>날짜: {{ question.date }}</p>
    <button @click="editQuestion">수정</button>
    <button @click="deleteQuestion">삭제</button>
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
    editQuestion() {
      const questionId = this.$route.params.id;
      this.$router.push(`/faqedit/${questionId}`);
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

<style>
/* Add any necessary styles here */
</style>
