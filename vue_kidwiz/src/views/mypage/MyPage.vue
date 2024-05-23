<template>
  <div>
        <MySidebar></MySidebar>
    <div class="container-fluid mt-5 pt-4 boundary">
      <div class="row">
        <main class="main-content">
          <h1 class="mb-4">마이페이지입니다</h1>
          <div class="userInfo mb-5">
            일단 여기 유저 정보
          </div>
          <div class="schedule">
          <div class="calendarContainer">
            <h4 class="boxTitle">시간표</h4>
            <FullCalendar :options="calendarOptions" id="calendar"></FullCalendar>
          </div>
          <div class="timeListContainer">
          <h4 class="boxTitle mt-3 mb-3">일정</h4>
          <div class="date">
            <a @click="postday()">L</a>
            <span>{{today}}</span>
            <a @click="nextday()">R</a>
          </div>
          <hr class="halfLine mb-3">
          <table class="timeList">
            <thead>
              <tr>
                <th>날짜</th>
                <th>일정</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="row in schedule" :key="row.title">
                <td>{{row.start}}</td>
                <td>{{ row.title }}</td>
              </tr>
            </tbody>
          </table>
          </div>
        </div>
          <div class="mt-4">
            <p>현재 로그인한 사용자 id: <strong>{{ $store.state.account.id }}</strong></p>
            <p>현재 로그인한 사용자 email: <strong>{{ $store.state.account.email }}</strong></p>
            <p>현재 로그인한 사용자 name: <strong>{{ $store.state.account.name }}</strong></p>
          </div>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
import MySidebar from '@/components/MySidebar.vue';
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import axios from 'axios';
import '../../css/calendar2.css';
import dayjs from 'dayjs';

export default {
  name: 'MyPage',
  components: {
    MySidebar,
    FullCalendar
  },
  data(){
    return {
      today: null,
      schedule: [],
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
    }
  },
  mounted(){
    this.today = dayjs().format('YYYY-MM-DD');
    this.getScehdule();
  },
  methods: {
    nextday(){
      this.today = dayjs(this.today).add(1,'day').format('YYYY-MM-DD');
      this.getOnedayScehdule();
    },
    postday(){
      this.today = dayjs(this.today).subtract(1,'day').format('YYYY-MM-DD');
      this.getOnedayScehdule();
    },
    getOnedayScehdule(){
      axios.get('http://localhost:3000/rsvs?date='+this.today).then((res) => {
      this.schedule = res.data;
      console.log(res.data);
    }).catch((err) => {
      console.log(err);
    })   
    },
    getScehdule(){
      axios.get('http://localhost:3000/getScehdule').then((res) => {
      console.log(res.data);
      this.calendarOptions.events = res.data;
    }).catch((err) => {
      console.log(err);
    })   
    }
  }

}
</script>

<style scoped>
.userInfo{
  border: 1px solid black;
  background-color: yellow;
  box-shadow: 0 1rem 3rem rgba(0, 0, 0, 0.175) !important;
}
.boxTitle{
  font-family: 'sj';
}
.date span{
  margin: 0 20px 0 20px;
  font-family: 'sj';
  font-size: large;
}
.halfLine{
  width: 90%;
  margin: 0 auto;
}
.schedule{
  width: 100%;
  display: flex;
  justify-content: space-between;
}
.container-fluid {
  padding-top: 56px; 
}
.calendarContainer{
  width: 49%;
  margin: 0;
  padding: 15px;
  border: 1px solid #c0c0c0;
  border-radius: 15px;
}
.timeListContainer{
  width: 49%;
  border: 1px solid #c0c0c0;
  border-radius: 15px;
}
.timeList{
  width: 100%;
  margin-left: 10px;
}
.boundary{
  width: 100%;
  max-width: 1200px;
}
.sidebar {
  position: -webkit-sticky;
  position: sticky;
  top: 0;
  height: calc(100vh - 56px);
  padding-top: 1rem;
  overflow-x: hidden;
  overflow-y: auto; 
}
.sidebar .nav-link {
  font-weight: 500;
  color: #333;
}
.sidebar .nav-link:hover {
  color: #007bff;
}
.main-content {
  flex: 1; /* 나머지 공간을 모두 채우도록 설정 */
  padding-left: 20px; /* 사이드바 영역과 겹치지 않도록 왼쪽 여백 설정 */
}
a{
  color:black;
}
</style>
