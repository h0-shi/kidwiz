<template>
  <div class="py-5 mt-5">
    <div class="container text-start">
      <!-- row-cols-1은 행에 열 1개씩 배치, 
        row-cols-sm-2 : 가로화면 크기가 576px보다 크거나 같으면 행에 2개씩 배치
        row-cols-md-3 : 가로화면 크기가 768px보다 크거나 같으면 행에 3개씩 배치  -->
        
      <div class="row row-cols-2 row-cols-sm-2 row-cols-md-3 row-cols-lg-4">

        <div class="col mb-3" v-for="row in list" v-bind:key="row.gr_no">
          <div class="card">
            <router-link :to="{path:'./groupDetail',query:{no:row.gr_no}}">
              <div class="file-preview-wrapper">
                <img class="card-img-top img-thumbnail" :src="require(`@public/images/${row.img}`)" alt="...">
              </div>
              <div class="card-body">
                <h6 class="card-title" style="font-weight: bold">{{ row.gr_title }}</h6>
                <br>
                <small class="text-muted">신청 : {{ row.gr_apply }}</small><br>
                <small class="text-muted">운영 : {{ row.gr_oper }}</small>
              </div>
            <div class="hiddenCard">
              <div class="mb-1" style="color: yellow;font-size: 10px;">학생상담센터</div>
              <div class="mb-1 fw-bold" style="font-size:20px">{{ row.gr_title }}</div>
              <div class="mb-1"><small style="color: #c1c1c1;">{{ row.gr_oper }}</small></div>
              <div class="mb-2"><small>개인</small></div>
              <div class="mb-1" style="border: 1px solid;width:40px;height: 40px;display: flex;justify-content: center;align-items: center;border-radius: 10px;background: rgba(128, 128, 128, 0.5);"> <div>{{row.apply_people }}/{{ row.total_num }}</div></div>
              <div v-if="row.apply_people == total_num" style="border: 1px solid;width:40px;height: 40px;display: flex;justify-content: center;align-items: center;border-radius: 10px;background-color: rgba(255, 0, 0, 0.5);"> <div>정원 완료</div></div>
              <div class="fw-bold" style="display: flex;justify-content: center;align-items: center;position: absolute; bottom: 0; left: 0; width: 100%;height: 50px; background-color: blue;">자세히 보기</div>
            </div>
            </router-link>
          </div>
        </div>

      </div>

      <div style="width: 100%;">
        <div class="d-flex justify-content-center">
          <ul class="pagination" style="">

            <li class="page-item" v-if="pageMap.currentpage != 1">
              <span class="page-link" aria-label="Previous" @click="changegroup(1)">&laquo;</span>
            </li>
            <li  class="page-item" v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&laquo;</span>
              </span>
            </li>

            <li class="page-item" v-if="pageMap.currentpage != 1">
              <span class="page-link" aria-label="Previous" @click="changegroup(pageMap.currentpage - 1)">&lt;</span>
            </li>
            <li v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&lt;</span>
              </span>
            </li>

            <li class="page-item" v-for="n in pageMap.pagelist" :key="n">
              <span class="page-link active" @click="changegroup(n)" v-if="pageMap.currentpage==n">{{ n }}</span>
              <span class="page-link" @click="changegroup(n)" v-else>{{ n }}</span>
            </li>

            <li class="page-item" v-if="pageMap.currentpage != pageMap.totalpage">
              <span class="page-link" @click="changegroup(pageMap.currentpage + 1)" aria-label="Next">
                <span aria-hidden="true">&gt;</span>
              </span>
            </li>
            <li v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&gt;</span>
              </span>
            </li>


            <li class="page-item" v-if="pageMap.currentpage != pageMap.totalpage">
              <span class="page-link" @click="changegroup(pageMap.totalpage)" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </span>
            </li>
            <li v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&raquo;</span>
              </span>
            </li>

          </ul>
        </div>
        <div style="display: flex;justify-content: center;">
          <button v-if="dept =='상담사'" class="btn btn-primary" @click="groupcreate()">상담 등록</button>
        </div>
        
      </div>



    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { onMounted, ref } from 'vue';

export default {
  name:"groupList",
  setup(){
    const dept = ref();

    onMounted(()=>{
      axios.post("/api/getMemberType", { withCredentials: true }).then((res)=>{
        dept.value = res.data.dept
      }).catch(()=>{
        dept.value = null
      })
    })

    return {
      dept
    }
  },
  data(){
    return{
      list:[],
      pageMap:[],
    }
  },
  mounted(){
    axios.get("/api/getGroupList?currentpage=1").then((res)=>{
      this.list=res.data.list
      this.pageMap=res.data.pageMap
    }).catch((err)=>{
      alert(err)
    })
  },
  methods:{
    changegroup(page){
      axios.get("/api/getGroupList?currentpage="+page).then((res)=>{
        this.list=res.data.list
        this.pageMap=res.data.pageMap
      }).catch((err)=>{
        alert(err)
      })
    },
    groupcreate(){
      this.$router.push({path:"/groupCreate"})
    }
  }
};
</script>

<style scoped>
.file-preview-wrapper > img {
  position: relative;
  width: 100%;
  height: 200px;
  z-index: 1; /* 낮은 z-index 설정 */
}

.container {
  width: 1100px;
}

a {
  text-decoration-line: none;
}
a:link {
  color: black;
}
a:visited {
  color: black;
}
a:hover {
  color: black;
}
a:active {
  color: black;
}

.card {
  transition: box-shadow 0.3s ease-in-out;
  position: relative;
  overflow: hidden;
}

.card:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.hiddenCard {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.7);
  color: white;
  text-align: center;
  box-sizing: border-box;
  opacity: 0;
  transition: opacity 0.3s ease-in-out;
  z-index: 2; /* 높은 z-index 설정 */
}

.card:hover .hiddenCard {
  opacity: 1;
}
</style>