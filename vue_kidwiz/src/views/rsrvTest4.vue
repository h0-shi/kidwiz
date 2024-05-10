<template>
  <div class="calendar-wrapper">
    <h2>상담 신청하기</h2>
    <div class="calendar-container">
      <FullCalendar :options="calendarOptions" id="calendar"></FullCalendar>
    </div>
    <div class="available-times" v-if="availableTimes.length">
      <h3>{{ selectedDate }}의 예약 가능 시간</h3>
      <ul>
        <li v-for="time in availableTimes" :key="time.id">
          <label>
            <input type="radio" v-model="selectedTime" :value="time">
            {{ time.time }} (남은 자리: {{ time.availableSeats }})
          </label>
        </li>
      </ul>
      <button @click="submitReservation">신청하기</button>
    </div>
  <!-- 예약 신청 폼 -->
  <div class="reservation-form" v-if="selectedTime">
      <h3>예약 신청</h3>
      <form @submit.prevent="submitReservation">
        <div>날짜: {{ selectedDate }}</div>
        <div>시간: {{ selectedTime.time }}</div>
        <button type="submit">예약 확인</button>
      </form>
    </div>
  </div>
</template>

<script>
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import axios from 'axios'; 
import '../css/calendar.css';

export default {
  components: {
    FullCalendar 
  },
  data() {
    return {
      selectedDate: '',
      selectedTime: null,
      availableTimes: [],
      calendarOptions: {
        plugins: [ dayGridPlugin, interactionPlugin ],
        initialView: 'dayGridMonth',
        locale: 'ko',
        selectable: true,
        weekends: false,
        events: [{ title: 'Meeting', start: new Date() }],
        dateClick: this.fetchDateInfo // 수정: dateClick 핸들러를 Ajax 호출 함수로 변경
      }
    };
  },
  methods: {
    fetchDateInfo(info) {
      this.selectedDate = info.dateStr;
      this.selectedTime = null;  // 시간 선택 초기화
      axios.get('/api/available-times', { params: { date: info.dateStr } })
        .then(response => {
          this.availableTimes = response.data.times;
        })
        .catch(error => {
          console.error("Error fetching available times:", error);
          this.availableTimes = [];  // 오류 시 배열 초기화
        });
    },
    submitReservation() {
      if (!this.selectedTime) {
        alert("시간을 선택해 주세요.");
        return;
      }
      // 폼 제출 로직: 서버에 예약 데이터 전송
      console.log(`Reservation submitted for ${this.selectedDate} at ${this.selectedTime.time}`);
      // 예를 들어, 여기에 폼 데이터를 서버로 전송하는 axios.post 요청을 추가할 수 있습니다.
    }
  }
}
</script>