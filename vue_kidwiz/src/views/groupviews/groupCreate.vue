<template>
  <div class="container" style="padding:15px">

    <div>
      <div class="input-group mb-3">
        <div class="col-2">
          상담 제목 : 
        </div>
        <div class="col">
          <input type="text" aria-label="First name" class="form-control">  
        </div>
      </div>

      <div class="input-group">
        <div class="col-2">
          상담사 이름 :  
        </div>
        <div class="col">
          <input type="text" aria-label="First name" class="form-control">
        </div>
      </div>
    </div>

    <hr>

    <div>
      <div class="input-group mb-3">
        <div class="col-2">
          내용
        </div>
        <div class="col">
          <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
      </div>

      <div class="input-group mb-3">
        <div class="col-2">파일 선택</div>
        <div class="col">
          <input class="form-control" type="file" id="formFile">
        </div>
      </div>
    </div>

    <hr>

    <div>  
      <div class="input-group">
        <div class="col-2">
          날짜
        </div>
        <div class="col">
          <Datepicker
            v-model="picked"
            :locale="locale"
            :week-starts-on="0"
            :input-format="inputFormat"
            :clearable="true"
          />
        </div>


      </div>
      <div>
        운영 시간 : 
      </div>
      <div class="input-group">
        <div class="col-2">
          총 인원 수: 
        </div>
        <div class="col">
          <select class="form-select" >
            <option></option>
            <option v-for="n in 10" v-bind:key="n">{{ n }}</option>
          </select>
        </div>
      </div>
    </div>

    <hr>

    <div class="mb-3">
      <div  class="input-group mb-3">
        <div class="col-2">성별 : </div>
        <div class="col">
          <select class="form-select" >
            <option>전체</option>
            <option>남자</option>
            <option>여자</option>
          </select>
        </div>
      </div>
      <div class="input-group">
        <div class="col-2">전공 :</div>
        <div class="col">
          <select class="form-select" >
            <option>컴퓨터학과</option>
            <option>심리학과</option>
            <option>국어국문과</option>
          </select>
        </div> 
      </div>
    </div>
    <div>
      <button class="btn btn-primary">등록</button>
    </div>
  </div>
</template>

<script>
import Datepicker from 'vue3-datepicker';

export default {
  name:"groupCreate",
  components:{
    Datepicker
  },
  data(){
    return{
      
    }
  },
  mounted(){

  }
}
</script>

<style>
  .container{
    background: #c1c1c1;
  }
</style>