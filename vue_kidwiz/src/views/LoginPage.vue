<template>
  <div>
    <input v-model="loginInfo.id" type="number" placeholder="Your ID">
    <input v-model="loginInfo.pw" type="password" placeholder="Password">
    <button @click="login">Login</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      loginInfo: {
        id: '',
        pw: ''
      }
    };
  },
  methods: {
    login() {
      axios.post('http://localhost:3000/api/auth/login', this.loginInfo)
        .then(response => {
          // 로컬스토리지에 토큰 저장
          const { name, token } = response.data; // 구조 분해 할당을 사용하여 이름과 토큰 추출
          localStorage.setItem('jwt', token); // 키-값
          localStorage.setItem('name', name); // 사용자 이름 저장
          alert(name + "님 로그인 하셨습니다."); 
          // 로그인 성공 후 홈페이지로 리다이렉트
          this.$router.push('/testVue');
        })
        .catch(error => {
          alert("실패 : "+error.response.data);
        });
    }
  }
}
</script>