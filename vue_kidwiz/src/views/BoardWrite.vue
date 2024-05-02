<template>
  <div>
    제목 :<input v-model="title"/>
    내용 :<textarea v-model="content"></textarea>
    <button @click="write">글쓰기</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name:"BoardWrite",
  data(){
    return{
      title: null,
      content : null
    }
  },
  methods:{
    write(){
      let saveData={}
      saveData.title=this.title
      saveData.content = this.content
      saveData.writer = "tjsdn112"
      axios.post("/boardWrite",JSON.stringify(saveData),{
        headers:{"Content-Type":"application/json"}
      }).then((res)=>{
        if(res.data == 1){
        this.$router.push({path:"./boardList"});
        }else {
          alert("전송 실패"+res.data);
        }
      }).catch((err) => {
        alert("문제가 발생 : "+err)
      })
    }
  }
}
</script>

<style>

</style>