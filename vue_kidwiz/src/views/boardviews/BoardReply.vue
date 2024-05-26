<template>
  <div class="boundary text-start p-3 border" style="border-radius: 10px;">
    <div>
      <div class="input-group mb-3">
        <div class="col-2">제목</div>
        <input type="text" class="form-control col" v-model="reply.btitle">
      </div>
      <div class="input-group mb-3">
        <div class="col-2">글쓴이</div>
        <input type="text" class="form-control col" disabled v-model="reply.writer">
      </div>
      <hr>
      <div>
        <div class="mb-3">내용</div>
        <textarea class="form-control" v-model="reply.bcontent"></textarea>
      </div>
    </div>
    <div>
      <hr>
      <div class="text-center">
        <button class="btn btn-primary me-2" @click="boardReply()">입&nbsp;력</button>
      </div>
    </div>
  </div>
</template>

<script>
import store from '@/store';
import axios from 'axios';


export default {
  name:"BoardReply",
  data(){
    return{
      requestBody:this.$route.query,
      reply:{
        bno:this.$route.query.bno,
        btitle:null,
        bcontent:null,
        writer:store.state.account.id,
        up_bno:null,
        depth:null,
        ordernum:null
      }
    }
  },mounted(){
    axios.get("/api/getPath?bno="+this.requestBody.bno).then((res)=>{
      if(res!=null){
        this.reply.up_bno = res.data.list.up_bno
        this.reply.depth = res.data.list.depth
        this.reply.ordernum = res.data.list.ordernum
      }else{
        alert("에러입니다.")
      }
    }).catch((err)=>{
      alert(err);
    })
  },
  methods:{
    boardReply(){
      axios.post("/api/boardReply",this.reply).then((res)=>{
        if(res.data.result==1){
          this.$router.push({path:"/boardList"})
        }
      }).catch((err)=>{
        alert(err);
      })
    }
  }
}
</script>

<style>

textarea{
  resize: none;
  height: 300px;
}
.col-2{
  display: flex;
  justify-content: center; /* 수평 정렬 */
  align-items: center; /* 수직 정렬 */
}
</style>