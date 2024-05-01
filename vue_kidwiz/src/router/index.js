import { createRouter, createWebHistory } from "vue-router";
import testVue from "@/views/TestVue.vue";
import listTest from "@/views/ListTest.vue";
import insertTest from "@/views/insertTest.vue";

const routes = [
    {path: '/testVue', name:'testVue', component: testVue},
    {path: '/listTest', name:'listTest', component: listTest},
    {path: '/insertTest', name:'insertTest', component: insertTest}
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router