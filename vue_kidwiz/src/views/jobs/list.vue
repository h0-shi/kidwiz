<template>
  <div>
    <MenuPage />
    <div class="boundary">
      <h1 class="title">취업 리스트 크롤링</h1>
      <jobSecMenu />
      <div class="container">
        <div v-if="jobs.length">
          <table class="job-table">
            <thead>
              <tr>
                <th>채용 제목</th>
                <th>기관</th>
                <th>고용 형태</th>
                <th>근무 지역</th>
                <th>접수 기간</th>
                <th>상세 정보</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="job in jobs" :key="job.detailLink">
                <td>{{ job.title }}</td>
                <td>{{ job.company }}</td>
                <td>{{ job.location }}</td>
                <td>{{ job.date }}</td>
                <td><a :href="job.detailLink" target="_blank">상세보기</a></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div v-else>
          <p>채용 정보를 불러오는 중...</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MenuPage from "@/components/MenuPage.vue";
import jobSecMenu from "@/views/jobs/jobSecMenu.vue";
import axios from 'axios';

export default {
  name: "CounselingInfo",
  components: {
    MenuPage,
    jobSecMenu,
  },
  data() {
    return {
      jobs: []
    };
  },
  methods: {
    fetchJobs() {
      const apiKey = 'wqF25IkSZaAdvYJHuzn8tR5NGdWuqjgFMBASZn3LEimWCQmEjFVNj1cLxPdEg4j8wowdCf%2BcGRuwy1Ci7kth4g%3D%3D'; // 여기에 실제 API 키를 넣으세요
      axios.get(`http://localhost:3000/api/jobslists`, {
        params: {
          apiKey: apiKey
        }
      })
      .then(response => {
        // 응답 데이터 구조에 맞게 처리
        this.jobs = response.data.result;
      })
      .catch(error => {
        console.error('Error fetching jobs:', error);
      });
    }
  },
  created() {
    this.fetchJobs();
  }
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.job-table {
  width: 100%;
  border-collapse: collapse;
}

.job-table th, .job-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.job-table th {
  background-color: #f2f2f2;
}

.job-table a {
  color: blue;
  text-decoration: underline;
}

.job-table td:last-child {
  width: 90px; /* 상세 정보 칸 크기 조정 */
  word-wrap: break-word; /* 단어가 길 경우 줄 바꿈 처리 */
}
</style>