<template>
  <div class="error-page">
    <div class="error-container">
      <span class="error-container__code">{{ $route.query.errorCode || 404 }}</span>
      <span class="error-container__title">Page Not Found</span>
      <span class="error-container__content"
        >The page you are looking for might have been removed had its name changed or is temporarily
        unavailable.</span
      >
      <button v-if="$route.query.redirect !== 'false'" class="error-container__goto-home-button">
        {{ `GO TO HOME PAGE IN ${countDown}s` }}
      </button>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'

const $router = useRouter()
const $route = useRoute()

const countDown = ref(5)
onMounted(async () => {
  if ($route.query.redirect !== 'false') {
    const timer = setInterval(function () {
      countDown.value--
      if (countDown.value <= 0) {
        clearInterval(timer)
        $router.push({ name: 'home' })
      }
    }, 1000)
  }
})
</script>
<style lang="scss">
.error-page {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  .error-container {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    height: 100%;
    &__code {
      font-size: 100px;
      font-weight: 900;
      margin: 0;
      background-image: linear-gradient(to top, $delta-blue, $delta-green);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      background-size: cover;
      background-position: center;
    }
    &__title {
      font-family:
        titillium web,
        sans-serif;
      font-size: 26px;
      font-weight: 700;
    }
    &__content {
      font-family: montserrat, sans-serif;
      font-size: 14px;
      font-weight: 500;
      margin-bottom: 0;
      text-transform: uppercase;
      word-break: break-word;
      text-align: left;
      margin-top: 10px;
    }
    &__goto-home-button {
      margin-top: 20px;
      padding: 10px 8px;
      background-color: $delta-blue;
      color: #fff;
      border: unset;
      cursor: pointer;
      transition: all 0.5s ease-in;
      &:hover {
        opacity: 0.8;
        border-radius: 10px;
      }
    }
  }
}
</style>
