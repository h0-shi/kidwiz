import ContactMap from '@/views/contactFolder/ContactMap.vue';
import CounselingIntro from '@/views/counselingFolder/CounselingIntro.vue';
import CounselorShow from '@/views/counselorShow/CounselorShow.vue';
import FaqQuestion from '@/views/faqFolder/FaqQuestion.vue';
import FaqWrite from '@/views/faqFolder/FaqWrite.vue'; 
import FaqDetail from '@/views/faqFolder/FaqDetail.vue'; // 새로운 컴포넌트 추가
import CareerTest from '@/views/testFolder/CareerTest.vue';
import PersonTest from '@/views/testFolder/PersonTest.vue';
import ResultPage from '@/views/testFolder/ResultPage.vue';
import OfflineSubmit from '@/views/submitFolder/OfflineSubmit.vue';
import mainPage from '@/views/mainPage.vue';

import { createRouter, createWebHashHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import Boardwrite from "@/views/boardviews/BoardWrite.vue";
import insertTest from "@/views/regviews/insertTest.vue";
import boardDetail from "@/views/boardviews/BoardDetail.vue";
import boardUpdate from "@/views/boardviews/BoardUpdate.vue";
import boardReply from "@/views/boardviews/BoardReply.vue";
import login from "@/views/LoginPage.vue";
import jobconsulting from "@/views/JobConsulting.vue";

import menu from '@/components/MenuPage.vue';
import pop from '@/layout/RegTimeLayout.vue';

const routes = [
    {path: '/', component: mainPage, meta: {layout : menu}},
    {path: '/menu', name:'testVue', component: testVue, meta: {layout : menu}},
    {path: '/testVue', name:'testVue', component: testVue, meta: {layout : menu}},
    {path: '/listTest', name:'listTest', component: listTest, meta: {layout : menu}},
    {path:'/BoardList', name:'BoardList', component: () => import('../views/boardviews/BoardList.vue'), meta: {layout : menu}},
    {path:'/BoardWrite', name:'BoardWrite', component: Boardwrite, meta: {layout : menu}},
    {path: '/insertTest', name:'insertTest', component: insertTest, meta: {layout : menu}},
    {path:"/boardDetail", name:"boardDetail", component: boardDetail, meta: {layout : menu}},
    {path:"/boardUpdate", name:"boardUpdate",component:boardUpdate, meta: {layout : menu}},
    {path:"/BoardReply", name:"BoardReply",component:boardReply, meta: {layout : menu}},
    {path: '/GroupList', name:'groupList', component: () => import('@/views/groupviews/groupList.vue'), meta: {layout : menu}},
    {path:"/groupDetail", name:"groupDetail", component:()=> import("@/views/groupviews/groupDetail.vue"), meta: {layout : menu}},
    {path:"/BoardReply", name:"BoardReply",component:boardReply, meta: {layout : menu}},
    {path:"/groupCreate", name:"/groupCreate", component:()=> import("@/views/groupviews/groupCreate.vue"), meta: {layout : menu}},
    {path: '/regRev', name:'regRev', component: () => import('@/views/regviews/RegRev.vue'), meta: {layout : menu}},
    {path: '/regTime', component: () => import('@/views/regviews/RegTime.vue'), meta: { layout:pop}},
    {path: '/GroupList', name:'groupList', component: () => import('@/views/groupviews/groupList.vue'), meta: {layout : menu}},
    {path: "/groupDetail", name:"groupDetail", component:()=> import("@/views/groupviews/groupDetail.vue"), meta: {layout : menu}},
    {path: "/BoardReply", name:"BoardReply",component:boardReply, meta: {layout : menu}},
    {path: "/rsrv", component:()=> import("@/views/rsrvTest3.vue"), meta: {layout : menu}},
    {path: '/jobconsulting', name: 'jobconsulting', component: jobconsulting, meta: {layout : menu}}, // 취업상담 경로 추가
    {path: '/login', name: 'login', component: login, meta: {layout : menu} }, // 로그인 경로 추가
    {path: '/contact', name: 'Contact', component: ContactMap, meta: {layout : menu}},
    {path: '/counseling', name: 'Counseling', component: CounselingIntro, meta: {layout : menu}},
    {path: '/counselorshow', name: 'CounselorShow', component: CounselorShow, meta: {layout : menu}},
    {path: '/faq', name: 'FAQ', component: FaqQuestion, meta: {layout : menu}},
    {path: '/faqwrite', name: 'FaqWrite', component: FaqWrite, meta: {layout : menu}},
    {path: '/faq/:id', name: 'FaqDetail', component: FaqDetail, meta: {layout : menu}},// 동적 세그먼트를 포함하는 라우트 추가
    {path: '/offlineSubmit', name: 'OfflineSubmit', component: OfflineSubmit, meta: {layout : menu}},
    {path: '/test', name: 'Test', component: CareerTest,
      children: [
        {path: 'career', name: 'CareerTest', component: CareerTest,},
        {path: 'person', name: 'PersonTest', component: PersonTest,},
        {path: 'result', name: 'ResultPage', component: ResultPage,}, ], meta: {layout : menu}
    }
];

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
});

export default router;
