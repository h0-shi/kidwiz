import { createRouter, createWebHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";

const routes = [
    {path: '/testVue', name:'testVue', component: testVue},
    {path: '/listTest', name:'listTest', component: listTest},
    {path:'/testSeonwoo', name:'testSeonwoo', component: () => import('../views/TestSeonwoo.vue')}
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router