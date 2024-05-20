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
                <tr>
                    <th colspan="4" class="cellType">내담자 정보</th>
                </tr>
                <tr>
                    <th>내담자 성명</th>
                    <td>{{stuName}}</td>
                    <th>학번</th>
                    <td>{{stuNum}}</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>남자</td>
                    <th>소속</th>
                    <td>{{major}}</td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>2000.03.21(수정필요)</td>
                    <th>연락처</th>
                    <td>010-8942-5728(수정필요)</td>
                </tr>
                <tr>
                    <th colspan="4" class="cellType">상담 정보</th>
                </tr>
                <tr>
                    <th>상담일</th>
                    <td>{{ date }}</td>
                    <th>상담자</th>
                    <td>위지언</td>
                </tr>
                <tr>
                    <th>상담 시간</th>
                    <td>{{time}}</td>
                    <th>상담 회기</th>
                    <td>3/10회기</td>
                </tr>
                <tr>
                    <th class="summary">지난 회기 과제 / 요약</th>
                    <td colspan="3">
                        과제 : 뭐시기
                        <br><br>
                        요약 : 저시기
                    </td>
                </tr>
                <tr>
                    <th>회기 상담 목표</th>
                    <td colspan="3">{{goal}}</td>
                </tr>
                <tr>
                    <th class="resultContent">진행 내용</th>
                    <td colspan="3">
                        {{content}}
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
            <button class="button save">수정하기</button>            
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
        }
    },
    mounted() {
        this.regno = this.$route.query.regno;
        axios.get('http://localhost:3000/getRegResult?regno='+this.regno).then((res) => {
            this.goal = res.data[0].goal;
            this.content = res.data[0].content;
            this.summary = res.data[0].summary;
            this.homework = res.data[0].homework;
            this.opinion = res.data[0].opinion;            
            axios.get('http://localhost:3000/regResult?regno='+this.regno).then((res2) => {                        
                console.log(res2.data[0]);
                this.stuNum=res2.data[0].stuNum;
                this.date = res2.data[0].date;
                this.time = res2.data[0].time;
                axios.get('http://localhost:3000/memberDetail?stuNum='+this.stuNum).then((response)=>{
                    this.stuName = response.data[0].name;
                    this.major = response.data[0].major_name;                    
                }).catch((error) => {
                    console.log(error);
                })
            }).catch((err) => {
                console.log(err+'에러디');
        })
        }).catch((err) => {
            console.log(err+'에러디')
        })
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
    height: 30px !important;
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