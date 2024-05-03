<template>
    <div>
    <h1>test now</h1>
    <form @submit.prevent="postTest" id="test">
        <input type="text" name="name" v-model="test.name">
        <input type="text" name="age" v-model="test.age">
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
                age: ''
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

</style>