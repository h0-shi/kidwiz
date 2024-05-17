<template>
  <component :is="$route.meta.layout || 'div'">
    <router-view></router-view>
  </component>
  </template>
  
  <script>  
  export default {
    name: 'App',
    components: {
      
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


    <!--  이 부분 있으면 사이트 접속 시 에러 남. 
      setup() {
      const check = () => {
        axios.get('http://localhost:3000/api/account/check', { withCredentials: true }).then(({data}) => {
          console.log(data+"안녕안녕");
          // data 값이 있으면 setAccount 에 data 넣고, 없으면 0
          store.commit("setAccount", data || 0);
        })
      };
      // url 정보 가져오기
      const route = useRoute();
      // 경로가 바뀔 때 마다 감시(check 실행)
      watch(route, () => {
        check();
      }) -->