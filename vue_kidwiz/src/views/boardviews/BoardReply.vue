<template>
  <div>
    제목 : {{ reply.btitle }}<br>
    글쓴이 : {{ reply.bno }}<br>
    내용 : {{ reply.bcontent }}<br>
    <button @click="boardReply()">답글 달기</button>
  </div>
</template>

<script>

export default {
  name:"BoardReply",
  data(){
    return{
      requestBody:this.$route.query,
      reply:{
        bno:null,
        btitle:null,
        bcontent:null,
        writer:null,
        bdate:null,
        up_bno:null,
        depth:null,
        ordernum:null
      }
    }
  },mounted(){
    this.reply = this.requestBody
  },
  methods:{
    
  }
}
</script>

<style>

</style>