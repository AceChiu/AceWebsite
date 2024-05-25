<template>
  <div class="default-header">
    <div class="default-header__left">
      <el-icon
        v-show="!baseStore.menuOpen"
        class="default-header__hamburger"
        @click="changeCollapseStatus(true)"
        size="30px"
        ><Expand
      /></el-icon>
      <el-icon
        v-show="baseStore.menuOpen"
        class="default-header__hamburger default-header__hamburger--close"
        @click="changeCollapseStatus(false)"
        size="30px"
        ><Fold
      /></el-icon>
      <a
        class="default-header__left-title default-header__center-title"
        @click="$router.push({ name: 'home' })"
      >
        <!-- <img class="default-header__logo" src="../../assets/logo_w.svg" /> -->
        <span class="default-header__title">想學教育</span>
      </a>
    </div>

    <div class="default-header__right">
      <DropdownLocal></DropdownLocal>
      <DropdownUser></DropdownUser>
    </div>
  </div>
</template>
<script setup lang="ts">
import DropdownLocal from '~/components/layouts/DropdownLocal.vue'
import DropdownUser from '~/components/layouts/DropdownUser.vue'
import { Expand, Fold } from '@element-plus/icons-vue'
import { base } from '../../store/base'

const baseStore = base()

function changeCollapseStatus(bool: boolean) {
  baseStore.menuOpen = bool
}
</script>
<style lang="scss" scoped>
.default-header {
  height: 100%;
  color: black;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  overflow: hidden;
  &__left {
    display: flex;
    align-items: center;
  }
  &__right {
    display: flex;
    align-items: center;
  }
  &__left-title {
    display: inline-flex;
    align-items: baseline;
    color: black;
    font-size: 16px;
    font-weight: 600;
    text-decoration: none;
    margin-top: 15px;
    white-space: nowrap;
    cursor: pointer;
  }
  &__center-title {
    @media (max-width: 767.98px) {
      margin-top: 0;
      cursor: pointer;
    }
  }
  &__logo {
    margin-right: 16px;
  }
  &__title {
    @media (max-width: 767.98px) {
      display: none;
    }
  }
  .dropdown-local {
    margin-right: 16px;
  }
  &__hamburger {
    margin-right: 20px;
    cursor: pointer;
    z-index: 100;
    &--close {
      color: #fff;
      @media (max-width: 767.98px) {
        color: $delta-blue;
      }
    }
  }
}
</style>
