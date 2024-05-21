<template>
  <div>
    <br />
    <div class="sbmContainer boundary">
      <table class="subMenu">
        <tr>
          <th :style="select[0]" @click="navigate(0)">상담 안내</th>
          <th :style="select[1]" @click="navigate(1)">직업 심리 검사</th>
          <th :style="select[2]" @click="navigate(2)">채용 정보</th>
          <th :style="select[3]" @click="navigate(3)">상담 신청</th>
        </tr>
      </table>
    </div>
    <section class="section s1" :style="cssAct[0]"></section>
    <section class="section s2" :style="cssAct[1]"></section>
    <section class="section s3" :style="cssAct[2]"></section>
    <section class="section s4" :style="cssAct[3]"></section>
    <div>
      <h1>상담 안내</h1>
    </div>
  </div>
</template>
  
  <script>
export default {
  data() {
    return {
      act: "none",
      cssAct: [
        { display: "none" },
        { display: "none" },
        { display: "none" },
        { display: "none" },
      ],
      select: [{}, {}, {}, {}],
    };
  },
  mounted() {
    this.cssAct[0] = { display: "block" };
    this.select[0] = {  // 여기로 아예 이동하게 만드는거야
      border: "2px solid rgb(43, 43, 165",
      "border-bottom": "none",
    };
  },
  methods: {
    displayAct(num) {
      this.cssAct = this.cssAct.map((style, i) => {
        if (i == num) {
          return { display: "block" };
        }
        return { display: "none" };
      });
      this.select = this.select.map((style, i) => {
        if (i == num) {
          return {
            border: "2px solid rgb(43, 43, 165",
            "border-bottom": "none",
          };
        }
        return {};
      });
    },
    navigate(num) {
      this.displayAct(num); // displayAct 메서드 호출

      const routes = [
          '/jobs/intro', // 상담 안내
          '/jobs/test', // 직업 심리 검사
          '/jobs/list', // 채용 정보
          '/jobs/apply' // 상담 신청
      ];

      this.$router.push(routes[num]); // Vue 라우터를 사용하여 URL 변경
    }
  },
};
</script>
  
  <style>
.sbmContainer {
  width: 100%;
  margin-bottom: 50px;
}
.subMenu {
  width: 100%;
  margin: auto;
}
.subMenu tr th {
  width: 25%;
  height: 55px;
  border-bottom: 2px solid rgb(43, 43, 165);
}
.boundary {
  width: 100%;
  max-width: 1200px;
  padding: 0 auto;
}
</style>