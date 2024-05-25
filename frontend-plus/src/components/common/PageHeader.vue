<template>
  <div class="page-header">
    <h1 class="page-header__title">
      {{ props.title }}
    </h1>
    <div v-if="$slots.default" class="page-header__action">
      <slot />
    </div>
  </div>
</template>

<script lang="ts" setup>
const props = defineProps<{ title: string }>()
</script>

<style lang="scss">
.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  font-weight: 700;
  &__title {
    font-size: 24px;
    text-transform: capitalize;
    color: $delta-black;
    margin: 0;
  }
}
</style>
