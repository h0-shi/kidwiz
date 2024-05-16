<template>
  <h1>Login</h1>
    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"
           @keyup.enter="submit()" v-model="state.form.email">
    <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
     @keyup.enter="submit()" v-model="state.form.password">
  <button @click="submit()">Sign in</button>
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
      email: "",
      password: ""
    }
  })

const submit = () => {
    console.log(state.form);
    axios.post('http://localhost:3000/api/account/login', state.form, { withCredentials: true }).then((res) => {
      store.commit('setAccount', res.data);
      sessionStorage.setItem("id", res.data); // 세션스토리지에 아이디값 보관
      console.log(res.data);
      router.push({path: "/"});
      window.alert("로그인하였습니다.");
    }).catch(() => {
      window.alert("로그인 정보가 존재하지 않습니다..");
    });
  }

  return {state, submit}
}
}
</script>