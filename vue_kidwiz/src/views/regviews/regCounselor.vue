<template>
  <div>
    <div class="sbmContainer boundary">
        <h1 class="title">개인 상담</h1>
        <table class="subMenu">
            <tr>
                <th :style="select[0]" @click="this.$router.push('regIntroduce')">개인상담이란?</th>
                <th :style="select[1]" @click="this.$router.push('regCounselor')">상담사 소개</th>
                <th :style="select[2]" @click="displayAct(2)">여긴 뭐넣지~?</th>
                <th :style="select[3]" @click="this.$router.push('rsrvTest4?selectedCounselingType=전문상담')">상담 신청</th>
            </tr>
        </table>
    <section class="section s1 mt-5" :style="cssAct[0]">
      <h4 class="subt">상담사 소개</h4>
      <div class="container py-6 px-lg-7 rounded shadow-lg mt-5">
      <div class="row justify-content-center">
        <div class="col-lg-11">
          <div class="profile-header text-white py-4 rounded-top" style="margin-top:50px; background-color: cadetblue;">
            <div class="row align-items-center">
              <div class="col-md-4 order-md-2 text-center">
                <img
                  :src="require('@/assets/simri2.png')"
                  alt="Counselor Image"
                  class="img-fluid rounded-circle mb-3 shadow"
                  style="width: 250px; height: 250px; object-fit: cover;"
                />
              </div>
              <div class="col-md-8 order-md-1 text-white">
                <h1 class="mb-1 name">{{ counselor.name }}</h1>
                <p class="mb-3 font">{{ counselor.title }}</p>
                <br>
                <p class="mb-4 font">{{ counselor.bio }}</p>
              </div>
            </div>
          </div>
          <div class="profile-body bg-white rounded p-4 mt-n5 position-relative">
            <p class="lead mb-4 font" style="font-weight: 500;" v-html="counselor.greeting"></p><br>
            <div class="row">
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center"> 
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">전문분야</h5><br>
                    <p class="card-text text-center font">{{ counselor.expertise }}</p> 
                  </div>
                </div>
              </div>
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">경력</h5><br>
                    <p class="card-text font">{{ counselor.experience }}년</p>
                  </div>
                </div>
              </div>
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">자격증</h5><br>
                    <p class="card-text text-center font">{{ counselor.certifications }}</p>
                  </div>
                </div>
              </div>
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">연락처</h5><br>
                    <a :href="'mailto:' + counselor.email" class="text-decoration-none font">{{ counselor.email }}</a>
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{
            act : "none",
            cssAct: [
                {display : "none"},
                {display : "none"},
                {display : "none"},
                {display : "none"}
            ],
            select: [
                {},
                {},
                {},
                {}
            ],
            counselor: {
        name: '',
        title: '',
        image: 'https://via.placeholder.com/250',
        bio: '',
        expertise: '',
        experience: '',
        certifications: '',
        email: '',
        greeting: '',
      }
        }
    },
    mounted(){
        this.cssAct[0] = {display:"block"};
        this.select[1] = {border:"2px solid rgb(43, 43, 165", 'border-bottom':"none"};
        const id = 24102003;
        axios.get('http://localhost:3000/getCounselorInfo?id='+id).then((res) => {
          this.counselor = res.data;
        })
    },
    methods:{
        displayAct(num){
            this.cssAct = this.cssAct.map((style, i) => {
            if(i == num){
                return {display:"block"};                
            }
            return {display:"none"};
        })
            this.select = this.select.map((style, i)=> {
                if(i==num){
                    return {border:"2px solid rgb(43, 43, 165", 'border-bottom':"none"};
                }
            })
        }
    },

}
</script>

<style scoped>
.processImg{
    width: 100%;
    margin: 40px 0 ;
}
.sbmContainer{
    width: 100%;
    margin-bottom: 50px;
}
.subMenu{    
    width: 100%;
    margin: auto;
}
.subMenu tr th{
    width: 25%;
    height: 55px;
    border-bottom: 2px solid rgb(43, 43, 165);
}
.boundary{
    width: 100%;
    max-width: 1200px;
    padding: 0 auto;
}
.title{
  text-align: left;
  font-family: 'sj';
  margin-left: 15px;
  margin-bottom: 40px;
}
.subt{
  text-align: left;
  font-family: 'sj';
  margin-bottom: -30px;
}
.exp{
    font-size: 83%;
    text-align: left;
    line-height: 1.65;
}
.expBox{
    background-color: #eef1f6;
    border: 3px solid #dbe1e8;
}
.inBox{
    display: block;
    text-align: left;
    margin-left: 10px;    
}
.name{
  font-family: 'dh';
}
.font{
  font-family: 'hanna';
  font-size: larger;
}
</style>