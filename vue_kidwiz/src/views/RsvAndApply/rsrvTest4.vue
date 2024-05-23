<template>
  <div class="container calendar-wrapper my-5">
    <h2 class="text-center mb-4">상담 신청하기</h2>
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
            <h3 class="h5 mb-3">상담 유형을 선택하세요:</h3>
            <div role="group" aria-label="Counseling Types">
              <button type="button" v-for="type in counselingTypes" :key="type" class="counseling-type"
                :class="{ 'selected': selectedCounselingType === type }" @click="selectCounselingType(type)">
                {{ type }}
              </button>
            </div>
          </div>

          <!-- 날짜 클릭 전에 상담 유형이 선택되지 않았을 때의 메시지 -->
          <div v-if="showCounselingTypeAlert" class="alert alert-warning">
            상담 유형을 먼저 선택해주세요.
          </div>

          <!-- 날짜가 선택되지 않았을 때의 메시지 -->
          <div v-if="!selectedDate && !showCounselingTypeAlert" class="alert alert-info">
            희망하는 날짜를 선택하시면 <br> 예약 가능 시간이 나타납니다.
          </div>
          <!-- 날짜가 선택되었을 때의 메시지 -->
          <div v-else>
            <h3 class="h5">{{ selectedDate }}의 예약 가능 시간</h3>
            <p v-if="isPast">당일 및 이전 날짜는 예약이 불가능합니다.</p>
            <ul class="list-group">
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
            <button v-if="!isPast && availableTimes.some(t => t.available)" @click="submitReservation">신청하기</button>
          </div>
        </div>
      </div>
    </div>
    <event-modal v-model="showModal" :event="currentEvent"></event-modal>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'; // Vuex에서 mapGetters 사용
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import EventModal from './EventModal.vue';
import axios from 'axios';
import '../../css/calendar.css';
import 'bootstrap/dist/css/bootstrap.min.css';

export default {
  components: {
    FullCalendar,
    EventModal
  },
  data() {
    return {
      selectedDate: '',
      selectedTime: null,
      availableTimes: [],
      isPast: false,
      showModal: false, // 모달창 표시 여부
      currentEvent: {}, // 현재 이벤트 객체
      counselingTypes: ['지도교수 상담', '취업상담', '전문상담', '심리상담'], // 상담 유형 추가
      selectedCounselingType: '', // 선택된 상담 유형 초기화
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
      }
    };
  },
  created() {
    this.loadReservations();
  },
  computed: {
    ...mapGetters(['getAccountId']) // Vuex store의 account id getter를 사용
  },
  methods: {
    loadReservations() {
      axios.get('/api/reservations')
        .then(response => {
          this.calendarOptions.events = response.data.map(reservation => {
            return {
              title: 'Reservation',
              start: `${reservation.cdate}T${reservation.ctime.split(' - ')[0]}:00`,
              end: `${reservation.cdate}T${reservation.ctime.split(' - ')[1]}:00`
            };
          });
        })
        .catch(error => {
          console.error("Error fetching reservations:", error);
        });
    },
    /*loadMajorId() {
      axios.get(`/api/members/${this.getAccountId}`)
        .then(response => {
          this.majorId = response.data.major_id; // 응답에서 major_id 가져오기
        })
        .catch(error => {
          console.error("Error fetching majorId:", error);
        });
    },*/
    fetchDateInfo(info) {

      //상담유형 미선택 시 날짜누르면 alert
      if (!this.selectedCounselingType) {
        this.showCounselingTypeAlert = true;
        return;
      }
      this.showCounselingTypeAlert = false;

      this.selectedDate = info.dateStr;
      this.selectedTime = null;  // 시간 선택 초기화
      this.availableTimes = [];  // 추가: 이전 날짜의 시간이 남아있지 않도록 초기화

      const today = new Date();
      today.setHours(0, 0, 0, 0);
      const clickedDate = new Date(info.dateStr);

      //  this.isPast = clickedDate < today;
      //  if (this.isPast) {
      //    this.availableTimes = [];
      //    return;
      //  }
      this.isPast = clickedDate < today || clickedDate.toDateString() === today.toDateString();
      if (this.isPast) {
        return;
        //} else if (clickedDate.toDateString() === today.toDateString()) {
        //  this.isPast = true; // 당일 클릭 시 isPast를 true로 설정
        //  this.availableTimes = [];
        //  return;
      }

      // 예약 정보를 조회하여 해당 날짜에 예약이 있는 시간대를 비활성화
      axios.get('http://localhost:3000/api/reservations?date=' + this.selectedDate + "&type=" + this.selectedCounselingType, {

      }).then(response => {
        const reservedTimes = response.data.map(reservation => reservation.ctime);
        //this.availableTimes = this.timeSlots.map((slot, index) => ({
        //  id: index + 1, // 각 시간에 고유 id를 설정
        //  time: slot.time,
        //  code: slot.code,
        this.availableTimes = this.timeSlots.map(slot => ({
      ...slot,

          available: !reservedTimes.includes(slot.code)
        }));
      }).catch(error => {
        console.error("Error fetching reservations:", error);
        //this.availableTimes = this.timeSlots.map(time => ({ time, available: true }));
      //});
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
    selectCounselingType(type) {
      this.selectedCounselingType = type;
      this.showCounselingTypeAlert = false;

      if (this.selectedDate) {
        // 날짜가 이미 선택된 상태라면, 해당 날짜의 예약 가능 시간을 다시 조회
        this.fetchDateInfo({ dateStr: this.selectedDate, dayEl: document.querySelector('.fc-day[data-date="' + this.selectedDate + '"]') });
      }

    },
    loadMemberInfo() {
      axios.get(`/api/reservations/members/${this.account.id}`)
        .then(response => {
          this.majorId = response.data.major_id; // response 데이터에서 major_id 가져오기
        })
        .catch(error => {
          console.error("Error fetching member info:", error);
        });
    },

    submitReservation() {
      if (!this.selectedTime || !this.selectedCounselingType) {
        alert("상담 유형과 시간을 선택해 주세요.");
        return;
      }

      const formRouteMap = {
        '지도교수 상담': 'applyForm1',
        '취업상담': 'applyForm2',
        '전문상담': 'applyForm3',
        '심리상담': 'applyForm4'
      };

      const formRoute = formRouteMap[this.selectedCounselingType] || 'applyForm4';

        // 240522 상담 유형에 따라 적절한 상담자 ID 가져오기

          //예약 데이터 담기
          const reservationData = {
            sid: this.getAccountId,
            ctype: this.selectedCounselingType,
            ctime: this.selectedTime.time,
            ctimecode: this.selectedTime.code, //시간 코드(A~G)
            cdate: this.selectedDate,
            rsvdate: new Date().toISOString().split('T')[0],
            rsvmemo: ''
          };

          console.log('Reservation data being sent:', reservationData);

          this.$router.push({
                name: formRoute,
                query: {
                  selectedDate: this.selectedDate,
                  selectedTime: this.selectedTime.time,
                  selectedCounselingType: this.selectedCounselingType,
                  ctimecode: this.selectedTime.code
                }
              });

      // 폼 제출 로직: 서버에 예약 데이터 전송
      console.log('폼 제출 로직에 값 확인-------------------------------------------')
      console.log(`예약날짜 ${this.selectedDate} 시간 ${this.selectedTime.time} 시간코드 ${this.selectedTime.code}`);

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

    close() {
      this.$emit('update:modelValue', false);
    }
  }
}

</script>