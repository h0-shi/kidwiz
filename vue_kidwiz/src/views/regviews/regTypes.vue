<template>
  <div>
    <div class="sbmContainer boundary">
        <h1 class="title">전문 상담</h1>
        <table class="subMenu">
            <tr>
                <th :style="select[0]" @click="this.$router.push('regIntroduce')">전문상담이란?</th>
                <th :style="select[1]" @click="this.$router.push('regCounselor')">상담사 소개</th>
                <th :style="select[2]" @click="this.$router.push('regTypes')">상담 종류</th>
                <th :style="select[3]" @click="this.$router.push('rsrvTest4?selectedCounselingType=전문상담')">상담 신청</th>
            </tr>
        </table>
    <section class="section s1 mt-5" :style="cssAct[0]">
        <h4 class="subt mb-5">상담 종류</h4>
        <div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/1.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">스트레스 관리</div>
                    <div class="imgContent">일상생활과 직장에서의 스트레스를 효과적으로 관리하고, 스트레스 해소 기법을 배우는 상담입니다.</div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/2.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">불안 및 공황장애</div>
                    <div class="imgContent">불안 장애와 공황 발작의 원인을 이해하고, 이를 관리하고 극복하는 방법을 탐색합니다.</div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/3.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">우울증</div>
                    <div class="imgContent">
                        우울증의 증상과 원인을 파악하고, 심리 치료와 생활 습관 변화를 통해 극복할 수 있도록 돕습니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/4.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">대인관계 문제</div>
                    <div class="imgContent">
                        가족, 친구, 동료와의 관계에서 발생하는 갈등과 소통 문제를 해결하고, 건강한 대인 관계를 유지하는 방법을 찾습니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/5.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">자기계발 및 자존감 향상</div>
                    <div class="imgContent">
                        자존감을 높이고, 개인적인 목표를 설정하며, 자기 계발을 위한 실질적인 방법을 제공합니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/6.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">트라우마 및 PTSD</div>
                    <div class="imgContent">
                        과거의 트라우마와 외상 후 스트레스 장애(PTSD)를 다루고, 이를 치유하는 과정을 지원합니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/7.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">직장 스트레스 및 번아웃</div>
                    <div class="imgContent">
                        직장에서의 스트레스, 번아웃, 경력 전환 등의 문제를 다루고, 직장 생활의 만족도를 높이는 방법을 모색합니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/8.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">슬픔 및 상실</div>
                    <div class="imgContent">
                        사랑하는 사람을 잃은 후 겪는 슬픔과 상실의 감정을 다루고, 이를 극복하는 과정을 지원합니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/9.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">이성관계 상담</div>
                    <div class="imgContent">
                        이성친구와의 소통 문제, 갈등 해결, 관계 개선을 위한 상담을 제공합니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/10.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">가족 관계 상담</div>
                    <div class="imgContent">
                        가족 구성원 간의 갈등, 소통 문제, 다양한 가족 문제를 해결하기 위한 상담입니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/11.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">분노 관리</div>
                    <div class="imgContent">
                        분노의 원인을 이해하고, 분노를 건강하게 표현하고 관리하는 기술을 배우는 상담입니다.
                    </div>
                </div>
            </div>
            <div class="imgBox mb-5">
                <img src="@/assets/ctypes/12.png" class="cImg">
                <div class="imgSec">
                    <div class="imgTitle">중독 및 의존문제</div>
                    <div class="imgContent">
                        알코올, 약물, 도박 등 중독 문제를 해결하고, 건강한 생활 방식을 찾도록 돕는 상담입니다.
                    </div>
                </div>
            </div>
            
            
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
        this.select[2] = {border:"2px solid #67BF4E", 'border-bottom':"none"};
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
    border-bottom: 2px solid #67BF4E;
}
.subMenu:hover{
  cursor: pointer;
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
.imgTitle{
    text-align: left;
    font-family: 'sj';
    margin-left: 15px;
    margin-bottom: 40px;
    font-size: 40px;
    text-align: left;    
}
.imgContent{
    text-align: left;
    font-family: 'pr';
    margin-left: 15px;
    margin-bottom: 40px;
    font-size: 25px;
    text-align: left;    
}
.cImg{
    width: 250px;
    border-radius: 50%;
    margin: 0 auto;
}
.imgBox{
    display: flex;
    justify-content: space-between;
    margin-bottom: 40px;
}
.imgSec{
    width: 100%;
    margin: auto 0;
    margin-left: 15px;
}
</style>