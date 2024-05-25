<template>
    <div>
      <MenuPage />
      <div class="boundary">
      <h1 class="title">지두교수 상담 개요</h1>
      <SimriSecMenu />
      <div class="container py-5">
        <!-- 수정된 이미지 경로 -->
        <div class="adviser_intro">
	<div class="txt_box">
		<p>지도교수로 하여금 지도학생이 입학부터 졸업 및 취업에 이르기까지 역량을 계발할 수 있도록 상담과 지도를 하는 지도교수제를 시행하고 있습니다.</p>
	</div>

	<div class="content">
		<h3 class="dot_tit">지도교수 상담</h3>

		<div class="cnts_wrap">
			<strong class="cnts_tit">지도교수 배정</strong>
			<p>학과(부)장 · 전공주임교수는 소속 학과(부)•전공 교수의 협의를 거쳐 지도교수에게 지도학생을 배정합니다.</p>
			<p>지도교수는 일반교원이 담당함을 원칙으로 하되, 대학원 소속의 일반교원이 참여할 수 있습니다.</p>
		</div>

		<div class="cnts_wrap">
			<strong class="cnts_tit">지도교수 상담 및 관리</strong>
			<p>지도교수는 학기 단위로 지도학생 상담을 실시합니다.</p>
			<p>학생상담은 개인별 대면상담을 원칙으로 하고, 온라인상담, 유선상담, 단체상담 등을 실시할 수 있습니다.</p>
			<p>학생과의 상담내용을 포함한 개인정보가 노출되지 않도록 보호하여 주십시오.</p>
			<p>상담결과를 교육인증 및 학생역량 통합관리시스템에 입력하고, 개인별로 누적된 상담자료를 활용하여 상담하여 주십시오.</p>
		</div>

		<div class="cnts_wrap">
			<strong class="cnts_tit">지도교수 상담 영역<button type="button" data-action="guide"><i class="fa fa-search"></i></button></strong>
			<p>생활</p>
			<p>학업</p>
			<p>진로, 취업</p>
			<p>학사경고자</p>
			<p>장기결석</p>
			<p>위기학생 상담</p>
		</div>

	</div>
</div>
      </div>
    </div>
    </div>
  </template>
  
  <script>
  import MenuPage from '@/components/MenuPage.vue';
  import SimriSecMenu from '@/views/counselingFolder/SimriSecMenu.vue';
  
  export default {
    name: 'CounselingInfo',
    components: {
      MenuPage,
      SimriSecMenu
    }
  };
  </script>
  