<template>
    <div class="container">
        <my-sidebar></my-sidebar>
        <div class="mainContainer">
        <h2 class="title mb-4">정기상담 예약 조회</h2>
        <hr class="line">
        <table class="table">
            <thead>
                <tr class="tr">
                    <th scope="col">번호</th>
                    <th scope="col">학번</th>
                    <th scope="col">학과</th>
                    <th scope="col">이름</th>
                    <th scope="col">시작일</th>
                    <th scope="col">최근 상담 진행일</th>
                    <th scope="col">회차 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="n in list" v-bind:key="n.reg_no" v-bind:class="[n.reg_no+'tr']" @click="modalOpen(n.reg_no,n.stuNum)">
                    <td scope="row">{{n.reg_no }}</td>
                    <td>{{ n.stuNum }}</td>
                    <td>{{n.major_name}}</td>
                    <td>{{ n.name }}</td>
                    <td>{{ n.first }}</td>
                    <td>{{ n.last }}</td>
                    <td>{{ n.currentTimes }} / 10 회기</td>
                </tr>
            </tbody>
        </table>
    
        <!-- 모달 -->
        <div class="modal-wrap" v-show="modalCheck">
            <div class="modal-container">
                <h3 class="dh"><span class="emp">{{stuName}}</span>의 정기상담</h3>                
                <table class="table stu" v-if="responseData && responseData.length > 0">
                    <thead>
                        <tr>
                            <th>회차</th>
                            <th scope="col">학번</th>
                            <th scope="col">날짜</th>
                            <th scope="col">시간</th>                            
                            <th>일지 작성 여부</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="row in responseData" :key="row.rd_no"> 
                            <td>{{row.times}}회기</td>
                            <td>{{ row.stuNum }}</td>
                            <td>{{ row.date }}</td>                            
                            <td>{{row.time}}</td>
                            <td v-if="row.writed === 0">
                                <button class="save" @click="regWrite(row)">일지 작성</button>
                            </td>
                            <td v-if="row.writed === 1">
                                <button class="done" @click="regDetail(row)">일지 보기</button>
                            </td>
                        </tr>
                    </tbody>
                </table>                
                <div class="modal-btn">
                    <button @click="btnPopup(rd_no, stuNum)" class="newCoun" v-if="count<10">새 상담 추가하기</button>
                    <button @click="modalOpen" class="modalClose">닫기</button>
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
          <ul class="pagination" style="">
    
            <li class="page-item" v-if="pageMap.currentpage != 1">
              <span class="page-link" aria-label="Previous" @click="changegroup(1)">&laquo;</span>
            </li>
            <li  class="page-item" v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&nbsp;</span>
              </span>
            </li>
    
            <li class="page-item" v-if="pageMap.currentpage != 1">
              <span class="page-link" aria-label="Previous" @click="changegroup(pageMap.currentpage - 1)">&lt;</span>
            </li>
            <li v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&nbsp;</span>
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
                <span class="page-link disabled" aria-label="Previous">&nbsp;</span>
              </span>
            </li>
    
    
            <li class="page-item" v-if="pageMap.currentpage != pageMap.totalpage">
              <span class="page-link" @click="changegroup(pageMap.totalpage)" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </span>
            </li>
            <li v-else>
              <span>
                <span class="page-link disabled" aria-label="Previous">&nbsp;</span>
              </span>
            </li>
    
          </ul>
        </div>
    </div>
    </div>
    </template>
    
    <script>
    import MySidebar from '@/components/MySidebar.vue';
    import axios from 'axios'

    export default {
        components: {
            MySidebar,
        },  
        data(){
            return{
                list:[],
                modalCheck: false,
                regno:'',
                stuNum:'',
                totalCount:'',
                pageMap: [],
                writed:'',
                major_name: '',
                name:'',
                stuName:'',
                first:'',
                lsat:'',
                currentTimes:'',
                popupWindow : null,
                count:'',
            }
        },
        mounted(){
           this.accessCheck();
           this.getTotalCount();            
        },
        methods:{
            async accessCheck(){
                await axios.get('http://localhost:3000/regAcess',{ withCredentials: true }).then((res)=> {                
                if(res.data < 1){
                    alert("접근할 수 없습니다.");
                    this.$router.push("/");
                }
            }).catch((err) => {
                alert(err+"에러 발생");
                this.$router.push("/");
            })
            },
            async getTotalCount(){
                axios.get('http://localhost:3000/regTotalCount').then((res) => {  
                this.totalCount = res.data;                
                axios.get('http://localhost:3000/regRev?total='+this.totalCount).then((res) => {
                    console.log(res.data);
                this.list = res.data.list;
                this.pageMap = res.data.pageMap;                
                })
            })
            },
            al(item,stat){
                var arrJson = {'reg_no':item.reg_no, 'stat':stat};            
                axios.post('http://localhost:3000/accept',arrJson).then((res)=>{
                    console.log(res);
                    item.stat='1'
                }).catch((err) =>{
                    console.log(err);
                })
            },
            changegroup(page){
            axios.get("http://localhost:3000/regRev?total="+this.totalCount+"&page="+page).then((res)=>{
                this.list=res.data.list
                this.pageMap=res.data.pageMap
            }).catch((err)=>{
                alert(err)
            })
            },
            regDetail(reg){
                console.log(reg);
                this.$router.push('/regResult?regno='+reg.rd_no);
            },
            regWrite(reg){
                this.$router.push('/resultWrite?regno='+reg.rd_no);
            },
            async modalOpen(reg_no, stuNum){                
                if(this.modalCheck == false){
                    await this.getData(reg_no)
                }
                this.modalCheck = !this.modalCheck;
                this.rd_no = reg_no;
                this.stuNum = stuNum;
                console.log(this.rd_no);
            },
            btnPopup(rd_no,stuNum){
                if(this.popupWindow && !this.popupWindow.closed){
                    this.popupWindow.close();
                }
                this.popupWindow = window.open("#/regTime?stuNum="+stuNum+"&regno="+rd_no,"popup","width=1200,height=660");
            },
            async getData(reg_no){
                try{
                    const response = await axios.get('http://localhost:3000/regDetail?rgno='+reg_no);
                    this.responseData = response.data;
                    this.stuName = response.data[0].name;
                    const length = response.data.length-1;
                    this.count = response.data[length].times;
                    console.log(this.responseData);
                } catch(error) {
                    console.log('에러 발생: '+error )
                }
            }
        },
    }
    </script>
    
<style scoped>
    .modal-wrap{
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        background: rgba(0,0,0,0.4);
        z-index: 99;
    }
    table thead :hover{
        background-color: inherit !important;        
    }
    table{
        text-align: center;
    }
    .emp{
        color: #67BF4E;
    }
    .newCoun{        
        width: 20%;
        height: 35px;
        margin: 15px 10px;
        color: white;
        background-color: #67BF4E;
        border: none;
        font-family: 'sjl';
    }
    .modalClose{
        width: 20%;
        height: 35px;
        margin: 15px 10px;
        color: white;
        background-color: rgb(255, 101, 101);
        border: none;
        font-family: 'sjl'; 
    }
    .modal-container{
        position: relative;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 800px;
        background: #fff;
        border-radius: 10px;
        padding: 20px;
        box-sizing: border-box;
    }
    .dh{
        font-family: 'dh';
    }
    .done{
        color : black;
        background-color: white;
        border: 1px solid #c0c0c0;
    }
    .line{
        width: 40%;  
    }
    .title{
        text-align: left;
        font-family: 'sj';
    }
    .mainContainer{
        width: 100%;
        max-width: 1200px;
        margin: 0 auto;
    }
    .tr{
        font-family: 'sjl';
    }
</style>