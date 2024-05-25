<template>
  <el-config-provider>
    <DefaultLayout v-loading="baseStore.loading">
      <template #default>
        <router-view :key="currentRoute" />
      </template>
    </DefaultLayout>
  </el-config-provider>
</template>
<script setup lang="ts">
import { computed } from 'vue'
import { useRouter } from 'vue-router'
import { base } from '~/store/base'

const baseStore = base()
const $router = useRouter()
const currentRoute = computed(() => {
  return $router.currentRoute.value.fullPath
})
</script>
