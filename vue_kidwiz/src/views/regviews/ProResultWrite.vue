<template>
  <div v-if="Object.keys(state.infos).length">
    <div class="mainContainer boundary">
      <h1>상담 일지</h1>
      <div class="formContainer">
        <form @submit.prevent="formSubmit" class="result" id="result">
          <table class="formTable">
            <colgroup>
              <col style="width: 16%" />
              <col style="width: 34%" />
              <col style="width: 16%" />
              <col style="width: 34%" />
            </colgroup>
            <tbody>
              <tr class="cellType">
                <th colspan="4">내담자 정보</th>
              </tr>
              <tr>
                <th>내담자 성명</th>
                <td>{{ state.infos.name }}</td>
                <th>학번</th>
                <td>{{ state.infos.sid }}</td>
              </tr>
              <tr>
                <th>성별</th>
                <td v-if="state.infos.gender === 'F'">여성</td>
                <td v-if="state.infos.gender === 'M'">남성</td>
                <th>소속</th>
                <td>{{ state.infos.major_name }}</td>
              </tr>
              <tr>
                <th>생년월일</th>
                <td>{{ state.infos.birth_date }}</td>
                <th>연락처</th>
                <td>{{ state.infos.contact }}</td>
              </tr>
              <tr class="cellType">
                <th colspan="4">상담 정보</th>
              </tr>
              <tr>
                <th>상담일</th>
                <td>{{ state.infos.cdate }}</td>
                <th>상담자</th>
                <td>위지언(수정필요)</td>
              </tr>
              <tr>
                <th>상담 시간</th>
                <td>{{ state.infos.ctime }}</td>
                <th>상담 회기</th>
                <td>-</td>
              </tr>
              <tr class="cellType">
                <th colspan="4">상담 일지</th>
              </tr>
              <tr>
                <th>(회기) 상담 목표</th>
                <td colspan="3">
                  <input type="text" v-model="state.form.goal" />
                </td>
              </tr>
              <tr class="resultContent">
                <th>진행 내용</th>
                <td colspan="3">
                  <textarea name="" v-model="state.form.content"></textarea>
                </td>
              </tr>
              <tr>
                <th>(회기) 요약</th>
                <td colspan="3">
                  <input type="text" v-model="state.form.summary" />
                </td>
              </tr>
              <tr>
                <th>(회기) 과제</th>
                <td colspan="3">
                  <input type="text" v-model="state.form.homework" />
                </td>
              </tr>
              <tr class="opinion">
                <th>상담사 의견</th>
                <td colspan="3">
                  <textarea name="" v-model="state.form.opinion"></textarea>
                </td>
              </tr>
            </tbody>
          </table>
          <section class="btns">
            <button type="submit" class="button save">저장</button>
            <button class="button cancel">취소</button>
          </section>
        </form>
      </div>
    </div>
  </div>
</template>
  
<script>
import axios from "axios";
import { reactive, onMounted } from "vue";

export default {
  props: ["rsvno"],
  setup(props) {
    const state = reactive({
      infos: [],
      form: {
        goal: "",
        content: "",
        summary: "",
        homework: "",
        opinion: "",
      },
    });

    onMounted(() => {
      axios
        .get(`http://localhost:3000/api/rsv/${props.rsvno}`, {
          withCredentials: true,
        })
        .then((response) => {
          state.infos = response.data;
        })
        .catch((err) => {
          alert("문제 발생" + err);
        });
    });

    const formSubmit = () => {
      axios
        .post(`http://localhost:3000/api/rsv/${props.rsvno}/save`, state.form, {
          withCredentials: true,
        })
        .then((response) => {
          console.log(response);
          alert("저장되었습니다.");
        })
        .catch((err) => {
          alert("저장 중 문제가 발생했습니다: " + err);
        });
    };

    return { state, formSubmit };
  },
};
</script>

  <!-- data() {
    return {
      stuName: "",
      date: "",
      time: "",
      major_name: "",
      gender: "",
      birth_date: "",
      times: "",
      totalTimes: "",
      contact: "",

      resultForm: {
        regno: "",
        stuNum: "",
        goal: "",
        content: "",
        summary: "",
        homework: "",
        opinion: "",
      },
    };
  },
  mounted() {
    this.resultForm.regno = this.$route.query.regno;
    axios
      .get("http://localhost:3000/regResult?regno=" + this.resultForm.regno)
      .then((res) => {
        this.resultForm.stuNum = res.data[0].stuNum;
        this.date = res.data[0].date;
        this.time = res.data[0].time;
        this.times = res.data[0].times;
        this.totalTimes = res.data[0].totalTimes;
        axios
          .get(
            "http://localhost:3000/memberDetail?stuNum=" +
              this.resultForm.stuNum
          )
          .then((response) => {
            this.stuName = response.data[0].name;
            this.major = response.data[0].major_name;
            this.gender = res.data[0].gender;
            this.contact = res.data[0].contact;
            this.birth_date = res.data[0].birth_date;
          })
          .catch((error) => {
            console.log(error);
          });
      })
      .catch((err) => {
        console.log(err + "에러디");
      });
  },
  methods: {
    formSubmit() {
      this.resultForm.content = this.resultForm.content.replaceAll(
        /(\n|\r\n)/g,
        "<br>"
      );
      if (!confirm("일지를 저장하시겠습니까?")) {
        return false;
      }
      axios
        .post("http://localhost:3000/resultWrite", this.resultForm)
        .then((res) => {
          console.log(res);
          this.$router.push("/regResult?regno=" + this.resultForm.regno);
        })
        .catch((err) => {
          console.log(err);
        });
      console.log(this.resultForm);
    },
  },
}; -->

  
  <style>
.boundary {
  max-width: 1000px;
}
.formContainer {
  background-color: rgb(255, 255, 255);
  border: 1px soild black;
}
.result input {
  width: 100%;
  border: 1px solid #c0c0c0;
}
.resultContent textarea {
  width: 100%;
  height: 100vh;
  border: 1px solid #c0c0c0;
  resize: none;
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