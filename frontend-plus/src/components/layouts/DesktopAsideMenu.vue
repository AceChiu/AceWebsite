<template>
  <el-menu
    default-active="1"
    class="desktop-aside-menu"
    :collapse="!baseStore.menuOpen"
    @select="handleMenuSelect"
  >
    <el-sub-menu index="1">
      <template #title>
        <el-icon><location /></el-icon>
        <span>Demo 1</span>
      </template>
      <el-menu-item index="DEMO1_TABLEDEMO">Table Demo</el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="2">
      <template #title>
        <el-icon><location /></el-icon>
        <span>Demo 2</span>
      </template>
      <el-menu-item index="DEMO2_FILEUPLOADERDEMO">Uploader Demo</el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script lang="ts" setup>
import {} from 'vue'
import { Location } from '@element-plus/icons-vue'
import { base } from '../../store/base'
import { useRouter } from 'vue-router'

const baseStore = base()
const router = useRouter()

function handleMenuSelect(e: string) {
  router.push({ name: e })
}
</script>
<style lang="scss" scoped>
.el-menu:not(.el-menu--collapse) {
  width: 250px;
  height: 100vh;
}
</style>
