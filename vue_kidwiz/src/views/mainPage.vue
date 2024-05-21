<template>
  <div>
    <Carousel></Carousel>
    <div class="main1">
      <div class="cardsBox boundary">
        
        <div class="cards block">
          <a @click="goto('BoardList')" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">게시글 상담
              <span>사람들과 소통하는 공간</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('cardNews')" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">카드뉴스
              <span>카드뉴스를 볼 수 있어요!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('simrimain')" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">심리 상담
              <span>심리 검사와 함께 하는 상담</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('jobs/intro')" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">취업 상담
              <span>당신의 취업을 함께 고민해요</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('rsrvTest4')" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">상담 신청
              <span>여기서 상담 신청</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto()" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">채팅상담
              <span>박시호가 테스트중</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto()" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">채팅상담
              <span>박시호가 테스트중</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto()" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">채팅상담
              <span>박시호가 테스트중</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto()" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">채팅상담
              <span>박시호가 테스트중</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        
      
      </div>
    </div>
  </div>
</template>

<script>
import Carousel from '@/components/Carousel.vue';
export default {
  components:{
    Carousel
  },
  methods : {
    goto(link){
      this.$router.push('/'+link);
    }
  },
}
</script>

<style>
.bannerImg{
  width: 100%;
  height: 250px;
  overflow: hidden;
}
.bannerImg img{
  max-width: 100%;
  height: auto;
  object-fit: cover;
}
.boundary{
  width: 100%;
  max-width: 1200px;
  padding: 0;
  margin: 0 auto;
}
.cardsBox{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
.main1{
  margin: 5em 0 3em;
}
.cards{
  position: relative;
  height: 260px;
  width: 32.33%;
  box-sizing: border-box;
  margin-bottom: 1em;
  text-align: center;
  background: #f0f4ff;
  border-radius: 15px;
  transition: all 0.5s;
  background-color: f0f4ff;
}
.cards:nth-child(1):hover{background-color: #edbf47;}
.cards:nth-child(2):hover{background-color: #edbf47;}
.cards:nth-child(3):hover{background-color: #edbf47;}
.cards:nth-child(4):hover{background-color: #edbf47;}
.cards:nth-child(5):hover{background-color: #edbf47;}
.cards:nth-child(6):hover{background-color: #edbf47;}
.cards:nth-child(7):hover{background-color: #edbf47;}
.cards:nth-child(8):hover{background-color: #edbf47;}
.cards:nth-child(9):hover{background-color: #edbf47;}

.cards:nth-child(1):hover .togo {color:#edbf47;}
.cards:nth-child(2):hover .togo {color:#edbf47;}
.cards:nth-child(3):hover .togo {color:#edbf47;}
.cards:nth-child(4):hover .togo {color:#edbf47;}
.cards:nth-child(5):hover .togo {color:#edbf47;}
.cards:nth-child(6):hover .togo {color:#edbf47;}
.cards:nth-child(7):hover .togo {color:#edbf47;}
.cards:nth-child(8):hover .togo {color:#edbf47;}
.cards:nth-child(9):hover .togo {color:#edbf47;}

.cards:hover {
	color:#fff;
	transition:all 0.5s;
}
.cards:hover a,
.cards:hover h3 span {
	color:#fff;
	text-shadow:0px 0px 3px rgba(0,0,0,0.5);
}
.cards:hover .togo {
	font-weight:bold;
	background:#fff;
	text-shadow:none;
}
.block{
  display: block;
}
.cards a{
  padding: 2em;
  text-decoration: none;
}
.block img{
  display: inline-block;
  max-width: 100%;
  vertical-align: center;
}
.cards h3{ 
  padding-top: 0.8em;
  font-size: 1.1em;
  font-family: 'NanumSquareRound', 'NotoSansKR', 'NanumGothic', sans-serif;
  font-weight: bold;
}
.cards h3 span{
  display: block;
  margin-top: 0.3em;
  padding-top: 0.2em;
  font-size: 0.75em;
  color: #666;
  font-family: 'Noto Sans KR';
  font-weight: 400;
}
.togo{
  display: inline-block;
  padding: 0.2em 2em;
  margin-top: 1em;
  color: #333;
  background-color: #fff;
  border: 2px solid black;
  border-radius: 30px;
}
</style>