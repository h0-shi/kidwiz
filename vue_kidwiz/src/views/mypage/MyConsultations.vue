 <template>
  <div>
        <MySidebar></MySidebar>
    <MenuPage />
    <div class="mainContainer">
      <div class="row">
        <main class="">
          <h2 class="mb-4 title">나의 상담 내역</h2>
          <hr class="line">
          <div class="mt-4">
            <table class="table table-striped">
              <thead>
                <tr class="tr">
                  <th>번호</th>
                  <th>신청자 학번</th>
                  <th>신청자 이름</th>
                  <th>예약 일자</th>
                  <th>상담 희망일</th>
                  <th>상담 희망시간</th>
                  <th>상담 상태</th>
                  <th>상담 일지</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="rsv in state.rsvs" v-bind:key="rsv.id">
                  <th>{{ rsv.rsvno }}</th>
                  <td>{{ rsv.sid }}</td>
                  <td>{{ rsv.name }}</td>
                  <td>{{ rsv.rsvdate }}</td>
                  <td>{{ rsv.cdate }}</td>
                  <td>{{ rsv.ctime }}</td>
                  <td>상담 상태 만들어??</td>
                  <td>
                    <router-link :to="`/ProResultWrite/${rsv.rsvno}`">
                      <button>상담일지 작성</button>
                    </router-link>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
import MenuPage from "@/components/MenuPage.vue";
import MySidebar from "@/components/MySidebar.vue";
import { reactive } from "vue";
import axios from "axios";

export default {
  name: "MyConsultations",
  components: {
    MenuPage,
    MySidebar,
  },

  setup() {
    const state = reactive({
      rsvs: [],
    });

    const load = () => {
      axios
        .get("http://localhost:3000/api/rsv/list", { withCredentials: true })
        .then((response) => {
          state.rsvs = response.data;
          console.log(response.data);
        });
    };

    // 컴포넌트가 마운트될 때 초기 데이터를 불러옴
    load();

    return { state };
  },
};
</script>

<style scoped>
.container-fluid {
  padding-top: 56px;
}
.table {
  margin-top: 20px;
}
.mainContainer{
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
}
.line{
  width: 40%;  
}
.title{
  text-align: left;
  font-family: 'sj';
}
.tr{
  font-family: 'sjl';
}
</style>