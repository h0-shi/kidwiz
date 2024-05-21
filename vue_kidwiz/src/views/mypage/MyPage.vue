<!-- <template>
  <div>
    <div class="content">
      <main class="main-content">
        <h2>비밀번호 수정</h2>
        <p class="note">변경된 개인 정보를 정확히 입력해주시기 바랍니다</p>
        <p class="note">이름 및 휴대폰 번호가 변경된 경우는 상담센터에 문의해주세요</p>
        <form class="info-form">
          <div class="form-group">
            <label for="name">이름*</label>
            <span class="text-value">{{ $store.state.account.name }}</span>
          </div>
          <hr class="line"/>
          <div class="form-group">
            <label for="id">아이디(학번)*</label>
            <span class="text-value">{{ $store.state.account.id }}</span>
          </div>
          <hr class="line"/>
          <div class="form-group">
            <label for="phone">휴대폰 번호*</label>
            <span class="text-value">{{ $store.state.account.email }}</span>
          </div>
          <hr class="line"/>
          <div class="form-group">
            <label for="password">새 비밀번호*</label>
            <input type="password" @keyup.enter="changePassword" v-model="form.newPassword" placeholder="새 비밀번호" />
          </div>
          <div class="form-group">
            <label for="confirm-password">비밀번호 확인*</label>
            <input type="password" @keyup.enter="changePassword" v-model="form.newPasswordCheck" placeholder="새 비밀번호 확인" />
          </div>
          <button type="button" class="btn btn-change" @click="changePassword">변경</button>
        </form>
      </main>
    </div>
  </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import MyPageSecMenu from '@/views/mypage/MyPageSecMenu.vue';
import axios from "axios";
import router from '@/router';

