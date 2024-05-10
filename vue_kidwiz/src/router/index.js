import { createRouter, createWebHashHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import Boardwrite from "@/views/boardviews/BoardWrite.vue";
import insertTest from "@/views/insertTest.vue";
import boardDetail from "@/views/boardviews/BoardDetail.vue";
import boardUpdate from "@/views/boardviews/BoardUpdate.vue";
import boardReply from "@/views/boardviews/BoardReply.vue";
import login from "@/views/LoginPage.vue";
import jobconsulting from "@/views/JobConsulting.vue";

const routes = [
    {path: '/testVue', name:'testVue', component: testVue},
    {path: '/listTest', name:'listTest', component: listTest},
    {path:'/BoardList', name:'BoardList', component: () => import('../views/boardviews/BoardList.vue')},
    {path:'/BoardWrite', name:'BoardWrite', component: Boardwrite},
    {path: '/insertTest', name:'insertTest', component: insertTest},
    {path:"/boardDetail", name:"boardDetail", component: boardDetail},
    {path:"/boardUpdate", name:"boardUpdate",component:boardUpdate},
    {path:"/BoardReply", name:"BoardReply",component:boardReply},
    {path: '/regRev', name:'regRev', component: () => import('@/views/RegRev.vue')},
    {path: '/GroupList', name:'groupList', component: () => import('@/views/groupviews/groupList.vue')},
    {path:"/boardReply", name:"boardReply",component:boardReply},
    {path: '/regRev', name:'regRev', component: () => import('@/views/RegRev.vue')},
    {path: '/jobconsulting', name: 'jobconsulting', component: jobconsulting }, // 취업상담 경로 추가
    {path: '/login', name: 'login', component: login } // 로그인 경로 추가
];

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
});

export default router