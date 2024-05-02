import { createRouter, createWebHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import Boardwrite from "@/views/BoardWrite.vue";

const routes = [
    {path: '/testVue', name:'testVue', component: testVue},
    {path: '/listTest', name:'listTest', component: listTest},
    {path:'/BoardList', name:'BoardList', component: () => import('../views/BoardList.vue')},
    {path:'/BoardWrite', name:'BoardWrite', component: Boardwrite},
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router