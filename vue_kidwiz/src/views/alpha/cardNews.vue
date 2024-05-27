<template>
  <div class="mainContainer">
    <h1>상담 카드뉴스</h1>        
    <hr class="line">
    <button v-if="grade>=2" @click="write" class="writeBtn mb-5">카드뉴스 작성</button>
    <div class="cardContainer">
        <div class="cardsNews" v-for="c in list" :key="c.cn_no" @click="gotoCard(c)">
            <img :src="require(`@public/images/cardNews/${c.cn_uuid}/${c.cn_name}`)" class="thumbNail">
            <div class="title">{{ c.cn_title }}</div>
            <div class="exp">{{c.cn_exp}}</div>
            <div class="date">{{c.cn_date}}</div>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            list : [],
            grade: '',
        }
    },
    mounted(){
        axios.get("http://localhost:3000/getCardNews").then((res) => {
            this.list = res.data;
            console.log(res.data);
        }),
        axios.get("http://localhost:3000/memberDetail?id="+this.$store.state.account.id).then((res) => {            
            this.grade = res.data[0].grade;
        }).catch((err) => {
            console.log("로그아웃상태"+err);
        })
    },
    methods: {
        gotoCard(c){
            this.$router.push("/cardDetail1?uuid="+c.cn_uuid);
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
    text-align: left; /* 왼쪽 정렬 */
}
.line{
    margin: 35px 0;
}
.cardContainer{
    width: 100%;  
    margin: 0 auto;  
    display: flex;
    flex-wrap: wrap;
}
.cardsNews{
    width: 28%;
    margin: 20px;
    border-radius: 8px;
    background-color: white;
    color: black;
    box-shadow: 10px black;
}
.writeBtn{
    width: 80%;
    height: 40px;
    border-radius: 5px;
    background-color: #67BF4E;   
    color : white;
    border: 1px solid white;
}
.cardsNews:hover{
    transition: 0.3s;
    background-color: #67BF4E;    
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