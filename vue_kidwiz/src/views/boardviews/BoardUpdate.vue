<template>
  
  <div class="boundary text-start p-3 border" style="border-radius: 10px;">
    <div>
      <div class="input-group mb-3">
        <div class="col-2">제목</div>
        <input type="text" class="form-control col" v-model="upDate.btitle">
      </div>
      <div class="input-group mb-3">
        <div class="col-2">글쓴이</div>
        <input type="text" class="form-control col" disabled v-model="upDate.writer">
      </div>
      <hr>
      <div>
        <div class="mb-3">내용</div>
        <textarea class="form-control" v-model="upDate.bcontent"></textarea>
      </div>
    </div>
    <div>
      <hr>
      <div class="text-center">
        <button class="btn btn-primary me-2" @click="update()">수정하기</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name:"BoardUpdate",
  data(){
    return{
      requestBody:this.$route.query,
      upDate:{
        bno:this.$route.query.bno,
        title:null,
        content:null,
        writer:null,
      },
    }
  },mounted(){
    this.boardDetail()
  },
  methods:{
    boardDetail(){
      axios.get("/api/boardDetail?bno="+this.requestBody.bno).then((res)=>{
        this.upDate = res.data.list
      }).catch((err)=>{
        alert("에러 발생 : "+err)
      })
    },
    update(){
      if(confirm("수정하시겠습니까?")){
        axios.post("/api/boardUpdate",this.upDate).then((res)=>{
        if(res.data.result	==	1){
          this.$router.push({path:"./boardDetail",query:this.requestBody})
        }else{
          alert("에러")
        }
      }).catch((err)=>{
        alert(err)
      })
      }
    }
  }
}
</script>

<style>

</style>