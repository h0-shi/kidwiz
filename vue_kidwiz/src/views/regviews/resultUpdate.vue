<template>
  <div class="mainContainer boundary">
    <h1>상담 일지</h1>
    <div class="formContainer">
    <form @submit.prevent="formSubmit" class="result" id="result">
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
                    <td>{{resultForm.stuNum}}</td>
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
                    <td>{{date}}</td>
                    <th>상담자</th>
                    <td>{{proName}}</td>
                </tr>
                <tr>
                    <th>상담 시간</th>                                        
                    <td>{{time}}</td>
                    <th>상담 회기</th>
                    <td>{{times}}/{{totalTimes}}회기</td>
                </tr>
                <tr class="cellType">
                    <th colspan="4">상담 일지</th>
                </tr>
                <tr>
                    <th>회기 상담 목표</th>
                    <td colspan="3"><input type="text" v-model="resultForm.goal"></td>
                </tr>
                <tr class="resultContent">
                    <th>진행 내용</th>
                    <td colspan="3">
                        <textarea name="" v-model="resultForm.content"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>회기 요약</th>
                    <td colspan="3">
                        <input type="text" v-model="resultForm.summary">                            
                    </td>    
                </tr>
                <tr>
                    <th>회기 과제</th>
                    <td colspan="3">
                        <input type="text" v-model="resultForm.homework">                            
                    </td>    
                </tr>
                <tr class="opinion">
                    <th>상담사 의견</th>
                    <td colspan="3"><textarea name="" v-model="resultForm.opinion"></textarea></td>
                </tr>
            </tbody>
        </table>      
        <section class="btns">
            <button class="button save">저장</button>
            <button class="button cancel" @click="cancel()">취소</button>
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
            major_name : '',
            gender:'',
            birth_date:'',
            times:'',
            totalTimes:'',            
            contact:'',
            proName:'',
            resultForm : {                
                regno : '',
                stuNum: '',
                goal: '',
                content:'',
                summary:'',
                homework:'',
                opinion:'',
            }
        }
    },
    mounted() {
        this.regno = this.$route.query.regno;
        axios.get('http://localhost:3000/getRegResult?regno='+this.regno).then((res) => {            
            this.resultForm.regno = this.regno;
            this.stuName = res.data[0].name;
            this.date = res.data[0].date;
            this.time = res.data[0].time;
            this.major = res.data[0].major_name;
            this.stuNum = res.data[0].stuNum;            
            this.resultForm.goal = res.data[0].goal;
            this.resultForm.homework = res.data[0].homework;
            this.resultForm.content = res.data[0].content;
            this.resultForm.summary = res.data[0].summary;
            this.resultForm.opinion = res.data[0].opinion;
            this.gender = res.data[0].gender;
            this.birth_date = res.data[0].birth_date;
            this.times = res.data[0].times;
            this.totalTimes = res.data[0].totalTimes;
            this.contact = res.data[0].contact;
            this.proName = res.data[0].proName;
            this.resultForm.content = this.resultForm.content.replaceAll(/<br>/g,'\n');
        }).catch((err) => {
            console.log(err+'에러디')
        })
    },
    methods: {
        formSubmit(){
            this.resultForm.content = this.resultForm.content.replaceAll(/(\n|\r\n)/g,'<br>');
            console.log(this.resultForm);
            if(!confirm("일지를 저장하시겠습니까?")){
                return false;
            }
            axios.post('http://localhost:3000/resultUpdate',this.resultForm).then((res) => {
                console.log(res);
                this.$router.push("/regResult?regno="+this.regno);
            }).catch((err) => {
                console.log(err);
            })
            console.log(this.resultForm);
        },
        cancel(){
            if(confirm("수정을 취소하시겠습니까?")){
                this.$router.push("/regResult?regno="+this.regno);
            }
        }
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
.result input{
    width: 100%;
    border: 1px solid #c0c0c0;
}
.resultContent textarea{
    width: 100%;
    height: 100vh;
    border: 1px solid #c0c0c0;
    resize: none;
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
}
.opinion textarea{
    height: 150px;
    width: 100%;
    border: 1px solid #c0c0c0;
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