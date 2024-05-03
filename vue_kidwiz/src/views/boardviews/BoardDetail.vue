<template>
  <div>
    <div>
      제목 : {{ detail.btitle }}
      <button @click="del(requestBody.bno)">삭제</button>
      <button @click="update()">수정</button>
      <br>
      글쓴이 : {{ detail.writer }}
    </div>
    <div>
      내용 : {{ detail.bcontent }}
    </div>
    <button @click="reply()">답변글</button>
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
        bno:null,
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
        this.detail = res.data.list
      }).catch((err)=>{
        alert("에러 발생 : "+err)
      })
    },
    del(no){
      if(confirm("삭제하시겠습니까 ?")){
        axios({
          url:"/api/boardDel",
          method:"post",
          params:{bno:no}
        }).then((res)=>{
          if(res.data.result==1){
            this.$router.push({path:"./BoardList",query:this.requestBody})
          }else{
            alert("입력실패");
          }
        }).catch((err) => {
          alert("에러 발생 : " +err)
        })
      }
    },
    update(){
      this.$router.push({path:"./BoardUpdate",query:this.requestBody})
    },reply(){
      this.$router.push({path:"./BoardReply",params:this.requestBody})
    }
  }
}
</script>

<style>

</style>