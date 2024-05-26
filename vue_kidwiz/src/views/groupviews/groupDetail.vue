<template>
  <div>
    <div class="boundary" v-if="list">
      <hr>
      <div class="mt-3" style="display: flex;">
        <div class="groupimg pe-3" style="width:40%;">
          <div style="width:100%;height: 50%;">
            <img :src="'/images/'+list.img" style="width:100%;height: 100%;">
          </div>
          <div class="mt-3 border border-secondary">
            <div class="text-start p-3">
              <div class="mb-1">{{ list.name }}</div>
              <div class="mb-1">{{ list.major_name }}</div>
              <div class="mb-1">{{ list.contact }}</div>
            </div>
          </div>
        </div>

        <div class="board text-start" style="width:60%">
          <div class="text-center">
            <span class="fw-bold fs-3">{{ list.gr_title }}</span>
          </div>
            <hr>
          <div class="mb-3">
            <div class="mb-1">모집대상 : 전체</div>
            <div class="mb-1">성별 : {{ list.sex }}</div>
            <div class="mb-1">학과 : {{ list.major }}</div>
          </div>
          <hr>
          <div class="border border-secondary p-3" style="height: 200px; overflow-y:auto">
            <div class="mb-3 border-bottom" v-for="row in groupList" :key="row.gr_title" style="display: flex;">
              <div class="flex-grow-1 mb-1">
                <div class="mb-1 fw-bold">{{ row.gr_title }}</div>
                <div class="mb-1" style="font-size: 13px">
                  <svg xmlns="http://www.w3.org/2000/svg" width="13" height="13" fill="currentColor" class="bi bi-calendar-check text-secondary" style="margin-right: 5px;" viewBox="0 0 16 16">
                    <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                    <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4z"/>
                  </svg>
                  {{ row.gr_oper }}</div>
                <div class="mb-1" style="font-size: 13px;display: flex;">
                  <svg xmlns="http://www.w3.org/2000/svg" width="13" height="13" fill="currentColor" class="bi bi-people-fill text-secondary me-2" viewBox="0 0 16 16">
                    <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5.784 6A2.24 2.24 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.3 6.3 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5"/>
                  </svg>
                    <div v-if="row.apply_people != row.total_num">{{ row.apply_people }} / {{ row.total_num }}</div>
                    <div v-else>만석</div>
                  </div>
                <div class="mb-1" style="font-size: 13px" v-if="row.gr_del==1">
                  <svg xmlns="http://www.w3.org/2000/svg" width="13" height="13" fill="currentColor" class="bi bi-check2-square text-secondary" viewBox="0 0 16 16">
                    <path d="M3 14.5A1.5 1.5 0 0 1 1.5 13V3A1.5 1.5 0 0 1 3 1.5h8a.5.5 0 0 1 0 1H3a.5.5 0 0 0-.5.5v10a.5.5 0 0 0 .5.5h10a.5.5 0 0 0 .5-.5V8a.5.5 0 0 1 1 0v5a1.5 1.5 0 0 1-1.5 1.5z"/>
                    <path d="m8.354 10.354 7-7a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0"/>
                  </svg>
                  진행중</div>
                <div class="mb-1" style="font-size: 13px" v-else>
                  <svg xmlns="http://www.w3.org/2000/svg" width="13" height="13" fill="currentColor" class="bi bi-check2-square text-secondary me-1" viewBox="0 0 16 16">
                    <path d="M3 14.5A1.5 1.5 0 0 1 1.5 13V3A1.5 1.5 0 0 1 3 1.5h8a.5.5 0 0 1 0 1H3a.5.5 0 0 0-.5.5v10a.5.5 0 0 0 .5.5h10a.5.5 0 0 0 .5-.5V8a.5.5 0 0 1 1 0v5a1.5 1.5 0 0 1-1.5 1.5z"/>
                    <path d="m8.354 10.354 7-7a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0"/>
                  </svg>
                  종료</div>
              </div>
              <hr>
            </div>
          </div>
        </div>
      </div>
      <div class="mt-3">
        <div class="text-start fw-bold mb-2">
          나의 신청내역
        </div>
        <div>
          <table class="table">
            <thead style="background-color: #CCCCCC;">
              <tr>
                <th>번호</th>
                <th>학번</th>
                <th>타입</th>
                <th>프로그램 일정</th>
                <th>상담사명</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(row,index) in rsv" :key="index">
                <td>{{ index+1 }}</td>
                <td>{{ row.id }}</td>
                <td>{{ row.ctype }}</td>
                <td>{{ row.rsvdate }}</td>
                <td>{{ row.cname }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div class="mt-4">
        <div class="text-start fw-bold mb-2">
          세부내용
        </div>
        <div class="p-3 formatted-text" style="border: 1px solid #c1c1c1; border-top:2px solid black ;">
          {{ list.gr_content }}
      
        </div>
      </div>
    </div>
    <div class="mt-3">
      <button v-if="membercheck" class="btn btn-danger disabled">인원초과</button>
      <button v-else-if="!$store.state.account.id" class="btn btn-primary disabled">신청하기</button>
      <button v-else-if="check==1" class="btn btn-danger disabled">신청완료</button>
      <button v-else-if="$store.state.account.id" @click="applyGroup()" class="btn btn-primary">신청하기</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

export default {
  name:"groupDetail",
  setup(){
    const list = ref()
    const groupList=ref()
    const route = useRoute()
    const no = ref(route.query.no)
    const check = ref();
    const rsv = ref();

    const myConsult = ref();
    const membercheck = ref();

    onMounted(()=>{
      axios.get("/api/groupDetail?gr_no="+no.value).then((res)=>{
        list.value = res.data.list
        groupList.value = res.data.glist

        membercheck.value = groupList.value[0].total_num == groupList.value[0].apply_people

        //중복 체크
        axios.post("/api/checkGroup",list.value, { withCredentials: true }).then((res)=>{
          check.value = res.data
        }).catch(()=>{
          check.value=0
        })
      }).catch((err)=>{
        alert(err)
      })

      axios.get("/api/getRsv",{withCredentials:true}).then((res)=>{
        rsv.value = res.data
      }).catch(()=>{
        rsv.value=null
      })
    })


    const applyGroup = () =>{
      axios.post("/api/applyGroup",list.value, { withCredentials: true }).then(()=>{
        alert("신청 되었습니다.")
      }).catch((err)=>{
        alert(err)
      })
    }

    return{
      applyGroup,groupList,list,check,myConsult,rsv,membercheck
    }
  },
}
</script>

<style>
  .table thead {
    background-color: #f4f4f4 !important;
  }
.formatted-text {
  margin-top: 10px;
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 5px;
  white-space: pre-line; /* 줄바꿈 유지 */
}
</style>