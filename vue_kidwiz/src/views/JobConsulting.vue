<template>
  <div>
    카트 페이지
    <table>
      <thead>
        <tr>
          <th>아이템 id</th>
          <th>아이템 이름</th>
          <th>아이템 가격</th>
          <th>삭제</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in state.items" v-bind:key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.name }}</td>
            <td>{{ item.price }}</td>
            <td><button @click="remove(item.id)">삭제</button></td>
        </tr>
    </tbody>
    </table>
  </div>
</template>

<script>
import { reactive } from 'vue';
import axios from 'axios';

export default {
name: 'jobConsulting',
setup(){
  const state = reactive({
    items:[]
  })

  const load = () => {
  axios.get('http://localhost:3000/api/cart/items', { withCredentials: true })
  .then(response => {
    state.items = response.data;
    })
  };

  const remove = (itemId) => {
      axios.delete(`http://localhost:3000/api/cart/items/${itemId}`, { withCredentials: true })
      .then(() => {
        console.log('remove success');
        load(); // 데이터 삭제 후 다시 불러오기
      })
  };

  // 컴포넌트가 마운트될 때 초기 데이터를 불러옴
  load();

  return {state, remove}
}
}
</script>