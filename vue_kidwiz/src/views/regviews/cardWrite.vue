<template>
    <div class="boundary">
        <h1 class="title">상담 카드뉴스</h1>        
        <hr class="line">
        <div class="boundary">
        <form @submit.prevent="postTest" id="test">
            <div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">제목</span>
                    <input type="text" class="form-control" placeholder="제목을 작성하세요" aria-label="Username" aria-describedby="basic-addon1" v-model="info.cn_title">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">설명</span>
                    <input type="text" class="form-control" placeholder="설명을 작성하세요" aria-label="Username" aria-describedby="basic-addon1" v-model="info.cn_exp">
                </div>
            </div>
            <div class="inputs">
            <div class="input-group">
                <label class="input-group-text" for="inputGroupFile01">파일 1</label>            
                <input type="file" class="form-control" ref="image" accept="image/*" id="card1" @change="cardSet">
            </div>

            <div class="input-group">
                <label class="input-group-text" for="inputGroupFile01">파일 2</label>            
                <input type="file" class="form-control" ref="image" accept="image/*" id="card2" @change="cardSet">
            </div>

            <div class="input-group">
                <label class="input-group-text" for="inputGroupFile01">파일 3</label>            
                <input type="file" class="form-control" ref="image" accept="image/*" id="card3" @change="cardSet">
            </div>

            <div class="input-group">
                <label class="input-group-text" for="inputGroupFile01">파일 4</label>            
                <input type="file" class="form-control" ref="image" accept="image/*" id="card4" @change="cardSet">
            </div>

            <div class="input-group">
                <label class="input-group-text" for="inputGroupFile01">파일 5</label>            
                <input type="file" class="form-control" ref="image" accept="image/*" id="card5" @change="cardSet">
            </div>

            <div class="input-group">
                <label class="input-group-text" for="inputGroupFile01">파일 6</label>            
                <input type="file" class="form-control" ref="image" accept="image/*" id="card6" @change="cardSet">
            </div>
        </div>
                        
            <br>
            <button>submit</button>
        </form>
        </div>
    </div>
    </template>
    
    <script>
    import axios from 'axios';
    export default {
        data() {
            return {
                cards: [],
                info : {
                    cn_title:'',
                    cn_exp:'',
                }
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
                frm.append('info', new Blob([JSON.stringify(this.info)], {type:'application/json'}));
                console.log(frm);
                axios.post('http://localhost:3000/cardWrite',frm, {
                    headers : {
                        'Content-Type': 'multipart/form-data'
                    }
                }).then((res) => {
                    console.log(res);
                    this.$router.push("/cardNews");
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
    .inputs div{
        margin: 10px 0;
    }
    .mainContainer h1{
    font-family: 'dh';
    text-align: left; /* 왼쪽 정렬 */
    }
    .line{
        margin: 35px 0;

    }
    </style>