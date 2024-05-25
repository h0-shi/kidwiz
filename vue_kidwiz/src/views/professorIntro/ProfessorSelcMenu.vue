<template>
    <div>
        <br />
        <div class="sbmContainer boundary">
            <table class="subMenu">
                <tr>
                    <th :style="select[0]" @click="handleClick(0, 'ProfessorIntro')">
                        <router-link :to="{ name: 'ProfessorIntro' }" class="router-link">지도교수 상담 안내</router-link>
                    </th>
                    <th :style="select[1]" @click="handleClick(1, 'rsrvTest4')">
                        <router-link :to="{ name: 'rsrvTest4' }" class="router-link">상담 예약</router-link>
                    </th>
                </tr>
            </table>
        </div>
        <section class="section s1" :style="cssAct[0]"></section>
        <section class="section s2" :style="cssAct[1]"></section>
    </div>
</template>

<script>
export default {
    data() {
        return {
            cssAct: [
                { display: "none" },
                { display: "none" },
            ],
            select: [
                {},
                {},
            ],
        };
    },
    mounted() {
        this.updateDisplay(this.$route.name);
    },
    watch: {
        '$route.name'(newRoute) {
            this.updateDisplay(newRoute);
        }
    },
    methods: {
        handleClick(num, routeName) {
            this.$router.push({ name: routeName });
        },
        updateDisplay(routeName) {
            const routeIndexMap = {
                'ProfessorIntro': 0,
                'rsrvTest4': 1,
            };
            const index = routeIndexMap[routeName] || 0;
            this.cssAct = this.cssAct.map((style, i) => i === index ? { display: "block", backgroundColor: "#333", color: "#fff" } : { display: "none" });
            this.select = this.select.map((style, i) => i === index ? { border: "2px solid #67BF4E", 'border-bottom': "none", color: "#67BF4E" } : {});

        }
    }
};
</script>

<style scoped>
.sbmContainer {
    width: 100%;
    margin-bottom: 50px;
}

.subMenu {
    width: 100%;
    margin: auto;
    table-layout: fixed;
}

.subMenu tr th {
    width: 20%;
    height: 55px;
    border-bottom: 2px solid #67BF4E;
    text-align: center;
    cursor: pointer;
}

.boundary {
    width: 100%;
    max-width: 1200px;
    margin: auto;
    padding: 0 auto;
}

.router-link {
    display: block;
    height: 70%;
    width: 100%;
    text-decoration: none;
    color: inherit;
}
</style>
