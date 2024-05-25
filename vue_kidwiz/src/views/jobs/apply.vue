<template>
  <div>
    <MenuPage />
    <div class="boundary">
      <h1 class="title">취업 상담</h1>
      <jobSecMenu />
      <div class="container">
        <!-- 이미지 경로 -->
        <img :src="require(`@/assets/jobsapply.png`)" class="enlarged-image" />
      </div>
      <div class="text-center mt-5">
        <button @click="contactCounselor" class="btn btn-primary btn-lg btn-block shadow-sm">
          상담 요청
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import MenuPage from "@/components/MenuPage.vue";
import jobSecMenu from "@/views/jobs/jobSecMenu.vue";

export default {
  name: "CounselingInfo",
  components: {
    MenuPage,
    jobSecMenu,
  },
  methods: {
    contactCounselor() {
      this.$router.push("/rsrvTest4?selectedCounselingType=취업상담");
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.enlarged-image {
  width: 100%; /* 원래 비율을 유지하면서 확대 */
  max-width: 1200px; /* 최대 너비를 설정 (원하는 크기로 조정 가능) */
  height: auto;
}
.btn-primary {
    font-size: 1.2rem;
    background-color: #67BF4E;
    border: #67BF4E;
}
.btn-primary:hover {
  background-color: #3f8531; /* 변경된 색상 */
  border-color:  #3f8531; /* 변경된 색상 */
}
</style>