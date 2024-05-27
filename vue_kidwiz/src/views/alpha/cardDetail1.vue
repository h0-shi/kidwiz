<template>
  <div class="mainContainer">
    <div class="info">
        <h1>{{title}}</h1>
        <div class="date">
            작성자 : 관리자 <br>
            작성일 : {{date}}
        </div>
    </div>
    
    <hr>
    <div class="cardContainer">
        <span v-for="c in card" :key="c.cn_no">
          <img :src="require(`@public/images/cardNews/${c.cn_uuid}/${c.cn_name}`)">
        </span>
    </div>
    <hr class="endLine">
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data(){
    return {
      card : [],
      title : '',
      exp : '',
      date : '',
      grade : '',
      id : '',
    }
  },
  mounted(){
    this.uuid = this.$route.query.uuid;
    axios.get("http://localhost:3000/cardDetail?uuid="+this.uuid).then((res) => {
      console.log(res.data);
      this.card = res.data;
      this.title = res.data[0].cn_title;
      this.exp = res.data[0].cn_exp;
      this.date = res.data[0].cn_date;
    })
  },
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

