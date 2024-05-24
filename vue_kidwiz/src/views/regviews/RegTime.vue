<template>
  <div class="container calendar-wrapper my-5">
    <h2 class="text-center mb-4 bigTitle">{{name}} ({{ application.stuNum }}) 상담 신청</h2>
    <div class="row">
      <div class="col-md-6">
        <div class="calendar-container mb-4">
          <FullCalendar :options="calendarOptions" id="calendar"></FullCalendar>
        </div>
      </div>
      <div class="col-md-6">
        <div class="available-times p-3 border rounded">

          <!-- 240517 상담 유형 선택 추가 -->
          <div class="counseling-type-selection mb-3">            
            <div role="group" aria-label="Counseling Types">
              <h4 class="title">전문상담 예약 ( {{ selectedDate }} )</h4>
            </div>
          </div>
          <!-- 날짜가 선택되지 않았을 때의 메시지 -->
          <div v-if="!selectedDate && !showCounselingTypeAlert" class="alert alert-info">
            희망하는 날짜를 선택하시면 <br> 예약 가능 시간이 나타납니다.
          </div>
          <!-- 날짜가 선택되었을 때의 메시지 -->
          <div v-else>
            <p v-if="isPast">당일 및 이전 날짜는 예약이 불가능합니다.</p>
            <ul class="list-group box">
              <li v-for="time in availableTimes" :key="time.time"
                class="list-group-item d-flex justify-content-between align-items-center">
                <label class="form-check-label">
                  <input type="radio" v-model="selectedTime" :value="time" :disabled="!time.available"
                    class="form-check-input me-2">
                  {{ time.time }}
                </label>
                <span class="badge" :class="{ 'bg-success': time.available, 'bg-secondary': !time.available }">
                  {{ time.available ? '예약 가능' : '예약 불가' }}
                </span>
              </li>
            </ul>            
            <button v-if="!isPast && availableTimes.some(t => t.available)" @click="submitReservation" class="submitBtn">신청하기</button>
          </div>
        </div>
        <textarea class="memo" v-model="application.memo" placeholder="메모 작성"></textarea>
      </div>      
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'; // Vuex에서 mapGetters 사용
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import axios from 'axios';
import '../../css/calendar.css';
import 'bootstrap/dist/css/bootstrap.min.css';

export default {
  components: {
    FullCalendar
  },
  data() {
    return {
      name:'',
      selectedDate: '',
      selectedTime: null,
      availableTimes: [],
      isPast: false,
      showModal: false, // 모달창 표시 여부
      currentEvent: {}, // 현재 이벤트 객체
      selectedCounselingType: '전문상담', // 선택된 상담 유형 초기화
      showCounselingTypeAlert: false, // 상담 유형 선택 알림 표시 여부

      //studentId: 24300011, // 학생 ID (임의 값)
      majorId: null, // 상담사의 소속 학과 ID (초기값 null)

      // 예약 가능한 시간대 정의
      timeSlots: [
        { code: 'A', time: '10:00 - 11:00' },
        { code: 'B', time: '11:00 - 12:00' },
        { code: 'C', time: '13:00 - 14:00' },
        { code: 'D', time: '14:00 - 15:00' },
        { code: 'E', time: '15:00 - 16:00' },
        { code: 'F', time: '16:00 - 17:00' },
        { code: 'G', time: '17:00 - 18:00' }
      ],

      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: 'dayGridMonth',
        locale: 'ko',
        selectable: false,
        weekends: false,
        editable: false,
        validRange: { // 오늘부터 한 달까지만 달력에 나오도록
          start: Date.now(),
          //start: new Date(new Date().setDate(new Date().getDate() + 1)),
          //end: Date.now() + 2592000000,
          end: new Date(new Date().setMonth(new Date().getMonth() + 1))
        },
        events: [],
        eventClick: this.handleEventClick,
        dateClick: this.fetchDateInfo,        
        dayCellDidMount: this.handleDayMount
      },      
      application: {
        stuNum: '',
        proNum: '',
        date: '',
        time: '',
        reg_no: '',
        memo:'',
        times: '',
      },      
    };
  },
  computed: {
    ...mapGetters(['getAccountId']) // Vuex store의 account id getter를 사용
  },
  mounted(){    
      axios.get('http://localhost:3000/getRegInfo?regno='+this.$route.query.regno).then((res) => {      
        console.log(res.data);
            if(res.data.currentTimes >= 10){
            alert("모든 회기가 종료된 상담입니다.");
              window.close();
            } else {
              this.name = res.data.name;
              this.application.times = res.data.currentTimes+1;
              this.application.proNum = res.data.pro;
              this.application.reg_no = this.$route.query.regno;
              this.application.stuNum = this.$route.query.stuNum;
            }
          }).catch((err) => {
            console.log(err);
          })
  },
  methods: {
    fetchDateInfo(info) {
      this.showCounselingTypeAlert = false;

      this.selectedDate = info.dateStr;
      this.selectedTime = null;  // 시간 선택 초기화
      this.availableTimes = [];  // 추가: 이전 날짜의 시간이 남아있지 않도록 초기화

      const today = new Date();
      today.setHours(0, 0, 0, 0);
      const clickedDate = new Date(info.dateStr);

      this.isPast = clickedDate < today || clickedDate.toDateString() === today.toDateString();
      if (this.isPast) {
        return;

      }
      // 예약 정보를 조회하여 해당 날짜에 예약이 있는 시간대를 비활성화
      axios.get('http://localhost:3000/regReservations?date=' + this.selectedDate).then(response => {
        console.log("**-*-*-*-*");
        console.log(response.data);
        const reservedTimes = response.data.map(reservation => reservation.time);
        this.availableTimes = this.timeSlots.map(slot => ({
      ...slot,

          available: !reservedTimes.includes(slot.code)
        }));
      }).catch(error => {
        console.error("Error fetching reservations:", error);
      this.availableTimes = this.timeSlots.map(slot => ({
      ...slot,
      available: true
    }));
  });

      //날짜 강조 스타일
      let days = document.querySelectorAll(".selectedDate");
      days.forEach(day => day.classList.remove("selectedDate"));
      info.dayEl.classList.add("selectedDate");
    },
    async submitReservation() {
      if (!this.selectedTime) {
        alert("상담 시간을 선택해 주세요.");
        return;
      }      
      if(!confirm("신청하시겠습니까?")){
        return false;
      }
      this.application.date = this.selectedDate;
      this.application.time = this.selectedTime.code;
      await axios.post('http://localhost:3000/regSubmit',this.application)
      .then((res)=>{
        console.log(res);
        if(res.data>0){
          alert('제출됨');
          window.close();
        } else {
          alert('제출 실패');
        }
      }).catch((err)=>{
        alert(err);
      })

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
    },
    handleEventClick(info) {
      // 이벤트 클릭 시 실행될 로직
      this.currentEvent = {
        title: info.event.title,
        start: info.event.start.toISOString()
      };
      this.showModal = true;  // 모달창 표시
    },
  }
}

</script>

<style scoped>
.box{
  margin-top: -25px;
}
.available-times{
  height: 400px;
}
.memo{
  margin-top: 10px;
  margin-left: 20px;
  width: 526px;
  height: 100px;
}
.submitBtn{
  margin-top: 10px;
}
.bigTitle{
  font-family: 'sj';
}
</style>