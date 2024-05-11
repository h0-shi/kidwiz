<template>
  <div>
  <h1>Demo App</h1>
  <FullCalendar :options='calendarOptions'>
    <template v-slot:eventContent='arg'>
      <div>
      <b>{{ arg.timeText }}</b>
      <i>{{ arg.event.title }}</i>
    </div>
    </template>
  </FullCalendar>
</div>
</template>

<script>
import '@fullcalendar/common/main.css'; // FullCalendar 공통 CSS
//import '@fullcalendar/daygrid/main.css'; // dayGrid 플러그인 CSS, 필요하다면 추가하세요.

import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';

export default {
  components: {
    FullCalendar // make the <FullCalendar> tag available
  },
  data: function() {
    return {
      calendarOptions: {
        plugins: [dayGridPlugin],
        initialView: 'dayGridMonth',
        weekends: false,
        events: [
          { title: 'Meeting', start: new Date() }
        ]
      }
    }
  }
}
</script>