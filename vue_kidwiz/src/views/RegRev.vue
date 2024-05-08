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
            <tr v-for="n in list" v-bind:key="n.reg_no" v-bind:class="[n.reg_no+'tr']" @click="modalOpen(n)">
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
    
    <div class="modal-wrap" v-show="modalCheck">
        <div class="modal-container">
            <button>신청하기</button>
            <table class="table stu">
                <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">학번</th>
                        <th scope="col">상태</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <th>60221322</th>
                        <th>가다라</th>
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
            console.log('-------');
            console.log(arrJson);
            axios.post('http://localhost:3000/accept',arrJson).then((res)=>{
                console.log(res);
                item.stat='1'
            }).catch((err) =>{
                console.log(err);
            })
        },
        changeBackgroundColor(item) {
        // 배경색 변경을 위한 로직을 여기에 추가
        console.log(item.reg_no);
        item.backgroundColor = 'yellow'; // 예시로 노란색 배경색을 설정
        },
        modalOpen(){
            this.modalCheck = !this.modalCheck;
            console.log("실행");
        }
    }
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