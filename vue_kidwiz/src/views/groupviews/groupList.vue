<template>
  <div class="py-5">
    <div class="container text-start">
      <!-- row-cols-1은 행ㅇ에 열 1개씩 배치, 
        row-cols-sm-2 : 가로화면 크기가 576px보다 크거나 같으면 행에 2개씩 배치
        row-cols-md-3 : 가로화면 크기가 768px보다 크거나 같으면 행에 3개씩 배치  -->
        
      <div class="row row-cols-2 row-cols-sm-2 row-cols-md-3 row-cols-lg-4">

        <div class="col" v-for="row in list" v-bind:key="row.gr_no">
          <div class="card">
            <router-link :to="{path:'./groupDetail',query:{no:row.gr_no}}">
              <img class="card-img-top img-thumbnail" src="@public/images/song.jpg" alt="...">
              <div class="card-body">
                <h5 class="card-title">{{ row.gr_title }}</h5>
                <p class="card-text">content</p>
                <small class="text-muted">신청 : {{ row.gr_oper }} ~</small>
              </div>
            </router-link>
          </div>
        </div>

      </div>
      {{ pageMap.currentpage }}
      <div class="d-flex justify-content-center">
      <ul class="pagination" style="">

        <li class="page-item" v-if="pageMap.currentpage != 1">
          <span class="page-link" aria-label="Previous" @click="changegroup(1)">&laquo;</span>
        </li>
        <li v-else>
          <span>
            <span class="page-link" aria-label="Previous">&nbsp;</span>
          </span>
        </li>

        <li class="page-item" v-if="pageMap.currentpage != 1">
          <span class="page-link" aria-label="Previous" @click="changegroup(pageMap.currentpage - 1)">&lt;</span>
        </li>
        <li v-else>
          <span>
            <span class="page-link" aria-label="Previous">&nbsp;</span>
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
            <span class="page-link" aria-label="Previous">&nbsp;</span>
          </span>
        </li>


        <li class="page-item" v-if="pageMap.currentpage != pageMap.totalpage">
          <span class="page-link" @click="changegroup(pageMap.totalpage)" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </span>
        </li>
        <li v-else>
          <span>
            <span class="page-link" aria-label="Previous">&nbsp;</span>
          </span>
        </li>

      </ul>
    </div>



    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name:"groupList",
  data(){
    return{
      list:[],
      pageMap:[]
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
    }
  }
};
</script>

<style>
.container{
  width:1100px;
}
a{
  text-decoration-line: none;
}
a:link {
  color : black;
}
a:visited {
  color : black;
}
a:hover {
  color : black;
}
a:active {
  color : black;
}
</style>