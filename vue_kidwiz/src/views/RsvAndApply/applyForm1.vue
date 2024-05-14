<template>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title mb-4">상담 신청</h2>
                        <form @submit.prevent="submitForm">

                            <div class="mb-3">
                                <!-- <label class="form-label col-md-4">상담 유형: </label> -->
                                <div class="btn-group" role="group" aria-label="Counseling Types">
                                    <button type="button" v-for="type in counselingTypes" :key="type"
                                        class="counseling-type" :class="{ 'selected': selectedCounselingType === type }"
                                        @click="selectCounselingType(type)">
                                        {{ type }}
                                    </button>
                                </div>
                            </div>

                            <div class="mb-3 form-row">
                                <label for="applicationDate" class="form-label col-md-4">신청일:</label>
                                <div class="col-md-8">
                                    <input type="text" id="applicationDate" v-model="applicationDate" readonly
                                        class="form-control">
                                </div>
                            </div>
                            <div class="mb-3 form-row">
                                <label for="counselingDate" class="form-label col-md-4">상담희망일:</label>
                                <div class="col-md-8">
                                    <input type="text" id="counselingDate" :value="formattedDate" readonly
                                        class="form-control">
                                </div>
                            </div>
                            <div class="mb-3 form-row">
                                <label for="counselingTime" class="form-label col-md-4">상담희망시간:</label>
                                <div class="col-md-8">
                                    <input type="text" id="counselingTime" :value="formattedTime" readonly
                                        class="form-control">
                                </div>
                            </div>
                            <div class="mb-3 form-row">
                                <label for="studentName" class="form-label col-md-4">신청 학생:</label>
                                <div class="col-md-8">
                                    <input type="text" id="studentName" v-model="studentName" readonly
                                        class="form-control">
                                </div>
                            </div>
                            <div class="mb-3 form-row">
                                <label for="advisor" class="form-label col-md-4">상담자 정보:</label>
                                <div class="col-md-8">
                                    <input type="text" id="advisor" v-model="advisor" readonly class="form-control">
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="requestText" class="form-label">상담 요청사항 ({{ textLength }}/500자):</label>
                                <textarea id="requestText" v-model="requestText" @input="updateTextLength"
                                    maxlength="500" class="form-control" rows="5"></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary">신청서 제출</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

export default {
    props: {
        selectedDate: {
            type: String,
            required: true
        },
        selectedTime: {
            type: String,
            required: true
        }

    },
    data() {
        return {
            applicationDate: new Date().toLocaleDateString(),
            studentName: '학생 이름', // JWT를 통해 가져온 사용자 이름
            advisor: '상담자 이름', // 학과 정보에 따른 상담자
            counselingTypes: ['지도교수 상담', '취업상담', '전문 상담'],
            selectedCounselingType: '',
            requestText: '',
            textLength: 0,

            localSelectedDate: this.selectedDate, // 로컬 데이터 속성으로 사용
            localSelectedTime: this.selectedTime
        };
    },
    computed: {
        formattedDate() {
            //return `${this.localSelectedDate} ${this.localSelectedTime ? this.localSelectedTime.time : ''}`;
            // 날짜와 시간을 함께 포맷팅하여 표시
            //return `${this.selectedDate} ${this.selectedTime}`;
            const date = new Date(this.selectedDate);
            return date.toLocaleDateString();
        },
        formattedTime() {
            // 시간만 반환하도록 포맷팅
            return this.selectedTime;
        }
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
    watch: {
        '$route.query.selectedDate': function (newDate) {
            this.localSelectedDate = newDate;
        },
        '$route.query.selectedTime': function (newTime) {
            this.localSelectedTime = newTime;
        }
    },
    methods: {
        submitForm() {
            // 폼 제출 로직
            const reservationData = {
                sid: 111, // 학생 ID (예: JWT에서 추출)
                proid: 222, // 상담자 ID (상담자 정보에서 추출)
                ctype: this.selectedCounselingType,
                timeSlotId: this.localSelectedTime,
                cdate: this.localSelectedDate,
                rsvdate: new Date().toISOString().split('T')[0],
                rsvmemo: this.requestText
            };

            axios.post('/api/reservations', reservationData)
                .then(() => {
                    alert('예약이 성공적으로 완료되었습니다.');
                    this.$router.push('/rsrvTest4'); // 예약 페이지로 이동
                })
                .catch(error => {
                    console.error('예약 중 오류가 발생했습니다.', error);
                    alert('예약 중 오류가 발생했습니다.');
                });
        },

        updateTextLength() {
            this.textLength = this.requestText.length;
        },
        selectCounselingType(type) {
            this.selectedCounselingType = type;
        }
    }
}
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

.counseling-type {
    padding: 10px;
    border: 1px solid #ccc;
    cursor: pointer;
}

.counseling-type.selected {
    background-color: #4CAF50;
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