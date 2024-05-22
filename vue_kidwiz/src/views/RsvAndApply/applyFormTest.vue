<template>
  <div class="container my-5">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="formContainer">
          <div class="card-body">
            <h2 class="card-title mb-4">지도 교수 상담</h2>
            <span>상담 신청서</span>
            <form @submit="submitForm">
              <table class="formTable">
                <colgroup>
                  <col style="width: 16%" />
                  <col style="width: 34%" />
                  <col style="width: 16%" />
                  <col style="width: 34%" />
                </colgroup>
                <tbody>
                  <tr>
                    <th>상담 유형<span> *</span></th>
                    <td>지도 교수 상담</td>
                    <th>상담자<span> *</span></th>
                    <td>지도교수 이름(수정 필)</td>
                  </tr>
                  <tr>
                    <th>성명<span> *</span></th>
                    <td>{{studentName}}</td>
                    <th>학번<span> *</span></th>
                    <td>{{studentID}}</td>
                  </tr>
                  <tr>
                    <th>성별<span> *</span></th>
                    <td>성별(수정 필)</td>
                    <th>소속<span> *</span></th>
                    <td>학과(수정 필)</td>
                  </tr>
                  <tr>
                    <th>상담일<span> *</span></th>
                    <td>{{ selectedDate }}</td>
                    <th>상담자<span> *</span></th>
                    <td>{{ proName }}</td>
                  </tr>
                  <tr>
                    <th>상담 시간<span> *</span></th>
                    <td>{{ selectedTime }}</td>
                    <th>상담 회기</th>
                    <td> - </td>
                  </tr>
                  <tr>
                    <th colspan="1">상담 요청 사항<span> *</span>
                    <br>({{ textLength }}/500자)</th>
                    <td colspan="3"><textarea
                  id="requestText"
                  v-model="requestText"
                  @input="updateTextLength"
                  maxlength="500"
                  class="form-control"
                  rows="5"
                ></textarea></td>
                  </tr>
            </tbody>                
            </table>              
              <button type="submit" class="btn btn-primary">신청서 제출</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";

