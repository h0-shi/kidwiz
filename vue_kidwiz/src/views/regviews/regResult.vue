<template>
  <div class="mainContainer boundary">
    <h1>상담 일지</h1>
    <div class="formContainer">
    <form action="" class="result">
        <table class=formTable>
            <colgroup>
                <col style="width:16%">
                <col style="width:34%">
                <col style="width:16%">
                <col style="width:34%">
            </colgroup>
            <tbody>
                <tr class="cellType">
                    <th colspan="4">내담자 정보</th>
                </tr>
                <tr>
                    <th>내담자 성명</th>
                    <td>{{stuName}}</td>
                    <th>학번</th>
                    <td>{{stuNum}}</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td v-if="gender==='F'">여성</td>
                    <td v-if="gender==='M'">남성</td>
                    <th>소속</th>
                    <td>{{major}}</td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>{{birth_date}}</td>
                    <th>연락처</th>
                    <td>{{contact}}</td>
                </tr>
                <tr class="cellType">
                    <th colspan="4">상담 정보</th>
                </tr>
                <tr>
                    <th>상담일</th>
                    <td>{{ date }}</td>
                    <th>상담자</th>
                    <td>{{proName}}</td>
                </tr>
                <tr>
                    <th>상담 시간</th>
                    <td>{{time}}</td>
                    <th>상담 회기</th>
                    <td>{{times}}/{{totalTimes}} 회기</td>
                </tr>
                <tr class="cellType">
                    <th colspan="4">상담 일지</th>
                </tr>
                <tr>
                    <th>회기 상담 목표</th>
                    <td colspan="3">{{goal}}</td>
                </tr>
                <tr>
                    <th class="resultContent">진행 내용</th>
                    <td colspan="3" v-html="content">
                        
                    </td>
                </tr>
                <tr>
                    <th>회기 요약</th>
                    <td colspan="3">
                        {{summary}}                            
                    </td>  
                </tr>
                <tr>
                    <th>회기 과제</th>
                    <td colspan="3">
                        {{homework}}                            
                    </td>  
                </tr>
                <tr class="opinion">
                    <th>상담사 의견</th>
                    <td colspan="3">{{opinion}}</td>
                </tr>
            </tbody>
        </table>      
        <section class="btns">
            <button class="button save" @click="update()">수정하기</button>            
        </section>  
        
    </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{
            stuName : '',
            date: '',
            time: '',
            major : '',     
            regno : '',
            stuNum: '',
            goal: '',
            content:'',
            summary:'',
            homework:'',
            opinion:'',
            gender:'',
            birth_date:'',
            times:'',
            totalTimes:'',            
            contact:'',
            proName:'',
        }
    },
    mounted() {
        this.regno = this.$route.query.regno;
        axios.get('http://localhost:3000/getRegResult?regno='+this.regno).then((res) => {        
            console.log(res.data[0]);
            this.stuName = res.data[0].name;
            this.date = res.data[0].date;
            this.time = res.data[0].time;
            this.major = res.data[0].major_name;
            this.stuNum = res.data[0].stuNum;
            this.goal = res.data[0].goal;
            this.homework = res.data[0].homework;
            this.content = res.data[0].content;
            this.summary = res.data[0].summary;
            this.opinion = res.data[0].opinion;
            this.gender = res.data[0].gender;
            this.birth_date = res.data[0].birth_date;
            this.times = res.data[0].times;
            this.totalTimes = res.data[0].totalTimes;
            this.contact = res.data[0].contact;
            this.proName = res.data[0].proName;            
        }).catch((err) => {
            console.log(err+'에러디')
        })
    },
    methods : {
        update(){
            if(confirm("일지를 수정하시겠습니까?")){
                this.$router.push("/resultUpdate?regno="+this.regno);
            }
        },
    }
}
</script>

<style>
.boundary{
    max-width: 1000px;
}
.formContainer{
    background-color: rgb(255, 255, 255);
    border: 1px soild black;
}
.formTable{
    width: 100%;
    text-align: center;    
}
.resultContent{
    height: 500px;    
}
.opinion{
    height: 150px;
    width: 100%;
}
.formTable tr{
    height: 50px;
    border-bottom: 1px solid #d1d1d1;
    font-size: small;
}
.formTable tr td{
    text-align: left;
}
.summary{
    height: 100px;
}
.cellType{
    height: 35px !important;
    background-color: #dadada;
}
.btns{
    text-align: right;
    margin-top: 10px;
}
.button{    
    height: 35px;
    width: 82px;
    margin: 0 5px;
    border-radius: 5px;
}
.save{
    border: none;
    color: white;
    background-color: rgb(55, 78, 141);
}
.cancel{
    color: black;
    background-color: white;
    border: 0.5px soild black;
}
</style>