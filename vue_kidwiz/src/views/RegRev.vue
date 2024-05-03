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
        <tr v-for="n in list" v-bind:key="n.no" v-bind:class="[n.no+'tr']">
            <td>{{n.no }}</td>
            <td>{{n.name }}</td>
            <td>{{ n.stuNum }}</td>
            <td>{{ n.major }}</td>
            <td>{{ n.teacher }}</td>
            
            <td v-if=" n.stat === '0'" v-bind:class="[n.no+'stat']" >
                <button @click="al(n, 1)">승인</button>
                <button>거절</button>
            </td>
            
            <td v-if=" n.stat === '1' " v-bind:class="[n.no+'stat']">승인완료</td>
            
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
        al(item,stat){
            var arrJson = {'no':item.no, 'stat':stat};
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
        console.log(item.no);
        item.backgroundColor = 'yellow'; // 예시로 노란색 배경색을 설정
    }

    }
}
</script>

<style>

</style>