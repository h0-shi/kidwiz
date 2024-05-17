<template>
  <component :is="$route.meta.layout || 'div'">
    <router-view></router-view>
  </component>
  </template>
  
  <script>
  import axios from 'axios';
  import store from './views/store';
  import { useRoute } from 'vue-router';
  import { watch } from 'vue';
  
  export default {
    name: 'App',
    components: {
      
    },
    setup() {
      const check = () => {
        axios.get('http://localhost:3000/api/account/check', { withCredentials: true }).then((res) => {
          console.log("체크합니다 : ", JSON.stringify(res.data));
          // data 값이 있으면 setAccount 에 data 넣고, 없으면 0
          store.commit("setAccount", res.data || 0);
        })
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
