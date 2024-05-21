<template>
  <div class="mainContainer">
    <h1>상담 카드뉴스</h1>
    <hr class="line">
    <div class="cardContainer">
        <div class="cardsNews" @click="gotoCard(1)">
            <img src="@/assets/card01/001.png" class="thumbNail">
            <div class="title">상담 좋아하세요?</div>
            <div class="exp">당신은 상담을 좋아하십니까?</div>
            <div class="date">2024-05-21</div>
        </div>
        <div class="cardsNews" @click="gotoCard(2)">
            <img src="@/assets/card02/001.png" class="thumbNail">
            <div class="title">상담이 뭐죠?</div>
            <div class="exp">상담에 대해 알아보아요!</div>
            <div class="date">2024-05-18</div>
        </div>
        <div class="cardsNews" @click="gotoCard(3)">
            <img src="@/assets/card03/001.png" class="thumbNail">
            <div class="title">또래상담사를 모집해요!</div>
            <div class="exp">또래 상담사가 되어 저희와 함께해주세요!</div>
            <div class="date">2024-04-12</div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    methods: {
        gotoCard(n){
            this.$router.push("/cardDetail"+n);
        },
        write(){
            this.$router.push("/cardWrite");
        }
    }
}
</script>

<style scoped>
.mainContainer{
    width: 100%;
    max-width: 1000px;
    margin: 0 auto;
}
.mainContainer h1{
    font-family: 'dh';
}
.line{
    margin: 35px 0;
}
.cardContainer{
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.cardsNews{
    width: 28%;
    border-radius: 8px;
    background-color: white;
    color: black;    
}
.cardsNews:hover{
    transition: 0.3s;
    background-color: #ae68f0;    
}
.cardsNews:hover > *{
    transition: 0.3s;
    color: white;
}
.thumbNail{
    width: 100%;
    border-radius: 8px 8px 0 0;
}
.title{    
    margin: 5px 0 0 5px;
    text-align: left;
    font-weight: 900;
    font-size: large;
}
.exp{
    margin: 5px 0 0 5px;
    font-size: smaller;
    text-align: left;
    color: grey;
}
.date{
    margin-right: 5px;
    font-size: smaller;
    text-align: right;
    color: grey;
}

</style>