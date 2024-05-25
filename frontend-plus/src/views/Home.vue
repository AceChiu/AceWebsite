<template>
  <div class="home">
    <!-- <img alt="Vue logo" class="element-plus-logo" src="../assets/logo.png" /> -->
    <!-- <HelloWorld msg="Hello Vue 3.0 + Element Plus + Vite in Delta" /> -->
    <div class="left-panel">
      <h2 class="subtitle">每週任務</h2>
      <div class="task-buttons">
        <button v-for="(task, index) in defaultTasks" :key="index" class="task-button">{{ task }}</button>
      </div>
    </div>
    <div class="right-panel">
      <h1 class="title">自己的任務</h1>
      <button class="button" @click="spinWheel" :disabled="tasks.length === 0 || spinning">Draw Task</button>
      <transition name="fade">
        <div v-if="spinning" class="overlay">
          <div class="spinner"></div>
        </div>
      </transition>
      <div class="task-buttons">
        <button v-for="(task, index) in selectedTasks" :key="index" class="task-button">{{ task }}</button>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { defineComponent } from 'vue'
import { ref } from 'vue';

  const defaultTasks = ['Task 1', 'Task 2', 'Task 3', 'Task 4', 'Task 5'];
  const tasks = ref<string[]>([...defaultTasks]);
  const selectedTasks = ref<string[]>([]);
  const spinning = ref<boolean>(false);

  function spinWheel() {
    if (tasks.value.length === 0 || spinning.value) return;
    spinning.value = true;
    setTimeout(() => {
      const index = Math.floor(Math.random() * tasks.value.length);
      tasks.value.splice(index, 1);
      const selectedTask = tasks.value[index];
      selectedTasks.value.push(selectedTask);
      spinning.value = false;
    }, 2000); // 模拟抽奖过程，2秒后停止旋转，并显示选中任务
  }
defineComponent({
  name: 'HomeView'
})
</script>
<style lang="scss">

.overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 999;
  }

  .spinner {
    border: 16px solid #f3f3f3; /* Light grey */
    border-top: 16px solid #3498db; /* Blue */
    border-radius: 50%;
    width: 120px;
    height: 120px;
    animation: spin 2s linear infinite;
  }

  @keyframes spin {
    0% {
      transform: rotate(0deg);
    }
    100% {
      transform: rotate(360deg);
    }
  }
.animate-spin {
    animation: spin 2s linear infinite;
  }

  @keyframes spin {
    0% {
      transform: rotate(0deg);
    }
    100% {
      transform: rotate(360deg);
    }
  }
.home {
    display: flex;
    justify-content: space-between;
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    text-align: center;
  }

  .left-panel {
    flex: 1;
    text-align: left;
  }

  .right-panel {
    flex: 1;
    text-align: center;
  }

  .title {
    font-size: 2.5rem;
    margin-bottom: 20px;
  }

  .button {
    background-color: #4caf50;
    color: white;
    padding: 10px 20px;
    font-size: 1.2rem;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
  }

  .button:hover {
    background-color: #45a049;
  }

  .subtitle {
    font-size: 1.5rem;
    margin-top: 20px;
    margin-bottom: 10px;
  }

  .task-container {
    margin-top: 30px;
  }

  .task-box {
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 20px;
    font-size: 1.2rem;
    margin-top: 10px;
  }

  .task-buttons {
    display: flex;
    flex-wrap: wrap;
  }

  .task-button {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    font-size: 1.2rem;
    border: none;
    border-radius: 5px;
    margin-right: 10px;
    margin-bottom: 10px;
    cursor: pointer;
    transition: background-color 0.3s;
  }

  .task-button:hover {
    background-color: #0056b3;
  }
</style>
