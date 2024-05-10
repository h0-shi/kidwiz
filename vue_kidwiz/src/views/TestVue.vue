<template>
    <div>
        <h1>테스트에요!</h1>
        <h1>테스트에요!</h1>
        <h1>테스트에요!</h1>
        <button @click="logout">로그아웃</button>
    </div>
</template>

<script>
export default {
    name:'TestVue',
    methods: {
        logout() {
            // 로컬스토리지에서 토큰 제거
            localStorage.removeItem('jwt');
            localStorage.removeItem('name');
            // 로그인 페이지로 리다이렉트
            this.$router.push('/login');
        }
    }
}
</script>

<style>

</style>