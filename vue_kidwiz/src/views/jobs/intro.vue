<template>
  <div>
    <MenuPage />
    <div class="boundary">
      <h1 class="title">취업 상담</h1>
      <jobSecMenu />
      <div class="container py-5">
        <!-- 이미지 경로 -->
        <img :src="require(`@/assets/jobsintro.png`)" class="enlarged-image" />
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
  height: auto; /* 자동 높이 조절 */
}
</style>