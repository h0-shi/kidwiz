<template>
  <div>
    <MenuPage />
    <div class="container py-5 px-lg-7 rounded shadow-lg">
      <h1 class="mb-2 name">상담사 소개</h1>
      <h6 class="mb-4 font">다양한 상담사들이 있다! 보고 가거라!</h6>
      <hr class="mb-5 line">
      <div class="row justify-content-center mb-5" v-for="r in counselorList" v-bind:key="r.id">
        <div class="col-lg-11">
          <div class="profile-header text-white py-4 rounded-top" style="margin-top:50px; background-color: cadetblue;">
            <div class="row align-items-center">
              <div class="col-md-4 order-md-2 text-center">
                <img :src="require('@/assets/simri2.png')" alt="Counselor Image"
                  class="img-fluid rounded-circle mb-3 shadow"
                  style="width: 250px; height: 250px; object-fit: cover;" />
              </div>
              <div class="col-md-8 order-md-1 text-white">
                <h1 class="mb-3 name">{{ r.name }}</h1>
                <p class="mb-2 font">{{ r.title }}</p><br>
                <p class="mb-3 font">{{ r.bio }}</p>

              </div>
            </div>
          </div>

          <div class="profile-body bg-white rounded p-4 mt-n5 position-relative">
            <p class="lead mb-4" style="font-weight: 500;" v-html="r.greeting"></p><br>
            <div class="row">
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">전문분야</h5><br>
                    <p class="card-text text-center">{{ r.expertise }}</p>
                  </div>
                </div>
              </div>
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">경력</h5><br>
                    <p class="card-text text-center">{{ r.experience }}년</p>
                  </div>
                </div>
              </div>
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">자격증</h5><br>
                    <p class="card-text text-center">{{ r.certifications }}</p>
                  </div>
                </div>
              </div>
              <div class="col-md-3 mb-8">
                <div class="card h-100 border-0 shadow-sm">
                  <div class="card-body d-flex flex-column align-items-center justify-content-center">
                    <h5 class="card-title font-weight-bold" style="font-weight: bold;">연락처</h5><br>
                    <a :href="'mailto:' + counselor.email" class="text-decoration-none">{{ r.email }}</a>
                  </div>
                </div>
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
  mounted() {
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

.line {
  width: 60%;
  margin: 0 auto;
}

.name {
  font-family: 'dh';
}

.font {
  font-family: 'hanna';
  font-size: larger
}

.profile {
  box-shadow: 10px black;
}

.container {
  padding: 30px;
  background-color: #f9f9f9;
  border-radius: 8px;
  max-width: 1200px;
}

.card {
  margin-bottom: 20px;
}

.card-body {
  padding: 0;
  height: 150px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(238, 238, 238, 0.3), 0 6px 20px rgba(202, 202, 202, 0.19);
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
