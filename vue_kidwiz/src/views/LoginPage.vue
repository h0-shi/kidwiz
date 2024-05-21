<template>
  <div class="login-container">
  <div class="spacer"></div>
  <h1>로그인</h1>
  <p>로그인을 하시면 상담센터의 다양한 서비스를 이용하실 수 있습니다</p>
  <div class="form">
    <input type="text" class="form-control" id="floatingInput" placeholder="학번을 입력해주세요"
           @keyup.enter="submit()" v-model="state.form.id">
    <input type="password" class="form-control" id="floatingPassword" placeholder="비밀번호를 입력해주세요"
     @keyup.enter="submit()" v-model="state.form.password">
    <button @click="submit()" class="btn-login">로그인</button>
  </div>
</div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import store from "@/views/store";
import router from '@/router'

export default {
setup() {
  const state = reactive({
    form: {
      id: "",
      password: ""
    }
  })

const submit = () => {

    //state.form 을 보낸다
    console.log(state.form);

    axios.post('http://localhost:3000/api/account/login', state.form, { withCredentials: true })
    .then((res) => {
      window.alert("로그인하였습니다.");
      console.log("로그인하였습니다", JSON.stringify(res.data));

      // store 에 사용자 정보 저장
      store.commit('setAccount', res.data);
      console.log("스토어에 저장된 계정 정보:", store.state.account);

      // 세션스토리지에 아이디값 보관
      sessionStorage.setItem("id", res.data); 
      
      router.push({path: "/"});
    }).catch(() => {
      window.alert("로그인 정보가 존재하지 않습니다..");
    });
  }

  return {state, submit}
}
}
</script>

<style scoped>
.login-container {
  width: 500px;
  margin: 0 auto;
  text-align: center;
}

.spacer {
  height: 50px; /* 여백 추가 */
}

h1 {
  font-size: 40px;
  margin-bottom: 20px;
  font-weight: bold; 
}

p {
  margin-bottom: 30px;
}

.form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form-control {
  width: 100%;
  padding: 15px;
  margin-bottom: 15px;
  font-size: 16px; 
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn-login {
  background-color: black;
  color: white;
  padding: 15px;
  font-size: 18px; 
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 100%;
}
</style>