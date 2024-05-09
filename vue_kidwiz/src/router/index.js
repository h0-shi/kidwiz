import { createRouter, createWebHashHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import Boardwrite from "@/views/boardviews/BoardWrite.vue";
import insertTest from "@/views/regviews/insertTest.vue";
import boardDetail from "@/views/boardviews/BoardDetail.vue";
import boardUpdate from "@/views/boardviews/BoardUpdate.vue";
import boardReply from "@/views/boardviews/BoardReply.vue";

import menu from '@/components/MenuPage.vue';
import pop from '@/layout/RegTimeLayout.vue';

const routes = [
    {path: '/menu', name:'testVue', component: testVue, meta: {layout : menu}},
    {path: '/testVue', name:'testVue', component: testVue, meta: {layout : menu}},
    {path: '/listTest', name:'listTest', component: listTest, meta: {layout : menu}},
    {path:'/BoardList', name:'BoardList', component: () => import('../views/boardviews/BoardList.vue'), meta: {layout : menu}},
    {path:'/BoardWrite', name:'BoardWrite', component: Boardwrite, meta: {layout : menu}},
    {path: '/insertTest', name:'insertTest', component: insertTest, meta: {layout : menu}},
    {path:"/boardDetail", name:"boardDetail", component: boardDetail, meta: {layout : menu}},
    {path:"/boardUpdate", name:"boardUpdate",component:boardUpdate, meta: {layout : menu}},
    {path:"/BoardReply", name:"BoardReply",component:boardReply},
    {path: '/GroupList', name:'groupList', component: () => import('@/views/groupviews/groupList.vue')},

    {path: '/regRev', name:'regRev', component: () => import('@/views/regviews/RegRev.vue'), meta: {layout : menu}},
    {path: '/regTime', component: () => import('@/views/regviews/RegTime.vue'), meta: { layout:pop}},
];

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
});

export default router