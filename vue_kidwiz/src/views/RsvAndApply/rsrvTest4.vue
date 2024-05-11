<template>
  <div class="calendar-wrapper">
    <h2>상담 신청하기</h2>
    <div class="calendar-content">
      <div class="calendar-container">
        <FullCalendar :options="calendarOptions" id="calendar"></FullCalendar>
      </div>
      <div class="available-times">
        <!-- 날짜가 선택되지 않았을 때의 메시지 -->
        <h3 v-if="!selectedDate" class="initial-message">희망하는 날짜를 선택하시면 <br> 예약 가능 시간이 나타납니다.</h3>
        <!-- 날짜가 선택되었을 때의 메시지 -->
        <h3 v-else>{{ selectedDate }}의 예약 가능 시간</h3>
        <p v-if="isPast">지난 날짜에는 예약이 불가능합니다.</p>
        <ul v-else>
          <li v-for="time in availableTimes" :key="time.id">
            <label>
              <input type="radio" v-model="selectedTime" :value="time">
              {{ time.time }} (남은 자리: {{ time.availableSeats }})
            </label>
          </li>
        </ul>
        <button v-if="!isPast && availableTimes.length > 0" @click="submitReservation">신청하기</button>
      </div>
    </div>
  </div>
</template>

<script>
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import axios from 'axios';
import '../../css/calendar.css';

export default {
  components: {
    FullCalendar
  },
  data() {
    return {
      selectedDate: '',
      selectedTime: null,
      availableTimes: [],
      isPast: false,
      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: 'dayGridMonth',
        locale: 'ko',
        selectable: true,
        weekends: false,
        events: [{ title: 'Meeting', start: new Date() }],
        dateClick: this.fetchDateInfo, // 수정: dateClick 핸들러를 Ajax 호출 함수로 변경
        dayCellDidMount: this.handleDayMount
      }
    };
  },
  methods: {
    fetchDateInfo(info) {
      this.selectedDate = info.dateStr;
      this.selectedTime = null;  // 시간 선택 초기화

      const today = new Date();
      today.setHours(0, 0, 0, 0);
      const clickedDate = new Date(info.dateStr);

      this.isPast = clickedDate < today;
      if (this.isPast) {
        this.availableTimes = [];
        return;
      }

      // 더미 데이터 
      this.availableTimes = [
        { id: 1, time: '10:00 - 11:00', availableSeats: 3 },
        { id: 2, time: '11:00 - 12:00', availableSeats: 5 },
        { id: 3, time: '13:00 - 14:00', availableSeats: 2 },
        { id: 4, time: '14:00 - 15:00', availableSeats: 1 },
        { id: 5, time: '15:00 - 16:00', availableSeats: 3 },
        { id: 6, time: '16:00 - 17:00', availableSeats: 1 },
        { id: 7, time: '17:00 - 18:00', availableSeats: 1 }
      ];
      axios
      //axios.get('/api/available-times', { params: { date: info.dateStr } })
      //  .then(response => {
      //    this.availableTimes = response.data.times;
      //  })
      //  .catch(error => {
      //    console.error("Error fetching available times:", error);
      //    this.availableTimes = [];  // 오류 시 배열 초기화
      //  });

    },
    submitReservation() {
      if (!this.selectedTime) {
        alert("시간을 선택해 주세요.");
        return;
      }
      // 폼 제출 로직: 서버에 예약 데이터 전송
      console.log(`Reservation submitted for ${this.selectedDate} at ${this.selectedTime.time}`);

      this.$router.push({
        name: 'applyForm1',
        params: {
          selectedDate: this.selectedDate,
          selectedTime: this.selectedTime ? this.selectedTime.time : '' 
        }
      });
    },
    handleDayRender({ date, el }) {
      console.log(el);  // 개발자 도구 콘솔에서 확인 가능
      const today = new Date();
      today.setHours(0, 0, 0, 0); // 오늘 날짜의 자정으로 설정
      if (date < today) {
        //el.classList.add('past-date'); // 과거 날짜에 클래스 추가
        el.style.backgroundColor = '#ccc';
        el.style.color = '#666';
        el.style.pointerEvents = 'none';
        el.style.opacity = '0.6';
      }
    }
  }
  //mounted() {
  //  this.calendarOptions = {
  //    plugins: [dayGridPlugin, interactionPlugin],
  //    initialView: 'dayGridMonth',
  //    locale: 'ko',
  //    selectable: true,
  //    weekends: false,
  //    events: [{ title: 'Meeting', start: new Date() }],
  //    dateClick: this.fetchDateInfo,
  //    dayCellDidMount: this.handleDayMount
  //  };
  // }
}
</script>