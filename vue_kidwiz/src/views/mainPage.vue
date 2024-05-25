<template>
  <div>
    <Carousel></Carousel>
    <div class="main1">
      <div class="cardsBox boundary">
        
        <div class="cards block">
          <a @click="goto('contact')" class="block">
            <img src="@/assets/icon/board.png" alt="">
            <h3 class="subtit">센터 소개
              <span>KIDWIZ에 대해 소개합니다!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('test')" class="block">
            <img src="@/assets/icon/test.png" alt="">
            <h3 class="subtit">심리검사 상담
              <span>심리 검사 및 상담을 받을 수 있어요!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('GroupList')" class="block">
            <img src="@/assets/icon/group.png" alt="">
            <h3 class="subtit">집단 상담
              <span>비슷한 고민이 있는 사람들과 함께 하는 상담!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('jobs/intro')" class="block">
            <img src="@/assets/icon/job.png" alt="">
            <h3 class="subtit">취업 상담
              <span>당신의 취업을 함께 고민해요</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('regIntroduce')" class="block">
            <img src="@/assets/icon/reg.png" alt="">
            <h3 class="subtit">전문 상담
              <span>전문 상담사와 함께하는 1:1 상담</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('BoardList')" class="block">
            <img src="@/assets/sec01_chat.png" alt="">
            <h3 class="subtit">게시판 상담
              <span>게시판을 활용한 상담 문의!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('cardNews')" class="block">
            <img src="@/assets/icon/cards.png" alt="">
            <h3 class="subtit">카드뉴스
              <span>KidWiz의 소식을 접할 수 있어요!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('rsrvTest4')" class="block">
            <img src="@/assets/icon/apply.png" alt="">
            <h3 class="subtit">상담 신청
              <span>상담을 신청합니다!</span>
            </h3>
            <span class="togo">바로가기</span>
          </a>
        </div>
        <div class="cards">
          <a @click="goto('counselorList')" class="block">
            <img src="@/assets/icon/notice.png" alt="">
            <h3 class="subtit">상담사 소개
              <span>KidWiz의 상담사들을 만나봐요!</span>
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
.cards:nth-child(1):hover{background-color: #8CEEF9;}
.cards:nth-child(2):hover{background-color: #017296;}
.cards:nth-child(3):hover{background-color: #B6C4CF;}
.cards:nth-child(4):hover{background-color: #FF6C52;}
.cards:nth-child(5):hover{background-color: #00A4FB;}
.cards:nth-child(6):hover{background-color: #edbf47;}
.cards:nth-child(7):hover{background-color: #FFC143;}
.cards:nth-child(8):hover{background-color: #2E88FF;}
.cards:nth-child(9):hover{background-color: #005C83;}

.cards:nth-child(1):hover .togo {color:#8CEEF9;}
.cards:nth-child(2):hover .togo {color:#017296;}
.cards:nth-child(3):hover .togo {color:#B6C4CF;}
.cards:nth-child(4):hover .togo {color:#FF6C52;}
.cards:nth-child(5):hover .togo {color:#00A4FB;}
.cards:nth-child(6):hover .togo {color:#edbf47;}
.cards:nth-child(7):hover .togo {color:#FFC143;}
.cards:nth-child(8):hover .togo {color:#2E88FF;}
.cards:nth-child(9):hover .togo {color:#005C83;}

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
.cards img{
  filter: drop-shadow(0 0 5px white) ;
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
  width: 96px;
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