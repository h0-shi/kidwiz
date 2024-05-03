<template>
  <div>
    <table border="1">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
      <tr v-for="row in list" v-bind:key="row.bno">
        <td v-text="row.no"></td>
        <td @click="detail(row.bno)">{{ row.btitle }}</td>
        <td>{{ row.writer }}</td>
        <td>{{ row.bdate }}</td>
      </tr>
    </table>
    <button @click="$router.push('/boardwrite')">글쓰기</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name:"BoardList",
  data(){
    return{
      list:[],
      requestBody : this.$route.query
    }
  },
  mounted(){
    axios("/api/boardList").then((res)=>{
      this.list=res.data.list
    }).catch((err)=>{
      alert("에러 발생 : "+ err)
    })
  },
  methods:{
    detail(bno){
      this.requestBody.bno=bno
      this.$router.push({path:"./boardDetail",query:this.requestBody})
    }
  }
}
</script>

<style>

</style>