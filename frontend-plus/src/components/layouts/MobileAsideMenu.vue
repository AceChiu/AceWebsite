<template>
  <div class="mobile-sidebar">
    <transition name="overlay">
      <div
        v-show="baseStore.menuOpen"
        class="mobile-sidebar__overlay"
        @click="baseStore.menuOpen = false"
      ></div>
    </transition>
    <transition name="sidebar">
      <div v-show="baseStore.menuOpen" class="mobile-sidebar__main">
        <el-menu default-active="1" class="el-menu-vertical-demo">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>Navigator One</span>
            </template>
            <el-menu-item-group title="Group One">
              <el-menu-item index="1-1">item one</el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>item four</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><location /></el-icon>
              <span>Navigator Two</span>
            </template>
            <el-menu-item-group title="Group One">
              <el-menu-item index="1-1">item one</el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>item four</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><location /></el-icon>
              <span>Navigator Three</span>
            </template>
            <el-menu-item-group title="Group One">
              <el-menu-item index="1-1">item one</el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>item four</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="4">
            <el-icon><setting /></el-icon>
            <span>Navigator Four</span>
          </el-menu-item>
        </el-menu>
      </div>
    </transition>
  </div>
</template>

<script lang="ts" setup>
import { base } from '../../store/base'
import { Location, Setting } from '@element-plus/icons-vue'

const baseStore = base()
</script>

<style lang="scss">
.mobile-sidebar {
  text-align: center;
  &__overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(80, 80, 80, 0.46);
    z-index: 98;
  }
  &__main {
    width: 310px;
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: 99;
    overflow: hidden;
    font-size: 16px;
    background-color: pink;
    overflow-y: scroll;
    -webkit-overflow-scrolling: touch;
    background-color: #fff;
    padding-top: 60px;
    transition: padding-top 0.2s;
    list-style: none;
    ul {
      list-style: none;
    }
  }
}
.overlay-enter-active {
  transition: all 0.5s ease-in;
}
.overlay-leave-active {
  transition: all 0.5s ease-out;
}
.sidebar-enter-active {
  transition: all 0.5s ease-in;
}
.sidebar-leave-active {
  transition: all 0.5s ease-out;
}
.sidebar-enter-from,
.sidebar-leave-to {
  transform: translateX(-100%);
  opacity: 0;
}
.overlay-enter-from,
.overlay-leave-to {
  opacity: 0;
}
</style>
