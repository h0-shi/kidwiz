import { createRouter, createWebHashHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import Boardwrite from "@/views/boardviews/BoardWrite.vue";
import insertTest from "@/views/regviews/insertTest.vue";
import boardDetail from "@/views/boardviews/BoardDetail.vue";
import boardUpdate from "@/views/boardviews/BoardUpdate.vue";

const routes = [
    {path: '/testVue', name:'testVue', component: testVue},
    {path: '/listTest', name:'listTest', component: listTest},
    {path:'/BoardList', name:'BoardList', component: () => import('../views/boardviews/BoardList.vue')},
    {path:'/BoardWrite', name:'BoardWrite', component: Boardwrite},
    {path: '/insertTest', name:'insertTest', component: insertTest},
    {path:"/boardDetail", name:"boardDetail", component: boardDetail},
    {path:"/boardUpdate", name:"boardUpdate",component:boardUpdate},
    {path: '/regRev', name:'regRev', component: () => import('@/views/regviews/RegRev.vue')},
    {path: '/regTime', name:'regTime', component: () => import('@/views/regviews/RegTime.vue')}
];

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
});

export default router