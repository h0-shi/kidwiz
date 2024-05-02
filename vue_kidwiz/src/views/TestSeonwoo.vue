<template>
  <div>
    <h1>hi</h1>
  </div>
</template>

<script>
import axios from 'axios';
let form = new FormData();
form.append('name', this.name);
export default {
    data(){},
    methods: {
        submitBtn(){
            axios.post('http://localhost:3000/testPost', JSON.stringify(form)).then(res => {
                console.log(res.data);
            });
        }
    }
}
</script>

<style>

</style>