export default {

  data() {
    return {
      form: {
        newPassword: "",
        newPasswordCheck: ""
      }
    };
  },
  methods: {
    changePassword() {
      if (this.form.newPassword !== this.form.newPasswordCheck) {
        window.alert("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
      }
      axios.post('http://localhost:3000/api/account/changepassword', this.form, { withCredentials: true })
        .then(() => {
          window.alert("비밀번호가 변경되었습니다.");
          router.push({ path: "/login" });
        })
        .catch(() => {
          window.alert("비밀번호 변경에 실패했습니다. 현재 비밀번호를 확인해주세요.");
        });
    }
  }
};
</script>

<style scoped>
.content {
  padding: 20px;
}
.main-content {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 8px;
  max-width: 1000px; /* 페이지 양쪽 맞춤을 위해 너비 제한 */
  margin: 0 auto; /* 가운데 정렬 */
}
.note {
  margin-bottom: 10px;
  font-size: 14px;
  color: #666;
}
.info-form {
  margin-top: 20px;
}
.form-group {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
}
.form-group label {
  flex: 1;
  font-weight: bold;
  text-align: left; /* 글씨 왼쪽 정렬 */
}
.form-group .text-value {
  flex: 2;
  padding: 8px;
  text-align: left; /* 글씨 왼쪽 정렬 */
}
.form-group input {
  flex: 2; /* 레이블과 동일한 너비 비율 적용 */
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.line {
  border: none;
  border-top: 1px solid #ccc;
  margin: 15px 0;
}
.btn {
  display: inline-block;
  padding: 10px 20px;
  color: #fff;
  background-color: #333;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}
.btn.btn-change {
  background-color: #555;
}
</style> -->


<template>
  <div>
    <br />
    <div class="sbmContainer boundary">
      <table class="subMenu">
        <tr>
          <th :style="select[0]" @click="navigate(0)">나의 정보 관리</th>
          <th :style="select[1]" @click="navigate(1)">나의 상담 내역</th>
          <th :style="select[2]" @click="navigate(2)">나의 심리 검사</th>
          <th :style="select[3]" @click="navigate(3)">나의 문의 내역</th>
        </tr>
      </table>
    </div>
    <section class="section s1" :style="cssAct[0]"></section>
    <section class="section s2" :style="cssAct[1]"></section>
    <section class="section s3" :style="cssAct[2]"></section>
    <section class="section s4" :style="cssAct[3]"></section>

    <!-- 여기서부터 본문 -->
    <div>
      <div class="content">
        <main class="main-content">
          <h2>비밀번호 수정</h2>
          <p class="note">변경된 개인 정보를 정확히 입력해주시기 바랍니다</p>
          <p class="note">
            이름 및 휴대폰 번호가 변경된 경우는 상담센터에 문의해주세요
          </p>
          <form class="info-form">
            <div class="form-group">
              <label for="name">이름*</label>
              <span class="text-value">{{ $store.state.account.name }}</span>
            </div>
            <hr class="line" />
            <div class="form-group">
              <label for="id">아이디(학번)*</label>
              <span class="text-value">{{ $store.state.account.id }}</span>
            </div>
            <hr class="line" />
            <div class="form-group">
              <label for="phone">휴대폰 번호*</label>
              <span class="text-value">{{ $store.state.account.email }}</span>
            </div>
            <hr class="line" />
            <div class="form-group">
              <label for="password">새 비밀번호*</label>
              <input
                type="password"
                @keyup.enter="changePassword"
                v-model="form.newPassword"
                placeholder="새 비밀번호"
              />
            </div>
            <div class="form-group">
              <label for="confirm-password">비밀번호 확인*</label>
              <input
                type="password"
                @keyup.enter="changePassword"
                v-model="form.newPasswordCheck"
                placeholder="새 비밀번호 확인"
              />
            </div>
            <button
              type="button"
              class="btn btn-change"
              @click="changePassword"
            >
              변경
            </button>
          </form>
        </main>
      </div>
    </div>
  </div>
</template>
  
<script>
import axios from "axios";
import router from "@/router";

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
      form: {
        newPassword: "",
        newPasswordCheck: "",
      },
    };
  },
  mounted() {
    this.cssAct[0] = { display: "block" };
    this.select[0] = {
      // 여기로 아예 이동하게 만드는거야
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
        "/mypage", // 나의 정보 관리
        "/myconsultations", // 나의 상담 내역
        "/mysimrireserve", // 나의 심리 검사
        "/myqna", // 나의 문의 내역
      ];

      this.$router.push(routes[num]); // Vue 라우터를 사용하여 URL 변경
    },

    changePassword() {
      if (this.form.newPassword !== this.form.newPasswordCheck) {
        window.alert("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
      }
      axios
        .post("http://localhost:3000/api/account/changepassword", this.form, {
          withCredentials: true,
        })
        .then(() => {
          window.alert("비밀번호가 변경되었습니다.");
          router.push({ path: "/login" });
        })
        .catch(() => {
          window.alert(
            "비밀번호 변경에 실패했습니다. 현재 비밀번호를 확인해주세요."
          );
        });
    },
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
.content {
  padding: 20px;
}
.main-content {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 8px;
  max-width: 1000px; /* 페이지 양쪽 맞춤을 위해 너비 제한 */
  margin: 0 auto; /* 가운데 정렬 */
}
.note {
  margin-bottom: 10px;
  font-size: 14px;
  color: #666;
}
.info-form {
  margin-top: 20px;
}
.form-group {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
}
.form-group label {
  flex: 1;
  font-weight: bold;
  text-align: left; /* 글씨 왼쪽 정렬 */
}
.form-group .text-value {
  flex: 2;
  padding: 8px;
  text-align: left; /* 글씨 왼쪽 정렬 */
}
.form-group input {
  flex: 2; /* 레이블과 동일한 너비 비율 적용 */
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.line {
  border: none;
  border-top: 1px solid #ccc;
  margin: 15px 0;
}
.btn {
  display: inline-block;
  padding: 10px 20px;
  color: #fff;
  background-color: #333;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}
.btn.btn-change {
  background-color: #555;
}
</style>