<template>
    <div>
        <h1>test now</h1>
        <form @submit.prevent="postTest" id="test">
            <label>학번</label>
            <input type="file"  ref="image" accept="image/*" id="card1" @change="cardSet">
            <input type="file"  ref="image" accept="image/*" id="card2" @change="cardSet">
            <input type="file"  ref="image" accept="image/*" id="card3" @change="cardSet">
            <input type="file"  ref="image" accept="image/*" id="card4" @change="cardSet">            
            <input type="file"  ref="image" accept="image/*" id="card5" @change="cardSet">            
            <input type="file"  ref="image" accept="image/*" id="card6" @change="cardSet">            
            <br>
            <button>submit</button>
        </form>
    </div>
    </template>
    
    <script>
    import axios from 'axios';
    export default {
        data() {
            return {
                cards: [],
            }
        },
        methods: {
            cardSet(event){
                this.cards = Array.from(event.target.files);
                console.log(this.cards);
            }
            ,postTest(){
                console.log("실행");
                var frm = new FormData();
                var photo1 = document.getElementById("card1");
                var photo2 = document.getElementById("card2");
                var photo3 = document.getElementById("card3");
                var photo4 = document.getElementById("card4");
                var photo5 = document.getElementById("card5");
                var photo6 = document.getElementById("card6");                
                console.log(photo1.files[0])
                frm.append('c1',photo1.files[0]);            
                frm.append('c1',photo2.files[0]);
                frm.append('c1',photo3.files[0]);
                frm.append('c1',photo4.files[0]);
                frm.append('c1',photo5.files[0]);
                frm.append('c1',photo6.files[0]);
                console.log(frm);
                axios.post('http://localhost:3000/cardWrite',frm, {
                    headers : {
                        'Content-Type': 'multipart/form-data'
                    }
                }).then((res) => {
                    console.log(res);
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