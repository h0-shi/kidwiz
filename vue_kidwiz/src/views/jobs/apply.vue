<template>
  <div>
    <MenuPage />
    <MyPageSecMenu />
    상담신청하기
  </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import MyPageSecMenu from '@/views/jobs/jobSecMenu.vue';

export default {
  components: {
    MenuPage,
    MyPageSecMenu
  }
};
</script>