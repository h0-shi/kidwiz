<template>
    <div v-if="Object.keys(state.ProResult).length">
    <div class="mainContainer boundary">
      <h1>상담 일지</h1>
      <div class="formContainer">
        <form @submit.prevent="updateSubmit" class="result">
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
                      <td>{{ state.ProResult.name }}</td>
                      <th>학번</th>
                      <td>{{ state.ProResult.sid }}</td>
                  </tr>
                  <tr>
                      <th>성별</th>
                      <td v-if="state.ProResult.gender==='F'">여성</td>
                      <td v-if="state.ProResult.gender==='M'">남성</td>
                      <th>소속</th>
                      <td>{{ state.ProResult.major_name }}</td>                      
                  </tr>
                  <tr>
                      <th>생년월일</th>
                      <td>{{ state.ProResult.birth_date }}</td>
                      <th>연락처</th>
                      <td>{{ state.ProResult.contact }}</td>
                  </tr>
                  <tr class="cellType">
                      <th colspan="4">상담 정보</th>
                  </tr>
                  <tr>
                      <th>상담일</th>
                      <td>{{ state.ProResult.cdate }}</td>
                      <th>상담자</th>
                      <td>{{ state.ProResult.proname }}</td>
                  </tr>
                  <tr>
                      <th>상담 시간</th>
                      <td>{{ state.ProResult.time }}</td>
                      <th>상담 회기</th>
                      <td>-</td>
                  </tr>
                  <tr class="cellType">
                      <th colspan="4">상담 일지</th>
                  </tr>
                  <tr>
                      <th>회기 상담 목표</th>
                      <td colspan="3"><input type="text" v-model="state.ProResult.goal"></td>
                  </tr>
                  <tr>
                      <th class="resultContent">진행 내용</th>
                      <td colspan="3"><input type="text" v-model="state.ProResult.content"></td>
                  </tr>
                  <tr>
                      <th>회기 요약</th>
                      <td colspan="3"><input type="text" v-model="state.ProResult.summary"></td>
                  </tr>
                  <tr>
                      <th>회기 과제</th>
                      <td colspan="3"><input type="text" v-model="state.ProResult.homework"></td>
                  </tr>
                  <tr class="opinion">
                      <th>상담사 의견</th>
                      <td colspan="3"><input type="text" v-model="state.ProResult.opinion"></td>
                  </tr>
              </tbody>
          </table>      
          <section class="btns">
            <button type="submit" class="button save">저장</button>
            <button type="button" @click="cancel" class="button cancel">취소</button>
          </section>
      </form>
      </div>
    </div>
  </div>
  </template>
  
    
  <script>
  import axios from "axios";
  import { reactive, onMounted } from "vue";
  import router from '@/router';
  
  export default {
    props: ["rsvno"],
    setup(props) {
      const state = reactive({
        ProResult: []
      });
  
      onMounted(() => {
        axios
          .get(`http://localhost:3000/api/proresult/${props.rsvno}`, {withCredentials: true})
          .then((response) => {
            state.ProResult = response.data;
          })
          .catch((err) => {
            alert("문제 발생" + err);
          });
      });
  
      const updateSubmit = () => {
        axios
          .post(`http://localhost:3000/api/rsv/${props.rsvno}/update`, state.ProResult, {withCredentials: true})
          .then((response) => {
            console.log(response);
            alert("수정되었습니다.");
            router.push({ name: 'ProResult', params: { rsvno: props.rsvno } }); // 수정 후 이동할 경로 설정
            // router.push({path: "/myconsultations"}); // 수정 후 이동할 경로 설정
          })
          .catch((err) => {
            alert("수정 중 문제가 발생했습니다: " + err);
          });
      };
  
      // 취소버튼 누르면 뒤로가기
      const cancel = () => {
        router.go(-1);
      };
  
      return { state, updateSubmit, cancel };
    },
  };
  </script>

    <style>
  .boundary {
    max-width: 1000px;
  }
  .formContainer {
    background-color: rgb(255, 255, 255);
    border: 1px soild black;
  }
  .formTable {
    width: 100%;
    text-align: center;
  }
  .resultContent {
    height: 500px;
  }
  .opinion {
    height: 150px;
  }
  .opinion textarea {
    height: 150px;
    width: 100%;
    border: 1px solid #c0c0c0;
  }
  .formTable tr {
    height: 50px;
    border-bottom: 1px solid #d1d1d1;
    font-size: small;
  }
  .formTable tr td {
    text-align: left;
  }
  .summary {
    height: 100px;
  }
  .cellType {
    height: 35px !important;
    background-color: #dadada;
  }
  .btns {
    text-align: right;
    margin-top: 10px;
  }
  .button {
    height: 35px;
    width: 82px;
    margin: 0 5px;
    border-radius: 5px;
  }
  .save {
    border: none;
    color: white;
    background-color: rgb(55, 78, 141);
  }
  .cancel {
    color: black;
    background-color: white;
    border: 0.5px soild black;
  }
  </style>