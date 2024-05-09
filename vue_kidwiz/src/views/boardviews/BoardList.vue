<template>
  <div>
    <table class="table">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
      <tr v-for="row in list" v-bind:key="row.bno">
        <td v-text="row.no"></td>
        <td v-if="row.depth ==0" @click="detail(row.bno)" style="text-align: left">{{ row.btitle }}</td>
        <td v-else @click="detail(row.bno)" style="text-align: left">&nbsp;ㄴ[:Re]{{ row.btitle }}</td>
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
    axios("/api/BoardList").then((res)=>{
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