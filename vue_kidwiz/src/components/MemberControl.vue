<template>
  <div class="table-container">
    <h2>회원 관리</h2>
    <table class="table">
      <thead>
        <tr>
          <th>번호</th>
          <th>아이디</th>
          <th>이름</th>
          <th>학과</th>
          <th>직위</th>
          <th style="text-align: center;">상태</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, index) in member" :key="index">
          <td>{{ index + 1 }}</td>
          <td>{{ row.id }}</td>
          <td>{{ row.name }}</td>
          <td>{{ row.major_name }}</td>
          <td>{{ row.dept }}</td>
          <td  style="text-align: center;">
            <button @click="changeGrade(row, 1)" v-if="row.grade ==0" :class="{'status-declined':row.grade ==0,'status-sent':row.grade ==1,'status-pending':row.grade ==2,'status-admin':row.grade==3}">회원탈퇴</button>
            <button @click="changeGrade(row, 2)" v-else-if="row.grade ==1" :class="{'status-declined':row.grade ==0,'status-sent':row.grade ==1,'status-pending':row.grade ==2,'status-admin':row.grade==3}">일반회원</button>
            <button @click="changeGrade(row, 3)" v-else-if="row.grade ==2" :class="{'status-declined':row.grade ==0,'status-sent':row.grade ==1,'status-pending':row.grade ==2,'status-admin':row.grade==3}">&nbsp;&nbsp;교직원&nbsp;&nbsp;</button>
            <button @click="changeGrade(row, 0)" v-else-if="row.grade ==3" :class="{'status-declined':row.grade ==0,'status-sent':row.grade ==1,'status-pending':row.grade ==2,'status-admin':row.grade==3}">&nbsp;&nbsp;관리자&nbsp;&nbsp;</button>
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
    const member = ref([]);
    

    onMounted(() => {
      axios.get("/api/admin/member")
        .then((res) => {
          member.value = res.data.member;
        })
        .catch((error) => {
          console.error("There was an error fetching the data:", error);
        });

    });

    const changeDbGrade = (row) =>{
      axios.post("/api/admin/changeGrade",row)
    }

    const changeGrade = (row,value) =>{
      row.grade = value
      changeDbGrade(row)
    }
    return {
      member,changeGrade
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
.status-admin {
  color: white;
  background-color: #495057; /* 어두운 회색 */
  padding: 5px 10px;
  border-radius: 5px;
}
</style>