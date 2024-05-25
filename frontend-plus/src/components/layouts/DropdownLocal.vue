<template>
  <el-dropdown @command="handleCommand" class="dropdown-local">
    <span class="el-dropdown-link" v-if="isDesktop">
      {{ localList.find((e) => e.name === baseStore.language)?.label }}
      <el-icon class="el-icon--right"><arrow-down /></el-icon>
    </span>
    <span v-else class="el-dropdown-link"
      ><el-icon size="20"><LocationFilled /></el-icon
    ></span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item v-for="(item, i) in localList" :command="item.name" :key="i">
          {{ item.label }}
        </el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>
<script lang="ts" setup>
import { ref, computed, onMounted } from 'vue'
import { base } from '~/store/base'
import { ElMessage } from 'element-plus'
import { ArrowDown, LocationFilled } from '@element-plus/icons-vue'
import i18n from '~/config/i18n'

const baseStore = base()
const windowWidth = ref(0)
const localList = ref([
  { name: 'tw', label: '繁體中文' },
  { name: 'en', label: 'English' },
  { name: 'cn', label: '简体中文' }
])
const handleCommand = (command: 'tw' | 'en' | 'cn') => {
  ElMessage(`click on item ${command}`)
  i18n.global.locale.value = command
  baseStore.setLanguage(command)
}
const isDesktop = computed(() => windowWidth.value >= 768)
window.addEventListener('resize', () => {
  windowWidth.value = document.documentElement.clientWidth
})
onMounted(() => {
  windowWidth.value = document.documentElement.clientWidth
})
</script>
<style lang="scss">
.dropdown-local {
  color: #fff !important;
  font-size: 14px;
  cursor: pointer;
  display: flex;
  align-items: center;
}
</style>
