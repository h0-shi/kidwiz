import { createRouter, createWebHistory } from 'vue-router';
import SimriMain from '@/views/SimriMain.vue';
import ContactMap from '@/views/contactFolder/ContactMap.vue';
import CounselingIntro from '@/views/counselingFolder/CounselingIntro.vue';
import CounselorShow from '@/views/counselorShow/CounselorShow.vue';
import FaqQuestion from '@/views/faqFolder/FaqQuestion.vue';
import FaqWrite from '@/views/faqFolder/FaqWrite.vue'; 
import FaqDetail from '@/views/faqFolder/FaqDetail.vue'; 
import TestMain from '@/views/testFolder/TestMain.vue';
import CareerTest from '@/views/testFolder/CareerTest.vue';
import PersonTest from '@/views/testFolder/PersonTest.vue';
import ResultPage from '@/views/testFolder/ResultPage.vue';
import OfflineSubmit from '@/views/submitFolder/OfflineSubmit.vue';

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'SimriMain',
      component: SimriMain,
    },
    {
      path: '/contact',
      name: 'Contact',
      component: ContactMap,
    },
    {
      path: '/counseling',
      name: 'Counseling',
      component: CounselingIntro,
    },
    {
        path: '/counselorshow',
        name: 'CounselorShow',
        component: CounselorShow,
    },
    {
      path: '/faq',
      name: 'FAQ',
      component: FaqQuestion,
    },
    {
      path: '/faqwrite',
      name: 'FaqWrite',
      component: FaqWrite,
    },
    {
      path: '/faq/:id', // 동적 세그먼트를 포함하는 라우트 추가
      name: 'FaqDetail',
      component: FaqDetail,
    },
    {
        path: '/offlineSubmit',
        name: 'OfflineSubmit',
        component: OfflineSubmit,
    },
    {
      path: '/test',
      name: 'Test',
      component: TestMain // Test 페이지로 연결
    },
    {
      path: '/test/career', // CareerTest 페이지로 연결
      name: 'CareerTest',
      component: CareerTest
    },
    {
      path: '/test/person', // PersonTest 페이지로 연결
      name: 'PersonTest',
      component: PersonTest,
    },
    {
      path: '/test/result', // ResultPage 페이지로 연결
      name: 'ResultPage',
      component: ResultPage,
    },

  ],
});

export default router;
