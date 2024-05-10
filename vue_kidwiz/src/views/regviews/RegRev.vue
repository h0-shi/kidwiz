<template>
<div class="container">
    <h1>정기상담 예약 조회</h1>
    <table class="table regRev">
        <thead>
            <tr>
                <th scope="col">번호</th>
                <th scope="col">학번</th>
                <th scope="col">상태</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="n in list" v-bind:key="n.reg_no" v-bind:class="[n.reg_no+'tr']" @click="modalOpen(n.reg_no,n.stuNum)">
                <td scope="row">{{n.reg_no }}</td>
                <td>{{ n.stuNum }}</td>
                <td v-if=" n.stat === '0'" v-bind:class="[n.reg_no+'stat']" >
                    <button @click="al(n, 1)" >승인</button>
                    <button>거절</button>
                </td>
                <td v-if=" n.stat === '1' " v-bind:class="[n.no+'stat']">승인완료</td>
                <td>
                    <button @click="modalOpen">자세히보기</button>
                </td>
            </tr>
        </tbody>
    </table>

    <!-- 모달 -->
    <div class="modal-wrap" v-show="modalCheck">
        <div class="modal-container">
            <h5>{{regno}} / {{stuNum}}</h5>
            <button @click="btnPopup(regno, stuNum)">신청하기</button>
            <table class="table stu" v-if="responseData && responseData.length > 0">
                <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">학번</th>
                        <th scope="col">날짜</th>
                        <th scope="col">시간</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="row in responseData" :key="row.regno">
                        <td scope="row">{{ row.rownum }}</td>
                        <td>{{ row.stuNum }}</td>
                        <td>{{ row.DATE }}</td>
                        <td>{{ row.TIME }}</td>
                    </tr>
                </tbody>
            </table>
            <div class="modal-btn">
                <button @click="modalOpen">닫기</button>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            list:[],
            modalCheck: false,
            regno:'',
            stuNum:'',
        }
    },
    mounted(){
        axios.get('http://localhost:3000/test').then((res) => {
            this.list = res.data.list
        })
    },
    methods:{
        al(item,stat){
            var arrJson = {'reg_no':item.reg_no, 'stat':stat};            
            axios.post('http://localhost:3000/accept',arrJson).then((res)=>{
                console.log(res);
                item.stat='1'
            }).catch((err) =>{
                console.log(err);
            })
        },
        async modalOpen(reg_no, stuNum){
            console.log(this.modalCheck==false)
            if(this.modalCheck == false){
                await this.getData(reg_no)
            }
            this.modalCheck = !this.modalCheck;
            this.regno = reg_no;
            this.stuNum = stuNum;
            console.log(this.regno);
        },
        btnPopup(regno,stuNum){
            window.open("#/regTime?stuNum="+stuNum+"&regno="+regno,"_blank","width=950,height=500");
        },
        async getData(reg_no){
            try{
                const response = await axios.get('http://localhost:3000/regDetail?rgno='+reg_no);
                this.responseData = response.data;
                console.log(this.responseData);
            } catch(error) {
                console.log('에러 발생: '+error )
            }
        }
    },
}
</script>

<style>
.modal-wrap{
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.4);
}

.modal-container{
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 550px;
    background: #fff;
    border-radius: 10px;
    padding: 20px;
    box-sizing: border-box;
}
</style>