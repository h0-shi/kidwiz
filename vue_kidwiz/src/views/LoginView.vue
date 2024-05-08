<template>
    <div class="login">
      <h1>로그인 페이지 입니다</h1>
      <form id = "LoginForm" @submit.prevent="login">
        <div class="LoginFormClass">
          <label for="userId">아이디 : </label>
          <input type="text" v-model="userId" placeholder="아이디를 입력해주세요">
        </div>
        <div class="LoginFormClass">
          <label for="password">비밀번호 : </label>
          <input type="password" v-model="password" placeholder="비밀번호를 입력해주세요">
        </div>
        <button type="submit">로그인</button>
      </form>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name:'LoginVue',
    data(){
      return{
        userId: '',
        password: ''
      };
    },
    methods: {
      login(){
        axios.post('http://localhost:3000/login',{
          userId: this.userId,
          password: this.password
        })
        .then(response => {
          // 로그인 성공 처리
          console.log('Login success:', response);
        })
        .catch(error => {
          // 로그인 실패 처리
          console.error('Login error:', error);
        });
      }
    }
}
</script>
