<template>
  <div class="container">
    <h2>게시글 목록</h2>
    <div style="text-align: right; margin-bottom: 10px;">
      <button @click="$router.push('/board/reg')">글쓰기</button>
    </div>
    <table border="1" style="width: 100%; border-collapse: collapse;">
      <thead>
      <tr>
        <th style="width: 10%;">번호(idx)</th>
        <th>제목</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in boardList" :key="item.idx">
        <td style="text-align: center;">{{ item.idx }}</td>
        <td @click="$router.push(`/board/${item.idx}`)" style="cursor:pointer; padding-left: 10px;">
          {{ item.title }}
        </td>
      </tr>
      <tr v-if="boardList.length === 0">
        <td colspan="2" style="text-align: center; padding: 20px;">게시글이 없습니다.</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';

const boardList = ref([]);

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/board/list');
    boardList.value = response.data;
  } catch (error) {
    console.error("데이터 로딩 실패:", error);
  }
});
</script>
