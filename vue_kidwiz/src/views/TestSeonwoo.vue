<template>
  <div>
    <h1>게시판</h1>
    <table border="1">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
      <tr v-for="row in list" v-bind:key="row.bno">
        <td v-text="row.no"></td>
        <td>{{row.btitle}}</td>
        <td v-text="row.writer"></td>
        <td v-text="row.bdate"></td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name:'TestSeonwoo',
  data(){
    return{
      list:[],
    }
  },
  mounted(){
    axios.get('api/board').then((res) =>{
      this.list = res.data.list;
    }).catch((err) => {
      alert('문제가 발생했습니다. '+ err);
    })
  }
}
</script>

<style>

</style>