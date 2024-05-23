<template>
  <div class="boundary text-start p-3 border" style="border-radius: 10px;">
    <div>
      <div><h1>{{ detail.btitle }}</h1></div>
      <div>
        <div>{{ detail.writer }}</div>
        <small class="text-secondary">{{ detail.bdate }}</small>
      </div>
      <hr>
    </div>
    <div style="height: 400px;">
    {{ detail.bcontent }}<br>
    </div>
    <div>
      <hr>
      <div class="text-end">
        <button class="btn btn-danger me-2" @click="del(requestBody.bno)">삭&nbsp;제</button>
        <button class="btn btn-warning me-2" @click="update()">수&nbsp;정</button>
        <button v-if="check" class="btn btn-success me-2" @click="reply()">답변글</button>
      </div>
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
        bno:null,
        btitle:null,
        bcontent:null,
        writer:null,
        bdate:null,
        up_bno:null,
        depth:null,
        ordernum:null
      },check:false
    }
  },mounted(){
    this.boardDetail()
    this.counselorcheck()
  },
  methods:{

    counselorcheck(){
      axios.post("/api/counselorcheck",{withCredentials:true}).then((res)=>{
        if(res.data ==1){
          this.check = true
        }else{
          this.check = false
        }
      })
    },

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
      this.$router.push({path:"./BoardReply",query:this.requestBody})
    }
  }
}
</script>

<style>

</style>