<template>
  <div>
    <MenuPage />
    <div class="boundary">
      <h1 class="title">취업 상담</h1>
      <jobSecMenu />
      <div class="container py-6 px-lg-7 rounded shadow-lg mt-5">
        <div class="row justify-content-center">
          <div class="col-lg-11">
            <div
              class="profile-header text-white py-4 rounded-top"
              style="margin-top: 50px; background-color: #67bf4e"
            >
              <div class="row align-items-center">
                <div class="col-md-4 order-md-2 text-center">
                  <img
                    :src="require('@/assets/simri2.png')"
                    alt="Counselor Image"
                    class="img-fluid rounded-circle mb-3 shadow"
                    style="width: 250px; height: 250px; object-fit: cover"
                  />
                </div>
                <div
                  class="col-md-8 order-md-2 text-white"
                  style="text-align: left; padding-left: 50px"
                >
                  <h1 class="mb-1">{{ counselor.name }}</h1>
                  <p class="mb-3">{{ counselor.title }}</p>
                  <br />
                  <p class="mb-4">{{ counselor.bio }}</p>
                  <br />
                  <p
                    :href="'mailto:' + counselor.email"
                    class="text-decoration-none"
                  >
                    {{ counselor.email }}
                  </p>
                </div>
              </div>
            </div>

            <div
              class="profile-body bg-white rounded p-4 mt-n5 position-relative"
            >
              <ul
                class="lead mb-4"
                style="
                  font-weight: 500;
                  text-align: left;
                  list-style: none;
                  padding-left: 0;
                "
              >
                <li
                  v-for="item in counselor.greeting.split('?')"
                  :key="item"
                  v-html="item.trim()"
                ></li>
              </ul>
              <br />

              <div class="row">
                <div class="col-md-3 mb-8">
                  <div class="card h-100 border-0 shadow-sm">
                    <div
                      class="card-body d-flex flex-column align-items-center justify-content-center"
                    >
                      <h5
                        class="card-title font-weight-bold"
                        style="font-weight: bold"
                      >
                        경력
                      </h5>
                      <br />
                      <p class="card-text text-center">
                        {{ counselor.experience }} 년
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-md-4 mb-8">
                  <div class="card h-100 border-0 shadow-sm">
                    <div
                      class="card-body d-flex flex-column align-items-center justify-content-center"
                    >
                      <h5
                        class="card-title font-weight-bold"
                        style="font-weight: bold"
                      >
                        전문분야
                      </h5>
                      <br />
                      <ul class="card-text text-center list-unstyled">
                        <li
                          v-for="item in counselor.expertise.split(',')"
                          :key="item"
                        >
                          {{ item.trim() }}
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="col-md-5 mb-8">
                  <div class="card h-100 border-0 shadow-sm">
                    <div
                      class="card-body d-flex flex-column align-items-center justify-content-center"
                    >
                      <h5
                        class="card-title font-weight-bold"
                        style="font-weight: bold"
                      >
                        자격증
                      </h5>
                      <br />
                      <ul class="card-text text-center list-unstyled">
                        <li
                          v-for="cert in counselor.certifications.split(',')"
                          :key="cert"
                        >
                          {{ cert.trim() }}
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <button
          @click="contactCounselor"
          class="btn btn-success btn-lg btn-block mt-4 shadow-sm"
          style="margin-bottom: 40px"
        >
          상담 요청
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import MenuPage from "@/components/MenuPage.vue";
import jobSecMenu from "@/views/jobs/jobSecMenu.vue";

export default {
  components: {
    MenuPage,
    jobSecMenu,
  },
  data() {
    return {
      counselor: {
        name: "이문희 상담사",
        title: "취업상담사",
        image: "https://via.placeholder.com/250",
        bio: "취업 준비의 모든 과정에서 여러분과 함께하겠습니다.",
        expertise: "진로 탐색, 경력 설계, 직무 체험 기회 제공",
        experience: 11,
        certifications:
          "직업상담사 1급, 한국커리어개발협회(KCDA) 인증 커리어코치",
        email: "kimcounselor@example.com",
        greeting: `
          안녕하세요. 취업상담사 이문희입니다!<br>
          취업의 문턱을 넘는 과정이 어렵고 복잡하게 느껴질 수 있습니다.<br>
          하지만 여러분의 가능성과 능력을 믿으며, 함께 걸어갈 때 더 큰 성과를 이룰 수 있습니다.<br>
          성공적인 취업을 위해 모든 지원을 아끼지 않겠습니다.
        `,
      },
    };
  },
  methods: {
    contactCounselor() {
      this.$router.push("/rsrvTest4?selectedCounselingType=취업상담");
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 1200px;
  background-color: #f9f9f9;
  border-radius: 8px;
}

.profile-body {
  background-color: white;
  padding: 30px;
  border-radius: 8px;
}

.card {
  border: none;
}

.card-body {
  padding: 0;
  height: 150px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(238, 238, 238, 0.3),
    0 6px 20px rgba(202, 202, 202, 0.19);
}

.row > .col-lg-3,
.row > .col-md-6 {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.bg-light {
  background-color: #e7f3ff !important;
}

.btn {
  font-size: 1.2rem;
  background-color: #67bf4e;
  border: #67bf4e;
}
.title {
  text-align: left;
  font-family: "sj";
  margin-left: 15px;
  margin-bottom: 40px;
}
</style>