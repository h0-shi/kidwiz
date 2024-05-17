<template>
  <div>
    <h1>마이페이지입니다</h1>
    <p>마이페이지 하위 메뉴</p>
    <p>1. 나의 정보 관리 -> 비밀번호 확인 -> 비밀번호 수정 등</p>
    <p>2. 나의 상담 내역 -> 상담 종류, 날짜, 상태(접수완료, 접수진행, 상담완료, 등), 상담취소, 상담변경</p> 
    <p>3. 비교과(집단상담)내역 -> 상담 종류, 날짜, 상태(접수완료, 접수진행, 상담완료, 등)</p> 
    <p>4. 나의 문의 내역</p>
    <p>5. 나의 리뷰</p>
    <p>현재 로그인한 사용자 id: {{ $store.state.account.id }}</p>
    <p>현재 로그인한 사용자 email: {{ $store.state.account.email }}</p>
    <p>현재 로그인한 사용자 name: {{ $store.state.account.name }}</p>
  </div>
</template>

<script>

</script>
