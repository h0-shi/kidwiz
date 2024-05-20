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
                <tr>
                    <th colspan="4" class="cellType">내담자 정보</th>
                </tr>
                <tr>
                    <th>내담자 성명</th>
                    <td>{{stuName}}</td>
                    <th>학번</th>
                    <td>{{resultForm.stuNum}}</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>남자(수정필요)</td>
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
                    <td>{{date}}</td>
                    <th>상담자</th>
                    <td>위지언(수정필요)</td>
                </tr>
                <tr>
                    <th>상담 시간</th>
                    <td>{{time}}</td>
                    <th>상담 회기</th>
                    <td>3/10회기(수정필요)</td>
                </tr>
                <tr>
                    <th class="summary">지난 회기 과제 / 요약</th>
                    <td colspan="3">
                        과제 : 뭐시기 (수정필요)
                        <br><br>
                        요약 : 저시기 (수정필요)
                    </td>
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
            <button class="button cancel">취소</button>
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
        this.resultForm.regno = this.$route.query.regno;
        axios.get('http://localhost:3000/regResult?regno='+this.resultForm.regno).then((res) => {        
            this.resultForm.stuNum = res.data[0].stuNum;            
            this.date = res.data[0].date;
            this.time = res.data[0].time;

            axios.get('http://localhost:3000/memberDetail?stuNum='+this.resultForm.stuNum).then((response)=>{
            this.stuName = response.data[0].name;
            this.major = response.data[0].major_name;
        }).catch((error) => {
            console.log(error);
        })
        }).catch((err) => {
            console.log(err+'에러디');
        })
    },
    methods: {
        formSubmit(){
            axios.post('http://localhost:3000/resultWrite',this.resultForm).then((res) => {
                console.log(res);
            }).catch((err) => {
                console.log(err);
            })
            console.log(this.resultForm);
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