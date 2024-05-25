<template>
    <div>
        <div class="adviser_intro container mt-5">
            <div class="txt_box p-4 mb-4 bg-light rounded shadow-sm">
                <p>지도교수로 하여금 지도학생이 입학부터 졸업 및 취업에 이르기까지 역량을 계발할 수 있도록 상담과 지도를 하는 지도교수제를 시행하고 있습니다.</p>
            </div>

            <div class="content">
                <h3 class="dot_tit text-left">지도교수 상담</h3>

                <div class="cnts_wrap mb-4 p-3 border rounded">
                    <strong class="cnts_tit d-block mb-2 text-left">지도교수 배정</strong>
                    <p class="text-left">·학과(부)장 · 전공주임교수는 소속 학과(부)·전공 교수의 협의를 거쳐 지도교수에게 지도학생을 배정합니다.</p>
                    <p class="text-left">·지도교수는 일반교원이 담당함을 원칙으로 하되, 대학원 소속의 일반교원이 참여할 수 있습니다.</p>
                </div>

                <div class="cnts_wrap mb-4 p-3 border rounded">
                    <strong class="cnts_tit d-block mb-2 text-left">지도교수 상담 및 관리</strong>
                    <p class="text-left">·지도교수는 학기 단위로 지도학생 상담을 실시합니다.</p>
                    <p class="text-left">·학생상담은 개인별 대면상담을 원칙으로 하고, 온라인상담, 유선상담, 단체상담 등을 실시할 수 있습니다.</p>
                    <p class="text-left">·학생과의 상담내용을 포함한 개인정보가 노출되지 않도록 보호하여 주십시오.</p>
                    <p class="text-left">·상담결과를 교육인증 및 학생역량 통합관리시스템에 입력하고, 개인별로 누적된 상담자료를 활용하여 상담하여 주십시오.</p>
                </div>

                <div class="cnts_wrap p-3 border rounded">
                    <strong class="cnts_tit d-block mb-2 text-left">
                        지도교수 상담 영역
                        <button type="button" class="btn btn-link p-0 ml-2" data-action="guide">
                            <i class="fa fa-search"></i>
                        </button>
                    </strong>
                    <ul class="list-unstyled mb-0 text-left">
                        <li>생활</li>
                        <li>학업</li>
                        <li>진로, 취업</li>
                        <li>학사경고자</li>
                        <li>장기결석</li>
                        <li>위기학생 상담</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Professorcinfo'
}
</script>

<style scoped>
.adviser_intro .txt_box {
    background-color: #f8f9fa;
}
.adviser_intro .cnts_wrap {
    background-color: #ffffff;
}
.adviser_intro .cnts_tit {
    font-weight: bold;
}
.adviser_intro .content h3 {
    margin-bottom: 20px;
}
.adviser_intro ul {
    padding-left: 20px;
}
</style>
