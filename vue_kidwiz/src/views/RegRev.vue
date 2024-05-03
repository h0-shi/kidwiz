<template>
  <div class="container">
    <h1>정기상담 예약 조회</h1>
    <table class="regRev" border="1">
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>학번</th>
            <th>전공</th>
            <th>교수</th>
            <th>상태</th>
        </tr>
        <tr v-for="n in list" v-bind:key="n.no">
            <td>{{n.no }}</td>
            <td>{{n.name }}</td>
            <td>{{ n.stuNum }}</td>
            <td>{{ n.major }}</td>
            <td>{{ n.teacher }}</td>
            <td v-if=" n.stat === '0' ">
                <button @click="al(n.no,1)">승인</button>
                <button>거절</button>
            </td>
            <td v-if=" n.stat === '1' ">승인완료</td>
        </tr>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            list:[]
        }
    },
    mounted(){
        axios.get('http://localhost:3000/test').then((res) => {
            this.list = res.data.list
        })
    },
    methods:{
        al(no,stat){
            var arrJson = {'no':no, 'stat':stat};
            console.log('-------');
            console.log(arrJson);
            axios.post('http://localhost:3000/accept',arrJson).then((res)=>{
                console.log(res);
            }).catch((err) =>{
                console.log(err);
            })
        }
    }
}
</script>

<style>

</style>