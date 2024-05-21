<template>
    <div>
      <MenuPage />
      <MyPageSecMenu />
      취업상담 안내
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