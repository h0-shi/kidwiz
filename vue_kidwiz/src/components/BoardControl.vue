<template>
  <div class="table-container">
    <h2>게시판 관리</h2>
    <table class="table">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>글쓴이</th>
          <th>유형</th>
          <th>날짜</th>
          <th style="text-align: center;">상태</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, index) in board" :key="index">
          <td>{{ index + 1 }}</td>
          <td>{{ row.title }}</td>
          <td>{{ row.writer }}</td>

          <td v-if="row.pri_no.substring(0,2)=='gr'">그룹</td>
          <td v-else-if="row.pri_no.substring(0,2)=='bn'">게시판</td>
          <td v-else>fnq</td>

          <td>{{ row.date }}</td>
          <td  style="text-align: center;">
            <button @click="changeDel(row, 1)" v-if="row.del ==0" :class="{'status-declined':row.del ==0,'status-sent':row.del ==1}">삭제</button>
            <button @click="changeDel(row, 0)" v-else-if="row.del ==1" :class="{'status-declined':row.del ==0,'status-sent':row.del ==1}">복원</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';
import { onMounted, ref } from 'vue';

export default {
  name: "MemberControl",
  setup() {
    const board = ref([]);

    onMounted(() => {
      axios.get("/api/admin/totalBoard")
        .then((res) => {
          board.value = res.data.list;
        })
        .catch((error) => {
          console.error("There was an error fetching the data:", error);
        });
    });


    const changeDbDel = (row) =>{
      axios.post("/api/admin/changeDb",row)
    }

    const changeDel = (row,value) =>{
      row.del = value
      changeDbDel(row)
    }
    return {
      board,changeDel
    };
  }
}
</script>

<style scoped>
button {
  border: none;
  outline: none; /* 선택 상태에서 테두리 제거 */
}

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

.status-sent {
  color: white;
  background-color: #28a745;
  padding: 5px 10px;
  border-radius: 5px;
}

.status-pending {
  color: white;
  background-color: #ffc107;
  padding: 5px 10px;
  border-radius: 5px;
}

.status-declined {
  color: white;
  background-color: #dc3545;
  padding: 5px 10px;
  border-radius: 5px;
}
</style>