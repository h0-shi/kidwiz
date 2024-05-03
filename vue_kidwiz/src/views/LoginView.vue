<template>
    <div class="login">
      <h1>로그인 페이지 입니다</h1>
      <form id = "LoginForm">
        <div class="LoginFormClass">
          <label for="userId">아이디 : </label>
          <input type="text" id="userId" name="userId" required>
        </div>
        <div class="LoginFormClass">
          <label for="password">비밀번호 : </label>
          <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">로그인</button>
      </form>
    </div>
</template>

<script>
export default {
    name:'LoginVue'
}
</script>
