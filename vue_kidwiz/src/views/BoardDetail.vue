<template>
  <div>
    <div>
      제목 : {{ detail.btitle }}
    </div>
    <div>
      내용 : {{ detail.content }}
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name:"BoardDetail",
  data(){
    return{
      requestBody:this.$route.query,
      detail:{
        btitle:null,
        bcontent:null,
        writer:null,
        bdate:null
      }
    }
  },mounted(){
    this.boardDetail()
  },
  methods:{
    boardDetail(){
      axios.get("/api/boardDetail?bno="+this.requestBody.bno).then((res)=>{
        this.detail = res.data
      }).catch((err)=>{
        alert("에러 발생 : "+err)
      })
    }
  }
}
</script>

<style>

</style>