export default {
  props: {
    selectedDate: {
      type: String,
      required: true,
    },
    selectedTime: {
      type: String,
      required: true,
    },
    selectedCounselingType: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      applicationDate: new Date().toLocaleDateString(),
      studentName: this.$store.state.account.name, // JWT를 통해 가져온 사용자 이름
      //studentID: '학생 ID', // JWT를 통해 가져온 사용자 ID
      advisor: "상담자 이름", // 학과 정보에 따른 상담자
      //counselingTypes: ['지도교수 상담', '취업상담', '전문 상담'],
      //selectedCounselingType: '지도교수 상담', // 기본값으로 초기 설정되어있게 함
      localSelectedCounselingType: "", // 로컬 데이터 속성으로 사용
      requestText: "",
      textLength: 0,

      localSelectedDate: "", // 로컬 데이터 속성으로 사용
      localSelectedTime: "",

      isSubmitting: false, // 중복 제출 방지 240516
    };
  },
  mounted() {
    this.studentName = this.$store.state.account.name;
    this.studentID = this.$store.state.account.id;
    console.log("학생 this.id : " + this.studentID);
    console.log("학생 store.account.id : " + this.$store.state.account.id);
    axios
      .get(
        `/api/reservations/members?studentID=` + this.$store.state.account.id
      )
      .then((response) => {
        console.log(response.data);
        this.advisor = response.data.major_head;
        this.getProId(this.advisor); //상담자 id 가져오기 위한 변수
      })
      .catch((error) => {
        console.error("Error fetching advisor:", error);
        this.advisor = "상담자 정보를 불러오는 데 실패했습니다.";
      });
  },
  computed: {
    formattedSelectedDate() {
      //return `${this.localSelectedDate} ${this.localSelectedTime ? this.localSelectedTime.time : ''}`;
      // 날짜와 시간을 함께 포맷팅하여 표시
      //return `${this.selectedDate} ${this.selectedTime}`;
      const date = new Date(this.localSelectedDate);
      return date.toLocaleDateString();
    },
    formattedTime() {
      // 시간만 반환하도록 포맷팅
      return this.localSelectedtime;
    },
  },
  // created() {
  //this.applicationDate = new Date().toLocaleDateString(); // 신청일을 현재 날짜로 설정
  //     if (this.$route.query.selectedDate) {
  //         this.selectedDate = this.$route.query.selectedDate;
  //     }
  //     if (this.$route.query.selectedTime) {
  //         this.selectedTime = this.$route.query.selectedTime;
  //     }
  // },

  //240521 상담유형 값 받아오기 위해 watch 대신 created로 수정
  created() {
    this.localSelectedDate = this.$route.query.selectedDate || "";
    this.localSelectedTime = this.$route.query.selectedTime || "";
    this.localSelectedCounselingType =
      this.$route.query.selectedCounselingType || "";
  },
  methods: {
    async getProId(majorHead) {
      try {
        const encodedMajorHead = encodeURIComponent(majorHead); // URL 인코딩
        const response = await axios.get(
          `/api/reservations/getProId?majorHead=` + encodedMajorHead
        );
        this.proid = response.data;
      } catch (error) {
        console.error("Error fetching ProId:", error);
        this.proid = null;
      }
      console.log("현시점 majorHead : " + majorHead);
      console.log("현시점 proid : " + this.proid);
    },
    async submitForm(event) {
      event.preventDefault(); // 기본 폼 제출 방지

      if (this.isSubmitting) return; // 중복 제출 방지 240516
      this.isSubmitting = true;

      // proid가 설정될 때까지 기다림
      while (this.proid === null) {
        await new Promise((resolve) => setTimeout(resolve, 100));
      }

      // 상담 유형이 선택되지 않은 경우 경고 메시지 표시(240516 기본값 만들어서 이제 필요 없음)
      // 240520 이제 신청페이지에서 선택하므로 삭제
      //if (!this.selectedCounselingType) {
      //    alert("상담 유형 선택은 필수 사항입니다.");
      //    this.isSubmitting = false;
      //    return;
      //}

      console.log("제출시점 proid : " + this.proid);
      // 폼 제출 로직
      const reservationData = {
        sid: this.studentID, // 학생 ID (예: JWT에서 추출)
        proid: this.proid, // 상담자 ID (상담자 정보에서 추출)
        ctype: this.localSelectedCounselingType,
        ctime: this.localSelectedTime,
        cdate: this.localSelectedDate,
        rsvdate: new Date().toISOString().split("T")[0],
        rsvmemo: this.requestText,
      };

      // Axios 요청 데이터 검증
      if (Object.values(reservationData).some((value) => !value)) {
        alert("필수 입력 항목을 모두 입력해주세요.");
        this.isSubmitting = false;
        return;
      }
      // 예약 데이터 확인
      console.log("예약 데이터:", reservationData);

      // for (const field in reservationData) {
      //     // reservationData 객체에 폼 데이터 추가
      //     if (Object.prototype.hasOwnProperty.call(this, field) && field !== 'isSubmitting') {
      //        reservationData[field] = this[field];
      //     }
      // }

      try {
        console.log("Axios 요청 시작", reservationData);
        const response = await axios.post("/api/reservations", reservationData);
        console.log("Axios 요청 성공", response);

        if (response.status === 201) {
          alert("예약이 성공적으로 완료되었습니다.");
          this.$router.push("/rsrvTest4");
        } else {
          console.error("예약 중 오류가 발생했습니다.", response);
          alert("예약 중 오류가 발생했습니다. 관리자에게 문의해주세요.");
        }
      } catch (error) {
        console.error("예약 중 오류가 발생했습니다.", error);
        alert("예약 중 오류가 발생했습니다. 관리자에게 문의해주세요.");
      } finally {
        this.isSubmitting = false;
        console.log("submitForm 완료됨");
      }
    },
    updateTextLength() {
      this.textLength = this.requestText.length;
    },
  },
};
</script>

<style>
.reservation-form {
  width: 100%;
  max-width: 600px;
  margin: auto;
}

.counseling-types {
  display: flex;
  gap: 10px;
}
table th span{
    color : red;
}
table td textarea{
    height: 300px;
    margin: 10px 0;
}
.counseling-type {
  padding: 10px;
  border: 1px solid #ccc;
  cursor: pointer;
}

.counseling-type.selected {
  background-color: #4caf50;
  color: white;
}

.form-row {
  display: flex;
  flex-wrap: wrap;
  margin-right: -5px;
  margin-left: -5px;
}

.form-row > .col-md-4,
.form-row > .col-md-8 {
  padding-right: 5px;
  padding-left: 5px;
}

.form-row > .col-md-4 {
  flex: 0 0 33.333333%;
  max-width: 33.333333%;
}

.form-row > .col-md-8 {
  flex: 0 0 66.666667%;
  max-width: 66.666667%;
}
</style>
