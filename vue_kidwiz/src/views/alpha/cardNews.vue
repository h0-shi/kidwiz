<template>
  <div class="mainContainer">
    <h1>상담 카드뉴스</h1>
    <div class="cardContainer">
        <div class="cardsNews" @click="gotoCard()">
            <img src="@/assets/card01/001.png" class="thumbNail">
            <div class="title">상담이 뭐죠?</div>
            <div class="exp">상담에 대해 알아보아요!</div>
            <div class="date">2024-05-21</div>
        </div>
        <div class="cardsNews" @click="gotoCard()">
            <img src="@/assets/card01/001.png" class="thumbNail">
            <div class="title">상담이 뭐죠?</div>
            <div class="exp">상담에 대해 알아보아요!</div>
            <div class="date">2024-05-21</div>
        </div>
        <div class="cardsNews" @click="gotoCard()">
            <img src="@/assets/card01/001.png" class="thumbNail">
            <div class="title">상담이 뭐죠?</div>
            <div class="exp">상담에 대해 알아보아요!</div>
            <div class="date">2024-05-21</div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    methods: {
        gotoCard(){
            this.$router.push("/cardDetail");
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
.cardContainer{
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.cardsNews{
    width: 28%;
    border-radius: 5px;
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