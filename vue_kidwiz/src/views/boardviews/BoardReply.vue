<template>
  <div>
    제목 : <input v-model="reply.title">
    글쓴이 : {{ requestBody.bno }}
    내용 :  <textarea v-model="reply.content"></textarea>
    <button @click="boardReply()">답글 달기</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name:"BoardReply",
  data(){
    return{
      requestBody : this.$route.query,
      reply:{
        title:null,
        content:null,
        bno:null
      }
    }
  },
  methods:{
    boardReply(){
      axios.post("/api/boardReply",this.reply).then((res)=>{
        if(res.data.result ==1 ){
          this.$router.push({path:"./BoardList",query:this.requestBody})
        }
      }).catch((err)=>{
        alert(err)
      })
    }
  }
}
</script>

<style>

</style>