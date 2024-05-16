import {createStore} from 'vuex'

// Create a new store instance
const store = createStore({
    state() {
        return {
            account: {
                id: 0
            }
        }
    },
    mutations: {
        setAccount(state, payload) {
            // id 값 payload 에 세팅하겠다
            state.account.id = payload;
        }
    }
})

export default store;