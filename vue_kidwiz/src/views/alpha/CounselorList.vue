<template>
  <div>
    <MenuPage />
    <div class="container py-5 px-lg-7 rounded shadow-lg">
      <h1 class="mb-2 name">상담사 소개</h1>
      <h6 class="mb-4 font">다양한 상담사들이 있다! 보고 가거라!</h6>
      <hr class="mb-5 line">
      <div class="row justify-content-center mb-5" v-for="r in counselorList" v-bind:key="r.id">
        <div class="col-lg-9">
          <div class="profile-header text-white py-4 rounded-top" style="background-color: cadetblue;">
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
                <h1 class="mb-3 name">{{ r.name }}</h1>
                <p class="mb-2 font">{{ r.title }}</p>
                <p class="mb-3 font">{{ r.bio }}</p>
                
              </div>
            </div>
          </div>
          <div class="profile-body bg-white rounded shadow-sm p-4 mt-n5 position-relative">
            
            <p class="mb-4">{{ r.greeting }}</p>
            <div class="card mb-4">
                <div class="card-body">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                      <strong>전문분야</strong>
                      <span class="text-muted">{{ r.expertise }}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                      <strong>경력</strong>
                      <span class="text-muted">{{ r.experience }}년</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                      <strong>자격증</strong>
                      <span class="text-muted">{{ r.certifications }}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                      <strong>연락처</strong>
                      <span class="text-muted">
                        <a :href="'mailto:' + r.email" class="text-decoration-none">{{ r.email }}</a>
                      </span>
                  </li>
                </ul>
                      </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import axios from 'axios';

export default {
  components: {
    MenuPage
  },
  mounted(){
    axios.get('http://localhost:3000/counselorList').then((res) => {
      this.counselorList = res.data;
    }).catch((err) => {
      console.log(err);
    })
  },
  data() {
    return {
      counselor: {
        name: '',
        title: '',
        image: '',
        bio: '',
        expertise: '',
        experience: '',
        certifications: '',
        email: '',
        greeting: '',
      },
      counselorList: [],
    }
  }
}
</script>

<style scoped>
@font-face {
  font-family: 'hanna';
  src: url("@/assets/font/BMHANNAAir_ttf.ttf");
}
@font-face {
  font-family: 'dh';
  src: url("@/assets/font/BMDOHYEON_ttf.ttf");
}
.line{
  width: 60%;
  margin: 0 auto;
}
.name{
  font-family: 'dh';
}
.font{
  font-family: 'hanna';
  font-size: larger
}
.profile{
  box-shadow: 10px black;
}
.container {
  padding: 30px;
  background-color: #f9f9f9;
  border-radius: 8px;
  max-width : 1200px;
}

.card {
  margin-bottom: 20px;
}

.card-body {
  padding: 20px;
}

.list-unstyled {
  margin: 0;
  padding: 0;
}

.row {
  display: flex;
  align-items: center;
}

.col-sm-4 {
  font-weight: bold;
}

.img-fluid {
  max-width: 100%;
  height: auto;
}
</style>
