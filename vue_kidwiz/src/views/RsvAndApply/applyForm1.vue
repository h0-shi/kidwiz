<template>
    <div class="reservation-form">
        <h2>상담 신청</h2>
        <form @submit.prevent="submitForm">
            <div>
                <label>신청일:</label>
                <input type="text" v-model="applicationDate" readonly>
            </div>
            <div>
                <label>상담일:</label>
                <input type="text" :value="formattedDate" readonly>
            </div>
            <div>
                <label>신청 학생:</label>
                <input type="text" v-model="studentName" readonly>
            </div>
            <div>
                <label>상담자 정보:</label>
                <input type="text" v-model="advisor" readonly>
            </div>
            <div>
                <label>상담 유형:</label>
                <div class="counseling-types">
                    <span v-for="type in counselingTypes" :key="type" class="counseling-type"
                        :class="{ 'selected': selectedCounselingType === type }" @click="selectCounselingType(type)">
                        {{ type }}
                    </span>
                </div>
            </div>
            <div>
                <label>상담 요청사항 ({{ textLength }}/500자):</label>
                <textarea v-model="requestText" @input="updateTextLength" maxlength="500"></textarea>
            </div>
            <button type="submit">신청 확인</button>
        </form>
    </div>
</template>

<script>
export default {
    props: {
        selectedDate: String,
        selectedTime: String
    },
    data() {
        return {
            localSelectedDate: this.selectedDate, // 로컬 데이터 속성으로 사용
            localSelectedTime: this.selectedTime,
            applicationDate: new Date().toLocaleDateString(),
            studentName: '학생 이름', // JWT를 통해 가져온 사용자 이름
            advisor: '상담자 이름', // 학과 정보에 따른 상담자
            counselingTypes: ['지도교수 상담', '취업상담', '전문 상담'],
            selectedCounselingType: '',
            requestText: '',
            textLength: 0
        };
    },
    computed: {
        formattedDate() {
            //return `${this.localSelectedDate} ${this.localSelectedTime ? this.localSelectedTime.time : ''}`;
            // 날짜와 시간을 함께 포맷팅하여 표시
            return `${this.selectedDate} ${this.selectedTime}`;
        }
    },
    created() {
        this.applicationDate = new Date().toLocaleDateString(); // 신청일을 현재 날짜로 설정
       // if (this.$route.params.selectedDate) {
       //     this.selectedDate = this.$route.params.selectedDate;
            //this.selectedTime.time = this.$route.params.selectedTime;
       //     this.selectedTime = { time: this.$route.params.selectedTime || '' }; // 객체 형태로 설정
       // }
    },
    methods: {
        submitForm() {
            // 폼 제출 로직
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
</style>