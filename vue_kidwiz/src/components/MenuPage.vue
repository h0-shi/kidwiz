<template>
<div>
  <header>

    <div class="nav">
      <nav class="nav-top">
        <span class="top-left">
          <a href="">home</a>
          <a href="">facebook</a>
        </span>
        <span class="mainImg">
          <h1>
            <router-link to="/">
              대충 대표 이미지
            </router-link>
          </h1>
        </span>
        <span class="top-right">
          <a href="">로그인</a>
          <a href="">회원가입</a>
        </span>
      </nav>
              <!-- <ul>
          <li><router-link to="/listTest">공지사항</router-link></li>
          <li><router-link to="/BoardList">상담</router-link></li>
          <li><router-link to="/insertTest">상담 정보</router-link></li>
          <li><router-link to="/regRev">미디어 콘텐츠</router-link></li>
          <li><router-link to="/rsrvTest4">소통/참여</router-link></li>
          <li><router-link to="/testVue">테스트뷰</router-link></li>
          <li><router-link to="/listTest">DB테스트</router-link></li>
          <li><router-link to="/BoardList">박선우</router-link></li>
          <li><router-link to="/insertTest">insert 테스트</router-link></li>
          <li><router-link to="/regRev">박시호</router-link></li>
          <li><router-link to="/rsrvTest4">예약테스트</router-link></li>
          <li><router-link to="/GroupList">박선우 집단</router-link></li>
          <li><router-link to="/jobConsulting">취업상담</router-link></li>
          <li><router-link to="/jobConsultingSim">취업상담(직업심리검사)</router-link></li>
          <li v-if="$store.state.account.id"><router-link to="/mypage">마이페이지</router-link></li>
          <li>
          <router-link to="/login" v-if="!$store.state.account.id">로그인</router-link>
          <a to="/login" @click="logout()" v-else>로그아웃</a>
          </li>
          <li><router-link to="/">Home</router-link></li>
          <li><router-link to="/counseling">심리상담 안내</router-link></li>
          <li><router-link to="/counselorshow">상담사 소개</router-link></li>
          <li><router-link to="/test">Test</router-link></li>
          <li><router-link to="/faq">FAQ</router-link></li>
          <li><router-link to="/contact">Contact</router-link></li>
          <li><router-link to="/admin">관리자페이지</router-link></li>
        </ul> -->
      <nav class="nav-bot">
        <div class="container">
          <nav class="container d-flex flex-column flex-md-row justify-content-between">
            <router-link class="py-2 d-none d-md-inline-block flex-fill" to="/BoardList">센터 소개</router-link>
            <router-link class="py-2 d-none d-md-inline-block flex-fill" to="/BoardList">상담실</router-link>
            <router-link class="py-2 d-none d-md-inline-block flex-fill" to="/BoardList">소통/참여</router-link>
            <router-link class="py-2 d-none d-md-inline-block flex-fill" to="/BoardList">미디어콘텐츠</router-link>
          </nav>
        </div>
      </nav>
      <nav class="nav-menu">
        <div class="container">
          <nav class="container d-flex flex-column flex-md-row justify-content-between">
            <ul class="divUl py-2 d-none d-md-inline-block flex-fill">
              <li><router-link to="listTest">공지사항</router-link></li>
              <li><router-link to="/">이용안내</router-link></li>
              <li><router-link to="faq">자주하는 질문<br>(FAQ)</router-link></li>
            </ul>
            <ul class="divUl py-2 d-none d-md-inline-block flex-fill move-left">
              <li><router-link to="/">전문상담</router-link></li>
              <li><router-link to="/BoardList">게시판상담</router-link></li>
              <li><router-link to="/">지도상담</router-link></li>
              <li><router-link to="/GroupList">집단상담</router-link></li>
              <li><router-link to="/counseling">심리상담</router-link></li>
            </ul>
            <ul class="divUl py-2 d-none d-md-inline-block flex-fill move-left">
              <li><router-link to="/">이벤트</router-link></li>
            </ul>
            <ul class="divUl py-2 d-none d-md-inline-block flex-fill">
              <li><router-link to="/">카드뉴스</router-link></li>
              <li><router-link to="/">성장통</router-link></li>
            </ul>
          </nav>
        </div>
      </nav>
    </div>
  </header>
  <div class="mainContainer">
    <main>
      <slot />
    </main>
  </div>
</div>
</template>


<script>
import store from "@/views/store";
import router from '@/router'
import axios from 'axios';

export default {
    name:'MenuPage',
    setup() {
      const logout = () => {
        axios.post("http://localhost:3000/api/account/logout", {}, { withCredentials: true })
        .then(()=>{
        store.commit('setAccount', 0);
        sessionStorage.removeItem("id");
        router.push({path: '/'});
        });
      }
      return {logout}
    }
}
</script>

<style scoped>
.nav{
  top: 0;
  width: 100%;
  background-color: skyblue;
}
.nav-top{
  height: 80px;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.nav-bot{
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50px;
  width: 100%;
  background-color: grey;
  float: hide;
}
.nav-bot ul{
  margin:0px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.nav-bot ul li{
  
  list-style-type: none;
  text-decoration: none;
  float: left;
  margin: 0 5px;
}
.nav-menu{
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50px;
  width: 100%;
  float: hide;
  height: 100%;
}
.nav-menu ul{
  list-style-type: none;
  text-decoration: none;
}
.top-left{
  margin-right: auto;
}
.top-right{
  margin-left: auto;
}
.nav-top a{
  margin: 0 10px;
  text-decoration: none;
}
.mainImg{
  flex: 1;
  text-align: center;
}

a{
  text-decoration: none;
  cursor: pointer; /* 커서 스타일 추가 */
}
a:link {
  color : black;
}
a:visited {
  color : black;
}
a:hover {
  color : black;
}
a:active {
  color : black;
}

.nav-menu .move-left{
  margin-left:-65px;
}

.divUl{
  display: flex;
  align-content: flex-start;
  flex-direction: column;
  flex-wrap: wrap;

  
  list-style: none;
  padding: 0px;
  margin-left: -30px;
}
.divUl li {
  margin-bottom:10px;
}
.parentsDiv{
  display: flex;
}

</style>




