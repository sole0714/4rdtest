<template>
  <div id="app">
    <nav style="padding: 20px; background: #f4f4f4; margin-bottom: 20px;">
      <router-link to="/board/list">목록</router-link> |
      <router-link to="/board/reg">글쓰기</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script setup lang="ts">
</script>

<style>
.container { max-width: 800px; margin: 0 auto; padding: 20px; }
table th, table td { padding: 10px; border: 1px solid #ddd; }
</style>
