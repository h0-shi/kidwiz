<template>
<div>
    <h1>test now</h1>
    <form @submit.prevent="postTest" id="test">
        <label>이름</label><input type="text" name="name" v-model="test.name">
        <label>나이</label><input type="text" name="age" v-model="test.age"><br>
        <label>학번</label><input type="text" name="stuNum" v-model="test.stuNum">
        <label>전공</label><input type="text" name="major" v-model="test.major"><br>
        <label>교수</label><input type="text" name="tName" v-model="test.teacher"><br>
        <br>
        <button>submit</button>
    </form>
</div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            test: {
                name: '',
                age: '',
                major:'',
                teacher:'',
                stuNum:''
            }
        }
    },
    methods: {
        postTest(){
            console.log("실행");
            //var form = document.getElementById('test');           
            //var json = JSON.stringify(form)
            console.log(this.test)
            
        axios.post('http://localhost:3000/testPost', this.test).then((res) => {
            console.log(res)
            })
        }
    }
}
</script>

<style>
.reason{
    width: 70%;
    height: 300px;
}
</style>