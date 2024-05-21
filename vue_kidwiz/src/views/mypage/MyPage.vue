<template>
  <div>
    <MenuPage />
    <MyPageSecMenu />
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
            <label for="password">비밀번호*</label>
            <input type="password" id="password" placeholder="새 비밀번호" />
          </div>
          <div class="form-group">
            <label for="confirm-password">비밀번호 확인*</label>
            <input type="password" id="confirm-password" placeholder="새 비밀번호 확인" />
          </div>
          <button type="button" class="btn btn-change">변경</button>
        </form>
      </main>
    </div>
  </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import MyPageSecMenu from '@/views/mypage/MyPageSecMenu.vue';

export default {
  name: 'MyPage',
  components: {
    MenuPage,
    MyPageSecMenu
  }
}
</script>

<style scoped>
.content {
  padding: 20px;
}
.main-content {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 8px;
  max-width: 1200px; /* 페이지 양쪽 맞춤을 위해 너비 제한 */
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
}
.form-group .text-value {
  flex: 2;
  padding: 8px;
}
.form-group input {
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
