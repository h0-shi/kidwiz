<template>
  <div>
    <MenuPage></MenuPage>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import Footer from '@/components/Footer.vue';

export default {
  name:'MainLayout',
  components:{
    
    MenuPage,
    Footer
  }

}
</script>

<style>

</style>