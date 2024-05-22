<template>
  <div class="mainContainer">
    <div class="info">
        <h1>상담이 뭐죠?</h1>
        <div class="date">
            작성자 : 관리자 <br>
            작성일 : 2024-05-18
        </div>
    </div>
    
    <hr>
    <div class="cardContainer">
        <img src="@/assets/card02/001.png" alt="">
        <img src="@/assets/card02/002.png" alt="">
        <img src="@/assets/card02/003.png" alt="">
        <img src="@/assets/card02/004.png" alt="">
        <img src="@/assets/card02/005.png" alt="">
    </div>
    <hr class="endLine">
  </div>
</template>

<script>
export default {
  methods: {
    gotoCard() {
      this.$router.push("/cardDetail");
    },
  },
};
</script>

<style scoped>
@font-face {
    font-family: 'dh';
    src: url('@/assets/font/BMDOHYEON_ttf.ttf');
}
.info h1{
    font-family: 'dh';
}
.mainContainer {
  width: 100%;
  max-width: 1000px;
  margin: 0 auto;
}
.cardContainer {  
  display: block;
  justify-content: center;
  
}
.cardContainer img{
  width: 700px;
  height: 700px;
  margin-top: 30px;
}
.cardsNews {
  width: 28%;
  border-radius: 5px;
  background-color: white;
  color: black;
}
.cardsNews:hover {
  transition: 0.3s;
  background-color: #ae68f0;
}
.cardsNews:hover > * {
  transition: 0.3s;
  color: white;
}
.thumbNail {
  width: 100%;
}
.title {
  margin: 5px 0 0 5px;
  text-align: left;
  font-weight: 900;
  font-size: large;
}
.exp {
  margin: 5px 0 0 5px;
  font-size: smaller;
  text-align: left;
  color: grey;
}
.date {
  text-align: right;
  margin-right: 15px;
  font-size: smaller;
  text-align: right;
  color: grey;
}
.endLine{
    margin-top: 30px;
}
</style>
