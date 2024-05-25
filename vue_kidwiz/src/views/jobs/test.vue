<template>
  <div>
    <MenuPage />
    <div class="boundary">
    <h1 class="title">취업 상담</h1>
    <jobSecMenu />

    <div class="info-section mt-3">
        <p>
          진로상담 및 직업심리검사는 개인의 능력과 흥미, 성격 등의 심리적인 특성들이 각 직업에서 요구하는 능력수준 및 특성에 얼마나 적합한지를 과학적인 방법으로 측정하여 성공가능성이 높고 만족할 만한 직업들을 탐색하도록 도와드립니다.
        </p>
    </div>

  </div>
  </div>
</template>

<!-- <template>
  <div>
    <MenuPage />
    <div class="boundary">
      <h1 class="title">취업 상담</h1>
      <jobSecMenu />

      <div class="info-section">
        <p>
          진로상담 및 직업심리검사는 개인의 능력과 흥미, 성격 등의 심리적인 특성들이 각 직업에서 요구하는 능력수준 및 특성에 얼마나 적합한지를 과학적인 방법으로 측정하여 성공가능성이 높고 만족할 만한 직업들을 탐색하도록 도와드립니다.
        </p>

        <h2 class="section-title">직업심리검사 종류</h2>

        <div class="exam-list">
          <div class="exam-item">
            <h3 class="exam-title">대학생 진로준비도 검사</h3>
            <p class="exam-description">
              대학생 진로준비도 검사는 대학생의 진로발달과 성취와 관련하여 현재 자신의 진로발달수준과 취업준비행동수준에 대한 객관적인 정보를 제공함으로써 보다 효과적인 진로 선택과 결정을 지원하기 위한 검사입니다.
            </p>
            <button class="btn btn-primary">바로가기</button>
          </div>
          <div class="exam-item">
            <h3 class="exam-title">직업선호도검사 L형</h3>
            <p class="exam-description">
              직업선호도검사 L형은 대학생 및 성인구직자들이 자신의 흥미, 성격, 생활경험과 같은 심리적 특성을 이해할 수 있도록 하고, 검사결과를 종합적으로 해석하여 진로선택 및 직업선택과 같은 직업심사결정을 하는데 도움을 제공하기 위한 검사입니다.
            </p>
            <button class="btn btn-primary">바로가기</button>
          </div>
          <div class="exam-item">
            <h3 class="exam-title">직업선호도검사 S형</h3>
            <p class="exam-description">
              직업선호도검사 S형은 개인이 좋아하는 활동, 자신감을 가지고 있는 분야, 관심있는 직업 및 학문분야 등을 측정하여 직업탐색 및 직업심사결정을 하는데 도움을 주기위한 심리검사입니다.
            </p>
            <button class="btn btn-primary">바로가기</button>
          </div>
          <div class="exam-item">
            <h3 class="exam-title">성인용 직업적성검사</h3>
            <p class="exam-description">
              성인용 직업적성검사는 우리나라 직업에서 요구하는 주요한 직업요인을 바탕으로 검사자가 희망하는 직업에서 요구하는 능력과 검사자의 자신의 능력을 비교할 수 있도록 하여 자신이 바라는 직업을 선택하기 위해 어떤 점을 개선해야 하는지를 알려드리기 위한 검사입니다.
            </p>
            <button class="btn btn-primary">바로가기</button>
          </div>
          <div class="exam-item">
            <h3 class="exam-title">창업적성검사</h3>
            <p class="exam-description">
              창업적성검사는 기업가로서 갖추어야 할 적성을 사업기장성, 매력도, 문제해결능력, 설득력 등 12개 항목으로 나눠 각 항목별로 순차적인 역량분석을 통해 적성과 관심을 측정하여 창업의 적합성을 진단해줍니다.
            </p>
            <button class="btn btn-primary">바로가기</button>
          </div>
          <div class="exam-item">
            <h3 class="exam-title">직업가치관검사</h3>
            <p class="exam-description">
              직업가치관검사는 개인이 중요하게 생각하는 직업가치관에 대해 측정하여 개인의 직업가치관과 개인이 희망하는 직업과의 관계를 안내해드립니다.
            </p>
            <button class="btn btn-primary">바로가기</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import jobSecMenu from '@/views/jobs/jobSecMenu.vue';

export default {
  name: 'CounselingInfo',
  components: {
    MenuPage,
    jobSecMenu
  }
};
</script>

<style scoped>
.boundary {
  padding: 20px;
}

.title {
  text-align: left;
  font-family: 'sj';
  margin-left: 15px;
  margin-bottom: 40px;
}

.info-section {
  background-color: #f8f9fa;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.section-title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-top: 20px;
  margin-bottom: 20px;
}

.exam-list {
  margin-top: 20px;
}

.exam-item {
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 20px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

.exam-title {
  font-size: 1.2rem;
  font-weight: bold;
  margin-bottom: 10px;
}

.exam-description {
  font-size: 1rem;
  margin-bottom: 20px;
}

.btn-primary {
  font-size: 1rem;
  background-color: #007bff;
  border: none;
  color: white;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

.btn-primary:hover {
  background-color: #0056b3;
}
</style> -->





<script>
import MenuPage from '@/components/MenuPage.vue';
import jobSecMenu from '@/views/jobs/jobSecMenu.vue';

export default {
  name: 'CounselingInfo',
  components: {
    MenuPage,
    jobSecMenu
  }
};
</script>

<style scoped>
.info-section {
  background-color: #f8f9fa;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>