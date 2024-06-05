<template>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="formContainer">
                    <div class="card-body">
                        <h2 class="card-title mb-4">심리상담</h2>
                        <span class="formInfo">🧾 상담 신청서</span>
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
                                        <td>심리상담</td>
                                        <th>상담자<span> *</span></th>
                                        <td>{{ advisor }}</td>
                                    </tr>
                                    <tr>
                                        <th>성명<span> *</span></th>
                                        <td>{{ studentName }}</td>
                                        <th>학번<span> *</span></th>
                                        <td>{{ studentID }}</td>
                                    </tr>
                                    <tr>
                                        <th>성별<span> *</span></th>
                                        <td v-if="gender === 'M'">남자</td>
                                        <td v-if="gender === 'F'">여자</td>
                                        <th>소속<span> *</span></th>
                                        <td>{{ major_name }}</td>
                                    </tr>
                                    <tr>
                                        <th>생년월일<span> *</span></th>
                                        <td>{{ birth_date }}</td>
                                        <th>연락처<span> *</span></th>
                                        <td>{{ contact }}</td>
                                    </tr>
                                    <tr>
                                        <th>상담일<span> *</span></th>
                                        <td>{{ selectedDate }}</td>
                                        <th>상담 시간<span> *</span></th>
                                        <td>{{ selectedTime }}</td>
                                    </tr>
                                    <tr>
                                        <th colspan="1">상담 요청 사항<span> *</span>
                                            <br>({{ textLength }}/500자)
                                        </th>
                                        <td colspan="3"><textarea id="requestText" v-model="requestText"
                                                @input="updateTextLength" maxlength="500" class="form-control"
                                                rows="5"></textarea></td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="card">
                                <div class="card-body">
                                    <span class="formInfo mt-4">개인정보 수집 동의</span>
                                    <hr>
                                    <div>
                                        <div class="agree">상담센터는 상담 및 심리검사 프로그램 진행을 위해 「개인정보보호법」 제15조(개인정보 수집·이용) 및
                                            제23조(민감정보의 처리 제한)에 따라 귀하의 동의를 받고자 합니다. 아래 내용을 자세히 읽어보시고, 모든 내용을 이해하신 후 동의
                                            여부를 결정하여 주시기 바랍니다.</div>
                                        <div class="subTitle">1. 개인정보 수집·이용 동의
                                            <table class="agreeTable">
                                                <colgroup>
                                                    <col style="width: 10%" />
                                                    <col style="width: 40%" />
                                                    <col style="width: 25%" />
                                                    <col style="width: 25%" />
                                                </colgroup>
                                                <thead>
                                                    <tr>
                                                        <th>구분</th>
                                                        <th>수집 · 이용할 개인정보 항목</th>
                                                        <th>수집 · 이용 목적</th>
                                                        <th>보유 및 이용 기간</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="tac">필수</td>
                                                        <td class="infoContent">
                                                            1. 상담 신청서<br>
                                                            <span>
                                                                - 성명, 학번, 성별, 생년월일, 소속, 연락처(핸드폰), e-mail, 비상 연락처, 현주소,
                                                                휴학여부, 휴학 사유 및 기간, 기타
                                                                (상담관련 서류, 심리검사자료, 녹취정보)<br>
                                                            </span>
                                                            2. 심리검사 답안지<br>
                                                            <span>
                                                                - 성명, 성별, 생년월일, 소속
                                                            </span>
                                                        </td>
                                                        <td rowspan="2" class="infoContent">
                                                            - 상담 및 심리검사 진행<br>
                                                            - 상담기간 중 비상 시 업무 연락</td>
                                                        <td rowspan="2" class="infoContent">
                                                            o 상담신청서(미참가자) 및 심리검사 답안지 : 신청 완료된 시점으로부터 1개월<br>
                                                            o 상담진행시 관련 서류 : 상담 종결 시점으로부터 7년<br>
                                                            o 녹음파일 : 녹취된 시점부터 1년<br>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="tac">선택</td>
                                                        <td class="infoContent">
                                                            1. 상담 신청서<br>
                                                            <span>
                                                                - 고교졸업년도, 현재 건강상태, 입학경위, 주거지
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <div class="agree mt-2">
                                                ※ 학생상담센터에서 실시 중인 심리검사 : MBTI, MMPI, SCT, K-IIP, U&I 학습유형검사, U&I 진로탐색검사,
                                                TCI 등 신청자는 개인정보 수집 · 이용에 대한 동의를 거부할 권리가 있습니다. 그러나, 동의를 거부할 경우 개인상담 및
                                                심리검사 진행이 불가할 수 있습니다.
                                            </div>
                                            <div class="mt-2">
                                                <hr>
                                                <table class="radioGroup">
                                                    <colgroup>
                                                        <col style="width:40%">
                                                        <col style="width:30%">
                                                        <col style="width:30%">
                                                    </colgroup>
                                                    <tr>
                                                        <td><span class="agreeCheck">[필수] 개인정보 수집 · 이용에 동의하십니까?</span>
                                                        </td>
                                                        <td class="radios">
                                                            <input type="radio" value="agree" v-model="agreement">
                                                            <span class="agreeCheck">동의합니다.</span>
                                                        </td>
                                                        <td class="radios">
                                                            <input type="radio" value="disagree" v-model="agreement">
                                                            <span class="agreeCheck">동의하지 않습니다.</span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary mt-4">신청서 제출</button>
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
        ctimecode: { //시간 code 받음
            type: String,
            required: true
        }
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
            contact: '',
            birth_date: '',
            localSelectedDate: "", // 로컬 데이터 속성으로 사용
            localSelectedTime: "",
            gender: '',
            major_name: '',
            agreement: 'disagree',
            isSubmitting: false, // 중복 제출 방지 240516
        };
    },
    mounted() {
        this.studentName = this.$store.state.account.name;
        this.studentID = this.$store.state.account.id;
        axios
            .get(
                `/api/reservations/members?studentID=` + this.$store.state.account.id
            )
            .then((response) => {
                this.major_name = response.data.major_name;
                this.gender = response.data.gender;
                this.advisor = response.data.major_head;
                this.contact = response.data.contact;
                this.birth_date = response.data.birth_date;
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
         const ctimecode = this.$route.query.ctimecode;
         
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
        },
        async submitForm(event) {
            event.preventDefault(); // 기본 폼 제출 방지

            if (this.isSubmitting) return; // 중복 제출 방지 240516
            this.isSubmitting = true;

            // proid가 설정될 때까지 기다림
            while (this.proid === null) {
                await new Promise((resolve) => setTimeout(resolve, 100));
            }


            console.log("제출시점 proid : " + this.proid);
            // 폼 제출 로직
            const reservationData = {
                sid: this.studentID, // 학생 ID (예: JWT에서 추출)
                proid: this.proid, // 상담자 ID (상담자 정보에서 추출)
                ctype: this.localSelectedCounselingType,
                ctime: this.ctimecode,
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
            if (`${this.agreement}` != 'agree') {
                alert("개인정보 비동의시 상담 접수가 불가합니다.");
                return false;
            }

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

.subTitle {
    text-align: left;
    margin: 10px 0;
}

.radioGroup {
    width: 100%;
}

.agreeTable {
    width: 100%;
}

.radios {
    text-align: right;
}

.agreeTable tr th {
    height: 35px;
    border: 1px solid #c0c0c0;
    font-weight: bold;
    font-size: nomal;
    text-align: center;
}

.infoContent {
    padding: 5px;
    margin-left: 10px;
    text-align: left;
}

.infoContent span {
    font-size: smaller;
    margin-left: 5px;
}

.tac {
    text-align: center;
}

.agreeTable tr td {
    height: 35px;
    border: 1px solid #c0c0c0;
    color: #3d3d3d;
    font-weight: nomal;
    font-size: small;
}

.formInfo {
    display: block;
    text-align: left;
    font-size: larger;
    font-weight: bold;
    color: rgb(7, 7, 173);
    margin: 5px 10px;
}

.counseling-types {
    display: flex;
    gap: 10px;
}

.formTable {
    border-top: 1px solid #707070;
    border-bottom: 1px solid #707070;
}

table th span {
    color: red;
}

table td textarea {
    height: 300px;
    margin: 10px 0;
}

.counseling-type {
    padding: 10px;
    border: 1px solid #ccc;
    cursor: pointer;
}

.agree {
    margin: 0 5px;
    font-weight: lighter;
    font-size: smaller;
    text-align: left;
}

.agreeCheck {
    margin: 0 5px;
    font-weight: lighter;
    font-size: smaller;
    text-align: left;
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

.form-row>.col-md-4,
.form-row>.col-md-8 {
    padding-right: 5px;
    padding-left: 5px;
}

.form-row>.col-md-4 {
    flex: 0 0 33.333333%;
    max-width: 33.333333%;
}

.form-row>.col-md-8 {
    flex: 0 0 66.666667%;
    max-width: 66.666667%;
}
</style>
