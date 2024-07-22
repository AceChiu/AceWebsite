<template>
  <div>
    <el-container class="layout">
      <!-- <el-aside class="aside" width="auto">
        <DesktopAsideMenu></DesktopAsideMenu>
        <MobileAsideMenu></MobileAsideMenu>
      </el-aside> -->
      <el-container class="layout-container">
        <el-header class="header">
          <DefaultHeader />
        </el-header>
        <!-- <NavigationHeader></NavigationHeader> -->
        <el-container class="layout-container__main">
          <el-main class="main" id="main">
            <slot />
          </el-main>
          <el-footer class="footer"
            >Copyright &copy; 2023 Delta IT . All Rights Reserved.</el-footer
          >
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>
<script setup lang="ts">
import DefaultHeader from './DefaultHeader.vue'
// import DesktopAsideMenu from '~/components/layouts/DesktopAsideMenu.vue'
// import MobileAsideMenu from '~/components/layouts/MobileAsideMenu.vue'
// import NavigationHeader from '~/components/layouts/NavigationHeader.vue'
</script>
<style lang="scss" scoped>
.layout {
  height: 200vh;
}
.layout-container {
  height: 200vh;
  &__main {
    overflow-y: auto;
  }
}
.aside {
  position: relative;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(#000, 0.1);
}
.header {
  background-color: $delta-gold;
  line-height: 60px;
  text-align: center;
  font-size: 16px;
  color: #fff;
}
.main {
  // background-color: black;
  position: relative;
  padding: 32px 24px;
  &::before {
    //背景透明度設定
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('../../assets/logo.jpg');
    background-size: cover;
    opacity: 0.6;
    z-index: -1;
  }
}
.footer {
  background-color: $delta-silver-white;
  height: unset;
  text-align: center;
  font-size: 12px;
}
.desktop-aside-menu {
  @media (max-width: 767.98px) {
    display: none;
  }
}
.mobile-sidebar {
  display: none;
  @media (max-width: 767.98px) {
    display: block;
  }
}
.navigation-header {
  @media (max-width: 767.98px) {
    display: none;
  }
}
</style>
