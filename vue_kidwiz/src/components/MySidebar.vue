<template>
  <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block bg-dark custom-sidebar">
    <div class="pt-5">
      <div class="user-welcome mb-4 text-light">
  <h4 class="mb-0" >
    <i class="fas fa-user-circle"></i>
    {{ $store.state.account.name }} 님 반갑습니다.
  </h4>
</div>
      </div>
      <ul class="nav flex-column" >
        <li class="nav-item" >
          <router-link class="nav-link text-light" :to="{ name: 'myinfo' }">
            <i class="fas fa-user-cog"></i>
            나의 정보 관리
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'myconsultations' }">
            <i class="fas fa-comment-alt"></i>
            나의 상담 내역
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'mygroup' }">
            <i class="fas fa-users"></i>
            비교과(집단 상담)내역
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'mysimrireserve' }">
            <i class="fas fa-calendar-alt"></i>
            심리검사 예약 내역
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'mysimri' }">
            <i class="fas fa-chart-pie"></i>
            나의 심리검사 결과
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'myqna' }">
            <i class="fas fa-question-circle"></i>
            나의 문의 내역
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'myreviews' }">
            <i class="fas fa-star"></i>
            나의 리뷰
          </router-link>
        </li>
      </ul>
  </nav>
</template>

<script>
export default {
  name: 'Sidebar'
};
</script>

<style>
/* scoped 스타일을 제거하여 전역으로 적용 */
.custom-sidebar {
  position: fixed;
  margin-top: 100px;
  top: 0;
  left: 0;
  width: 250px;
  height: 100%;
  padding-top: 1rem;
  overflow-x: hidden;
  overflow-y: auto;
  background-color: #212529;
  border-right: 1px solid #333;
}

.custom-sidebar .nav-link {
  font-weight: 500;
  color: #fff;
  display: flex;
  align-items: center;
  gap: 10px;
}

.custom-sidebar .nav-link:hover {
  color: #ddd;
}

.custom-sidebar .user-welcome {
  padding: 1rem;
  border-bottom: 1px solid #333;
}

.custom-sidebar .user-welcome h4 {
  font-size: 1.2rem;
  font-weight: bold;
  margin-bottom: 0; /* 여백을 없애기 위해 0으로 조절 */
}

.custom-sidebar .user-welcome p {
  font-size: 0.9rem;
  margin-bottom: 0; /* 여백을 없애기 위해 0으로 조절 */
}
.custom-sidebar .nav-item {
  margin-left: 40px; /* 원하는 만큼의 좌측 마진 설정 */
}
</style>