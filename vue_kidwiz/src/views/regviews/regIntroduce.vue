<template>
  <div>
    <div class="sbmContainer boundary">
        <h1 class="title">개인 상담</h1>
        <table class="subMenu">
            <tr>
                <th :style="select[0]" @click="this.$router.push('regIntroduce')">개인상담이란?</th>
                <th :style="select[1]" @click="this.$router.push('regCounselor')">상담사 소개</th>
                <th :style="select[2]" @click="displayAct(2)">여긴 뭐넣지~?</th>
                <th :style="select[3]" @click="displayAct(3)">상담 신청</th>
            </tr>
        </table>
    <section class="section s1 mt-5" :style="cssAct[0]">
        <h4 class="subt">개인 상담</h4>
        <div class="exp">
            개인상담은 혼자 해결하기 힘든 어려움이 있을 때 전문 상담사와 1:1 만남을 통해 함께 문제를 생각해보면서 문제해결 뿐만 아니라 자기에 대한 이해와 사랑을 넓혀가는 자기성장의 과정입니다. <br>
            학생상담센터에서는 다양한 호소문제들을 다루고 있습니다.<br>
            예: 우울, 불안과 같은 정서적 어려움, 성격문제, 대인관계, 행동 및 습관의 문제, 성(性) 및 이성문제, 가정문제- 가정 내 스트레스, 성적 및 시험불안, 전공 선택 및 졸업 후 진로문제 등            
        </div>
        <div class="expBox mt-3">
            <span class="exp inBox" style="color:blue;">* 상담 신청 시 진행절차 안내</span>
            <span class="exp inBox mb-1" style="font-weight: bold;">: 신청서 확인 ▶ 접수면담(30-50분) ▶ 심리검사 실시 ▶ 상담자 배정 ▶ 12회기 상담</span>
            <span class="exp inBox mb-1">1) 상담신청서 작성 이후 접수면담 시간을 정하기 위한 연락을 받게 됩니다. 접수면담 일정이 확정이 되어야 상담 예약이 완료됩니다.</span>
            <span class="exp inBox mb-1">2) 접수 면담 후에 상담자의 안내에 따라 검사를 실시합니다.</span>
            <span class="exp inBox mb-1">3) 검사 실시가 완료되면, 상담자가 배정됩니다(대기가 많다면, 1-2주 소요될 수 있어요).</span>
            <span class="exp inBox mb-1">4) 배정된 상담자에게 연락이 오면, 첫상담 일정을 잡고 꾸준히 상담을 받아요 :)</span>
        </div>
        <div class="mt-5">
            <h4 class="subt">상담 진행 절차</h4>
            <img src="@/assets/img/process.png" alt="" class="processImg">
        </div>
    </section>
</div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            act : "none",
            cssAct: [
                {display : "none"},
                {display : "none"},
                {display : "none"},
                {display : "none"}
            ],
            select: [
                {},
                {},
                {},
                {}
            ],
        }
    },
    mounted(){
        this.cssAct[0] = {display:"block"};
        this.select[0] = {border:"2px solid rgb(43, 43, 165", 'border-bottom':"none"};
    },
    methods:{
        displayAct(num){
            this.cssAct = this.cssAct.map((style, i) => {
            if(i == num){
                return {display:"block"};                
            }
            return {display:"none"};
        })
            this.select = this.select.map((style, i)=> {
                if(i==num){
                    return {border:"2px solid rgb(43, 43, 165", 'border-bottom':"none"};
                }
            })
        }
    },

}
</script>

<style scoped>
.processImg{
    width: 100%;
    margin: 40px 0 ;
}
.sbmContainer{
    width: 100%;
    margin-bottom: 50px;
}
.subMenu{    
    width: 100%;
    margin: auto;
}
.subMenu tr th{
    width: 25%;
    height: 55px;
    border-bottom: 2px solid rgb(43, 43, 165);
}
.boundary{
    width: 100%;
    max-width: 1200px;
    padding: 0 auto;
}
.title{
  text-align: left;
  font-family: 'sj';
  margin-left: 15px;
  margin-bottom: 40px;
}
.subt{
  text-align: left;
  font-family: 'sj';
  margin-bottom: 10px;
}
.exp{
    font-size: 83%;
    text-align: left;
    line-height: 1.65;
}
.expBox{
    background-color: #eef1f6;
    border: 3px solid #dbe1e8;
}
.inBox{
    display: block;
    text-align: left;
    margin-left: 10px;    
}
</style>