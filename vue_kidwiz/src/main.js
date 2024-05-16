import { createApp } from 'vue'
import store from "@/views/store"
import App from './App.vue'
import router from './router'
import BootstrapVue3 from 'bootstrap-vue-3'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle.min.js"



const app = createApp(App)
app.use(store)
app.use(BootstrapVue3)
app.use(router).mount('#app')



