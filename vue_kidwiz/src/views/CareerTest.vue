<template>
    <div class="careernet-test">
        <h2>진로검사</h2>
        <div v-if="questions.length > 0">
            <question v-for="(question, index) in questions" :key="index" :question="question" />
        </div>
        <div v-else>
            <p>테스트 질문을 불러오는 중입니다...</p>
        </div>

        <button v-if="questions.length > 0" @click="submitTestResult">결과 제출</button>
    </div>
</template>

<script>
    import Question from './Question.vue';

    export default {
        components: {
            Question
        },
        data() {
            return {
                questions: [],
                testResult: {}
            };
        },
        mounted() {
            this.getTestQuestions();
        },
        methods: {
            async getTestQuestions() {
                const questions = await this.$api.getTestQuestions(100); // 테스트 질문 번호 (예시)
                this.questions = questions;
            },
            async submitTestResult() {
                const result = await this.$api.submitTestResult(this.testResult);
                if (result) {
                    // 테스트 결과 처리
                }
            }
        }
    };
</script>

<style scoped>
    .careernet-test {
        padding: 20px;
    }

    .question {
        margin-bottom: 20px;
    }
</style>
