<template>
    <div>
        <MenuPage />
        <div class="boundary">
            <h1 class="title">지도교수 상담</h1>
            <ProfessorSelcMenu />
            <div class="container py-5">
                <!-- 소개란 -->
                <Professorcinfo />

            </div>
        </div>
    </div>
</template>

<script>
import MenuPage from '@/components/MenuPage.vue';
import ProfessorSelcMenu from '@/views/professorIntro/ProfessorSelcMenu.vue';
import Professorcinfo from '@/views/professorIntro/Professorcinfo.vue';

export default {
    name: 'ProfessorIntro',
    components: {
        MenuPage,
        ProfessorSelcMenu,
        Professorcinfo
    }
};
</script>