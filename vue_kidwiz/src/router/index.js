import { createRouter, createWebHashHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import Boardwrite from "@/views/boardviews/BoardWrite.vue";
import insertTest from "@/views/insertTest.vue";
import boardDetail from "@/views/boardviews/BoardDetail.vue";
import boardUpdate from "@/views/boardviews/BoardUpdate.vue";
import boardReply from "@/views/boardviews/BoardReply.vue";

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
    {path: '/rsrvTest', name:'rsrvTest', component: () => import('@/views/RsvAndApply/rsrvTest.vue')},
    {path: '/rsrvTest2', name:'rsrvTest2', component: () => import('@/views/RsvAndApply/rsrvTest2.vue')},
    {path: '/rsrvTest3', name:'rsrvTest3', component: () => import('@/views/RsvAndApply/rsrvTest3.vue')},
    {path: '/rsrvTest4', name:'rsrvTest4', component: () => import('@/views/RsvAndApply/rsrvTest4.vue')},
    {path: '/applyForm1', name:'applyForm1', component: () => import('@/views/RsvAndApply/applyForm1.vue'), props: route => ({ ...route.query })},
    {path: '/GroupList', name:'groupList', component: () => import('@/views/groupviews/groupList.vue')}
];

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
});

export default router