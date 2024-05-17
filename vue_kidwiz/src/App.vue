<template>
  <component :is="$route.meta.layout || 'div'">
    <router-view></router-view>
  </component>
</template>

<script>
import axios from 'axios';
import store from './views/store';
import { useRoute } from 'vue-router';
import { watch, ref } from 'vue'; // ref 추가 240516백건하


export default {
  name: 'App',
  components: {

  },
  setup() {
    //check함수 중복 방지 추가 240516백건하
    const isChecking = ref(false);


    const check = () => {
      axios.get('http://localhost:3000/api/account/check', { withCredentials: true }).then(({ data }) => {
        console.log(data + "안녕안녕");
        // data 값이 있으면 setAccount 에 data 넣고, 없으면 0
        store.commit("setAccount", data || 0);

        //check함수 중복 방지 추가 240516백건하
        isChecking.value = false;
      }).catch(() => {
        isChecking.value = false;
      });
      
    };
    // url 정보 가져오기
    const route = useRoute();
    // 경로가 바뀔 때 마다 감시(check 실행)
    watch(route, () => {
      check();
    })
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
