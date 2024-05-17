<template>
  <div>
    <HeaderMenu></HeaderMenu>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
import HeaderMenu from '@/components/HeaderMenu.vue';
import Footer from '@/components/Footer.vue';

export default {
  name:'MainLayout',
  components:{
    
    HeaderMenu,
    Footer
  }

}
</script>

<style>

</style>