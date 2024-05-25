<template>
  <div class="container mt-5">
    <h1 class="title">게시판 상담</h1>
    <table class="table">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>답변유무</th>
      </tr>
      <tr v-for="row in list" v-bind:key="row.bno">
        <td v-text="row.no"></td>
        <td
          v-if="row.depth == 0"
          @click="detail(row.bno)"
          style="text-align: left"
        >
          {{ row.btitle }}
        </td>
        <td v-else @click="detail(row.bno)" style="text-align: left">
          <span v-for="(row,index) in row.depth" :key="index">&nbsp;</span>
          ㄴ[:Re]{{ row.btitle }}
        </td>
        <td>{{ row.writer }}</td>
        <td>{{ row.bdate }}</td>
        <td v-if="row.checkUp > 1 || row.depth>0">답변 완료</td>
        <td v-else>답변 대기</td>
      </tr>
    </table>
    <div class="d-flex justify-content-center">
      <ul class="pagination">

        <li class="page-item" v-if="pageMap.currentpage != 1">
          <button class="page-link" aria-label="Previous" @click="changeboard(1)">&laquo;</button>
        </li>
        <li class="page-item" v-else>
            <button class="page-link disabled" aria-label="Previous">&laquo;</button>
        </li>

        <li class="page-item" v-if="pageMap.currentpage != 1">
          <button class="page-link" aria-label="Previous" @click="changeboard(pageMap.currentpage - 1)">&lt;</button>
        </li>
        <li class="page-item" v-else>
          <span>
            <button class="page-link disabled" aria-label="Previous">&lt;</button>
          </span>
        </li>

        <li class="page-item" v-for="n in pageMap.pagelist" :key="n">
          <button class="page-link active" @click="changeboard(n)" v-if="pageMap.currentpage==n">{{ n }}</button>
          <button class="page-link" @click="changeboard(n)" v-else>{{ n }}</button>
        </li>

        <li class="page-item" v-if="pageMap.currentpage != pageMap.totalpage">
            <button class="page-link" @click="changeboard(pageMap.currentpage + 1)" aria-label="Next" aria-hidden="true">&gt;</button>
        </li>
        <li class="page-item" v-else>
          <span>
            <button class="page-link disabled" aria-label="Previous">&gt;</button>
          </span>
        </li>


        <li class="page-item" v-if="pageMap.currentpage != pageMap.totalpage">
            <button class="page-link" @click="changeboard(pageMap.totalpage)" aria-label="Next" aria-hidden="true">&raquo;</button>
        </li>
        <li class="page-item" v-else>
          <span>
            <button class="page-link disabled" aria-label="Previous">&raquo;</button>
          </span>
        </li>

      </ul>
    </div>
    <button class="btn btn-primary" v-if="$store.state.account.id" @click="$router.push('/boardwrite')">글쓰기</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "BoardList",
  data() {
    return {
      requestBody: this.$route.query,
      list: [],
      pageMap: [],
    };
  },
  mounted() {
    axios
      .get("/api/BoardList?currentpage=1")
      .then((res) => {
        this.list = res.data.list;
        this.pageMap = res.data.pageMap;
      })
      .catch((err) => {
        alert("에러 발생 : " + err);
      });
  },
  methods: {
    detail(bno) {
      this.requestBody.bno = bno;
      this.$router.push({ path: "./boardDetail", query: this.requestBody });
    },

    changeboard(pageNo) {
      axios
        .get("/api/BoardList?currentpage=" + pageNo)
        .then((res) => {
          this.list = res.data.list;
          this.pageMap = res.data.pageMap;
        })
        .catch((err) => {
          alert(err);
        });
    },
  },
};
</script>

<style scope>
.table-container {
  margin: 20px;
  padding: 20px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}

.table {
  width: 100%;
  border-collapse: collapse;
  margin: 20px 0;
  font-size: 16px;
  text-align: left;
}

.table th, .table td {
  border-top: 1px solid #ddd;
  border-bottom: 1px solid #ddd;
  border-left: 0;
  border-right: 0;
  padding: 12px;
}

.table th {
  background-color: #f8f9fa;
  color: #333;
}


.table tr:hover {
  background-color: #e4dedef3;
}
</style>