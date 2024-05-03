<template>
  <table>
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
        </tr>
    </thead>
    <tbody>
        <tr v-for="n in list" v-bind:key="n.no">
            <td>{{ n.no }}</td>
            <td>{{ n.name }}</td>
        </tr>
    </tbody>
  </table>
</template>

<script>
import axios from 'axios'
export default {
    name: 'listTest',
    data(){
        return{
            list:[],
        }
    },
    mounted(){
        axios.get('http://localhost:3000/test').then((res) => {
            this.list = res.data.list
        }).catch((err) => {
            alert("문제 발생"+err)
        })
    }
}
</script>

<style>

</style>