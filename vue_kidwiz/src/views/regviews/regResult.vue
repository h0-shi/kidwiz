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
                    <td>박시호</td>
                    <th>학번</th>
                    <td>{{regno}}</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>남자</td>
                    <th>소속</th>
                    <td>심리치료학과</td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>2000.03.21</td>
                    <th>연락처</th>
                    <td>010-8942-5728</td>
                </tr>
                <tr>
                    <th colspan="4" class="cellType">상담 정보</th>
                </tr>
                <tr>
                    <th>상담일</th>
                    <td>2024.05.20</td>
                    <th>상담자</th>
                    <td>위지언</td>
                </tr>
                <tr>
                    <th>상담 시간</th>
                    <td>14:00 - 15:00</td>
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
                    <td colspan="3"><input type="text"></td>
                </tr>
                <tr class="resultContent">
                    <th>진행 내용</th>
                    <td colspan="3">
                        <textarea name=""></textarea>
                    </td>
                </tr>
                <tr>
                    <th>
                        회기 요약
                        <td colspan="3">
                            <input type="text">                            
                        </td>                                                
                    </th>
                </tr>
                <tr>
                    <th>
                        회기 과제
                        <td colspan="3">
                            <input type="text">                            
                        </td>                                                
                    </th>
                </tr>
                <tr class="opinion">
                    <th>상담사 의견</th>
                    <td colspan="3"><textarea name=""></textarea></td>
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
    mounted() {
        this.regno = this.$route.query.regno;
        axios.get('http://localhost:3000/regResult?regno='+this.regno).then((res) => {
            console.log(res.data);
        }).catch((err) => {
            console.log(err+'에러디')
        })
    },
    data(){
        return{
            regno : '',
            resultForm : {
                stuName : '',
                stuNum: '',
                date: '',
                time: '',

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