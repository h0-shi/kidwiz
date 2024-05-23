<template>

  <div class="boundary text-start p-3 border" style="border-radius: 10px;">
    <div>
      <div class="input-group mb-3">
        <div class="col-2">제목</div>
        <input type="text" class="form-control col" v-model="title">
      </div>
      <div class="input-group mb-3">
        <div class="col-2">글쓴이</div>
        <input type="text" class="form-control col" disabled v-model="id">
      </div>
      <hr>
      <div>
        <div class="mb-3">내용</div>
        <textarea class="form-control" v-model="content"></textarea>
      </div>
    </div>
    <div>
      <hr>
      <div class="text-center">
        <button class="btn btn-primary me-2" @click="write()">입&nbsp;력</button>
      </div>
    </div>
  </div>
</template>

<script>
import store from '@/store';
import axios from 'axios'

export default {
  name:"BoardWrite",
  data(){
    return{
      title:null,
      content:null,
      id:store.state.account.id
    }
  },
  methods:{
    write(){
      let saveData={}
      saveData.title = this.title
      saveData.content = this.content
      saveData.writer = this.id

      axios.post("/api/boardWrite",JSON.stringify(saveData),{
        headers:{"Content-Type":"application/json"}
      }).then((res) => {
        if(res.data == 1){
          this.$router.push({path:"./boardList"})
        } else{
          alert("입력 실패")
        }
      }).catch((err) => {
        alert("에러 발생 : "+ err)
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