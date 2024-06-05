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
                :class="{ selected: selectedCounselingType === type }" @click="selectCounselingType(type)">
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
            희망하는 날짜를 선택하시면 <br /> 예약 가능 시간이 나타납니다.
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
                    class="form-check-input me-2" />
                  {{ time.time }}
                </label>
                <span class="badge" :class="{ 'bg-success': time.available, 'bg-secondary': !time.available }">
                  {{ time.available ? '예약 가능' : '예약 불가' }}
                </span>
              </li>
            </ul>
            <button v-if="!isPast && availableTimes.some((t) => t.available)" @click="submitReservation" class="apply">
              신청하기
            </button>
          </div>
        </div>
      </div>
    </div>
    <event-modal v-model="showModal" :event="currentEvent"></event-modal>
  </div>
</template>

<script>
import { ref, reactive, onMounted, computed } from 'vue';
import { useStore } from 'vuex'; // Vuex의 mapGetters -> useStore
import { useRouter, useRoute } from 'vue-router';
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
    EventModal,
  },
  setup() {
    const store = useStore();
    const router = useRouter();
    const route = useRoute();

    const getAccountId = computed(() => store.getters.getAccountId);

    const selectedDate = ref('');
    const selectedTime = ref(null);
    const availableTimes = ref([]);
    const isPast = ref(false);
    const formURL = ref('');
    const showModal = ref(false);
    const currentEvent = ref({}); // 현재 이벤트 객체
    const counselingTypes = ref(['지도교수 상담', '취업상담', '전문상담', '심리상담']); // 상담 유형 추가
    const selectedCounselingType = ref(''); // 선택된 상담 유형 초기화
    const showCounselingTypeAlert = ref(false); // 상담 유형 선택 알림 표시 여부
    const timeSlots = ref([
      { code: 'A', time: '10:00 - 11:00' },
      { code: 'B', time: '11:00 - 12:00' },
      { code: 'C', time: '13:00 - 14:00' },
      { code: 'D', time: '14:00 - 15:00' },
      { code: 'E', time: '15:00 - 16:00' },
      { code: 'F', time: '16:00 - 17:00' },
      { code: 'G', time: '17:00 - 18:00' },
    ]);
    const majorId = ref(null); // 상담사의 소속 학과 ID (초기값 null)

    const handleEventClick = (info) => {
      currentEvent.value = {
        title: info.event.title,
        start: info.event.start.toISOString(),
      };
      showModal.value = true;
    };

    const handleDayMount = (arg) => {
      const today = new Date();
      today.setHours(0, 0, 0, 0);
      if (arg.date < today) {
        arg.el.style.backgroundColor = '#ccc';
        arg.el.style.color = '#666';
        arg.el.style.pointerEvents = 'none';
        arg.el.style.opacity = '0.6';
      }
    };

    const fetchDateInfo = async (info) => {
      if (!selectedCounselingType.value) {
        showCounselingTypeAlert.value = true;
        return;
      }
      showCounselingTypeAlert.value = false;

      selectedDate.value = info.dateStr;
      selectedTime.value = null;
      availableTimes.value = [];

      const today = new Date();
      today.setHours(0, 0, 0, 0);
      const clickedDate = new Date(info.dateStr);

      isPast.value = clickedDate < today || clickedDate.toDateString() === today.toDateString();
      if (isPast.value) {
        return;
      }

      // 예약 정보를 조회하여 해당 날짜에 예약이 있는 시간대를 비활성화
      let revURL;
      if (selectedCounselingType.value == '전문상담') {
        revURL = `checkRegRev?date=${selectedDate.value}`;
      } else {
        revURL = `api/reservations?date=${selectedDate.value}&type=${selectedCounselingType.value}`;
      }

      try {
        const response = await axios.get(`http://localhost:3000/${revURL}`);
        let reservedTimes;
        if (selectedCounselingType.value == '전문상담') {
          reservedTimes = response.data.map((reservation) => reservation.time);
        } else {
          reservedTimes = response.data.map((reservation) => reservation.ctime);
        }

        availableTimes.value = timeSlots.value.map((slot) => ({
          ...slot,
          available: !reservedTimes.includes(slot.code),
        }));
      } catch (error) {
        console.error('Error fetching reservations:', error);
        availableTimes.value = timeSlots.value.map((slot) => ({
          ...slot,
          available: true,
        }));
      }
      //날짜 강조 스타일
      const days = document.querySelectorAll('.selectedDate');
      days.forEach((day) => day.classList.remove('selectedDate'));
      info.dayEl.classList.add('selectedDate');
    };

    const calendarOptions = reactive({
      plugins: [dayGridPlugin, interactionPlugin],
      initialView: 'dayGridMonth',
      locale: 'ko',
      selectable: false,
      weekends: false,
      editable: false,
      validRange: {
        // 오늘부터 한 달까지만 달력에 나오도록
        start: Date.now(),
        end: new Date(new Date().setMonth(new Date().getMonth() + 1)),
      },
      events: [],
      eventClick: handleEventClick,
      dateClick: fetchDateInfo,
      dayCellDidMount: handleDayMount,
    });

    onMounted(() => {
      loadReservations();
      selectedCounselingType.value = route.query.selectedCounselingType;
      loadMajorId();
    });

    const loadReservations = async () => {
      try {
        const response = await axios.get('/api/reservations');
        calendarOptions.events = response.data.map((reservation) => ({
          title: 'Reservation',
          start: `${reservation.cdate}T${reservation.ctime.split(' - ')[0]}:00`,
          end: `${reservation.cdate}T${reservation.ctime.split(' - ')[1]}:00`,
        }));
      } catch (error) {
        console.error('Error fetching reservations:', error);
      }
    };

    const loadMajorId = async () => {
      try {
        const response = await axios.get(`/api/members/${getAccountId.value}`);
        majorId.value = response.data.major_id; //response 데이터에서 major_id 가져오기
      } catch (error) {
        console.error('Error fetching majorId:', error);
      }
    };

    const selectCounselingType = (type) => {
      selectedCounselingType.value = type;
      //상담유형 미선택 시 날짜누르면 alert
      showCounselingTypeAlert.value = false;

      if (selectedDate.value) {
        // 날짜가 이미 선택된 상태라면, 해당 날짜의 예약 가능 시간을 다시 조회
        fetchDateInfo({
          dateStr: selectedDate.value,
          dayEl: document.querySelector(`.fc-day[data-date="${selectedDate.value}"]`),
        });
      }
    };

    const submitReservation = async () => {
      if (!selectedTime.value || !selectedCounselingType.value) {
        alert('상담 유형과 시간을 선택해 주세요.');
        return;
      }
      //예약 데이터 담기
      const reservationData = {
        sid: getAccountId.value,
        ctype: selectedCounselingType.value,
        ctime: selectedTime.value.time,
        ctimecode: selectedTime.value.code, //시간 코드(A~G)
        cdate: selectedDate.value,
        rsvdate: new Date().toISOString().split('T')[0],
        rsvmemo: '',
      };

      // reservationData를 사용
      console.log('예약 데이터:', reservationData);

      const formURL = selectedCounselingType.value === '전문상담' ? 'applyForm3' : 'applyForm1';

      router.push({
        name: formURL,
        query: {
          selectedDate: selectedDate.value,
          selectedTime: selectedTime.value.time,
          selectedCounselingType: selectedCounselingType.value,
          ctimecode: selectedTime.value.code,
        },
      });
    };

    return {
      selectedDate,
      selectedTime,
      availableTimes,
      isPast,
      formURL,
      showModal,
      currentEvent,
      counselingTypes,
      selectedCounselingType,
      showCounselingTypeAlert,
      calendarOptions,
      selectCounselingType,
      submitReservation,
      fetchDateInfo,
      handleEventClick,
      handleDayMount,
    };
  },
};
</script>

<style scoped>
.apply {
  width: 30%;
  height: 35px;
  margin: 15px 10px;
  color: white;
  background-color: #67bf4e;
  border: none;
  font-family: 'sjl';
}
</style>
