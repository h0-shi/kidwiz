<template>

  <header data-bs-theme="dark">
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <router-link class="navbar-brand" :to="{path:'/'}">KIDWIZ</router-link>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <router-link class="nav-link" :to="{path:'/'}">센터소개</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" :to="{path:'/'}">공지사항</router-link>
          </li>

          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" :class="clicked ? 'show' : ''" data-bs-toggle="dropdown" aria-expanded="true" @click.prevent="ontoggle">상담</a>
          <ul class="dropdown-menu" :class="clicked ? 'show' : ''" data-bs-popper="static">
            <li><router-link class="dropdown-item" :to="{path:'/BoardList'}">게시판 상담</router-link></li>
            <li><router-link class="dropdown-item" :to="{path:'/'}">지도교수 상담</router-link></li>
            <li><router-link class="dropdown-item" :to="{path:'/GroupList'}">집단 상담</router-link></li>
            <li><router-link class="dropdown-item" :to="{path:'/'}">심리 상담</router-link></li>
          </ul>
        </li>
        <li class="nav-item">
            <router-link class="nav-link" :to="{path:'/login'}">로그인</router-link>
          </li>
          <li v-if="$store.state.account.id"><router-link to="/mypage">마이페이지</router-link></li>


        </ul>
      </div>
    </div>
  </nav>
</header>


</template>

<script>

export default {
  name:'HeaderMenu',
  data() {
    return {
      clicked: false,
    };
  },
  methods: {
    ontoggle() {
      this.clicked = !this.clicked;
    },
  },
};
</script>

<style>

</style>