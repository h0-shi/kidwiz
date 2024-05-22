<template>
  <div>
    <MenuPage/>
    <div class="container-fluid mt-5 pt-4">
      <div class="row">
        <MySidebar></MySidebar>
        <main class="main-content">
        <h1 class="mb-4">마이페이지입니다</h1>
          <div class="mt-4">
            <p>현재 로그인한 사용자 id: <strong>{{ $store.state.account.id }}</strong></p>
            <p>현재 로그인한 사용자 email: <strong>{{ $store.state.account.email }}</strong></p>
            <p>현재 로그인한 사용자 name: <strong>{{ $store.state.account.name }}</strong></p>
          </div>

      </main>
      </div>
    </div>
  </div>
</template>

<script>
import MySidebar from '@/components/MySidebar.vue';
import MenuPage from '@/components/MenuPage.vue';


export default {
  name: 'MyPage',
  components: {
    MySidebar,
    MenuPage
  }
}
</script>

<style scoped>
.container-fluid {
  padding-top: 56px; 
}
.sidebar {
  position: -webkit-sticky;
  position: sticky;
  top: 0;
  height: calc(100vh - 56px);
  padding-top: 1rem;
  overflow-x: hidden;
  overflow-y: auto; 
}
.sidebar .nav-link {
  font-weight: 500;
  color: #333;
}
.sidebar .nav-link:hover {
  color: #007bff;
}
</style>
