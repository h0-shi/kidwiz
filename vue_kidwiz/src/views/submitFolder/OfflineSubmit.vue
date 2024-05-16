<template>
    <div class="container mt-5">
        <h2>오프라인 검사 신청</h2>
        <form @submit.prevent="submitForm">
            <!-- 이름 -->
            <div class="mb-3 row">
                <label for="name" class="col-sm-2 col-form-label">이름</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" v-model="formData.name" required>
                </div>
            </div>
            <!-- 연락처 (전화번호) -->
            <div class="mb-3 row">
                <label for="phone" class="col-sm-2 col-form-label">전화번호</label>
                <div class="col-sm-10">
                    <input type="tel" class="form-control" id="phone" v-model="formData.phone" required>
                </div>
            </div>
            <!-- 연락처 (이메일) -->
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label">이메일</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" v-model="formData.email" required>
                </div>
            </div>
            <!-- 연령 -->
            <div class="mb-3 row">
                <label for="age" class="col-sm-2 col-form-label">연령</label>
                <div class="col-sm-10">
                    <select class="form-select" id="age" v-model="formData.age" required>
                        <option value="" disabled>연령 선택</option>
                        <option v-for="age in ageOptions" :key="age" :value="age">{{ age }}세</option>
                    </select>
                </div>
            </div>
            <!-- 성별 -->
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">성별</label>
                <div class="col-sm-10">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="male" value="male" v-model="formData.gender">
                        <label class="form-check-label" for="male">남성</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="female" value="female"
                            v-model="formData.gender">
                        <label class="form-check-label" for="female">여성</label>
                    </div>
                </div>
            </div>
            <!-- 예약 -->
            <div class="row">
                <label class="col-sm-2 col-form-label">예약</label>

                <!-- 검사 종류 -->
                <div class="col">
                    <div class="card">
                        <div class="card-header">검사 종류</div>
                        <div class="card-body">
                            <div v-for="(exam, index) in exams" :key="index" class="exam-option"
                                @click="selectedExam = exam" :class="{ 'selected': exam === selectedExam }">
                                {{ exam }}
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card">
                        <div class="card-header">달력</div>
                        <div class="card-body">
                            <vue3-datepicker v-model="selectedDate" :disabledDates="{ predicate: isTodayOver }"
                                format="yyyy-MM-dd" placeholder="날짜 선택" class="me-2"></vue3-datepicker>
                        </div>
                    </div>
                </div>
                <!-- 시간 -->
                <div class="col">
                    <div class="card">
                        <div class="card-header">시간</div>
                        <div class="card-body">
                            <div v-for="time in availableTimes" :key="time" class="mb-2">
                                <p @click="selectedTime = time"
                                    :class="['time-text', { 'selected': time === selectedTime }]">
                                    {{ time }}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>

    <!-- 검사 종류, 날짜, 시간 표시 -->
    <div class="row">
        <label class="col-sm-2 col-form-label">예약 신청 일자</label>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <p>검사 종류: {{ selectedExam }}</p>
                        </div>
                        <div class="col">
                            <p>날짜: {{ selectedDate }}</p>
                        </div>
                        <div class="col">
                            <p>시간: {{ selectedTime }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 추가 정보 -->
    <div class="mb-3 row">
        <label for="additional" class="col-sm-2 col-form-label">기타 요구 사항 또는 특별한 요청</label>
        <div class="col-sm-10">
            <textarea class="form-control" id="additional" v-model="formData.additional"></textarea>
        </div>
    </div>
</form>
    <div class="mb-3 row">
        <div class="col-sm-10 offset-sm-2">
            <button type="submit" class="btn btn-primary">신청하기</button>
        </div>
    </div>

</template>



<script>
import { ref } from 'vue';
import DatePicker from 'vue3-datepicker';

export default {
    components: {
        Vue3Datepicker: DatePicker
    },
    setup() {
        const selectedDate = ref(null);
        const availableTimes = ['10:00', '12:00', '14:00', '16:00'];
        const selectedTime = ref(null);
        const ageOptions = [];
        for (let i = 19; i <= 60; i++) {
            ageOptions.push(i);
        }
        const isTodayOver = (date) => {
            return date < new Date();
        };
        const submitForm = () => {
            // 폼 데이터를 처리하는 메소드 추가해야함.
            console.log(formData.value);
        };
        const formData = ref({
            name: '',
            phone: '',
            email: '',
            age: '',
            gender: '',
            purpose: '',
            additional: '',
        });

        return {
            selectedDate,
            availableTimes,
            selectedTime,
            ageOptions,
            isTodayOver,
            submitForm,
            formData
        };
    }
};
</script>


<style scoped>
.exam-option {
    border: 1px solid #ccc;
    padding: 10px;
    margin-bottom: 5px;
    transition: background-color 0.3s ease;
    /* 호버 효과를 위한 transition 속성 추가 */
}

.exam-option:hover {
    background-color: #f0f0f0;
    /* 호버 시 배경색 변경 */
}
</style>