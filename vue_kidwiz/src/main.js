import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// var history = require('connect-history-api-fallback');


const app = createApp(App)

// app.use(history()).listen(80)
app.use(router).mount('#app')


