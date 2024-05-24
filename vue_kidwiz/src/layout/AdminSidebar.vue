<template>
  <!-- navbar -->
  <nav class="navBody navbar navbar-expand navbar-light" style="padding: 0px;">
    <button class="navbar-toggler ml-auto mb-2 bg-light" data-toggle="collapse" data-target="#sidebar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="sidebar">
      <div class="container-fluid">
        <div class="row">
          <div class="col-xl-2 col-lg-3 sidebar position-fixed">
            <router-link to="/admin" class="navbar-brand text-white text-center d-block mx-auto py-3 mb-4 bottom-border">KIDWIZ</router-link>
            <div class="bottom-border pb-3">
              <h5 class="text-white">{{$store.state.account.id}}</h5>
            </div>
            <ul class="navbar-nav flex-column mt-4">
              <li class="nav-item">
                <router-link class="nav-link p-3 mb-2 text-white sidebar-link" to="/" >
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house me-2" viewBox="0 0 16 16">
                    <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"/>
                  </svg>HOME</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link p-3 mb-2 text-white sidebar-link current" to="/adminMemberControl" @click="changeButton($event)">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person me-1" viewBox="0 0 16 16">
                    <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
                  </svg>
                  회원 관리</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link p-3 mb-2 text-white sidebar-link" to="/adminBoardControl"  @click="changeButton($event)">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard-check me-1" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1z"/>
                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0z"/>
                  </svg>
                게시판 관리</router-link>
              </li>
              <!-- <li class="nav-item">
                <router-link class="nav-link p-3 mb-2 text-white sidebar-link" to="/adminBoardControl"  @click="changeButton($event)">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard-check me-1" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1z"/>
                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0z"/>
                  </svg>
                상담 관리</router-link>
              </li> -->
            </ul>
          </div>

          <div class="col-xl-10 col-lg-9 ml-auto bg-dark py-2 content-area fixed-top">
            <div class="row">
              <div class="col-md-4">
              </div>
              <div class="col-md-5">

              </div>
              <div class="col-md-3">
                <a style="float: right;">
                  <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-list text-white" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"></path>
                  </svg>
                </a>
              </div>
            </div>
          </div>
        </div>
        <div class="applyBoard pt-3">
            <router-view></router-view>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "MyComponent",
  methods: {
    changeButton(event) {
      // 클릭된 요소에 'current' 클래스 추가
      const clickedElement = event.target.closest('.sidebar-link');

      if (clickedElement) {
        // 나머지 요소들에서 'current' 클래스 제거
        const links = document.querySelectorAll('.sidebar-link');
        links.forEach(link => {
          link.classList.remove('current');
        });

        // 클릭된 요소에 'current' 클래스 추가
        clickedElement.classList.add('current');
      }
    }
  },
  mounted() {
    // 이벤트 위임 설정
    document.querySelector('.navbar-nav').addEventListener('click', this.changeButton);
  },
  beforeUnmount() {
    // 이벤트 위임 해제
    document.querySelector('.navbar-nav').removeEventListener('click', this.changeButton);
  }
}
</script>

<style>
.sidebar {
  background-color: black;
  height: 100vh;
}

.bottom-border {
  border-bottom: 2px groove #eee;
}

.sidebar-link {
  transition: all .3s;
}

.sidebar-link:hover {
  background-color: #444;
  border-radius: 5px;
}

.current {
  background-color: green !important;
  border-radius: 7px;
  box-shadow: 2px 5px 10px #111;
}

.current:hover {
  background-color: rgb(47, 180, 47);
  border-radius: 7px;
  box-shadow: 2px 5px 10px #111;
  transform: translate(-1px);
}

.content-area, .applyBoard  {
  margin-left: 16.67%; /* Adjusted for col-xl-2 */
}

@media (min-width: 992px) and (max-width: 1199px) {
  .content-area, .applyBoard {
    margin-left: 25%; /* Adjusted for col-lg-3 */
  }
}

.applyBoard {
  margin-top: 55px;
}
</style>