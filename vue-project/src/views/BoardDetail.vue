<template>
  <div class="container" v-if="post">
    <h2>게시글 상세 정보</h2>
    <div style="border: 1px solid #ccc; padding: 20px; margin-bottom: 20px;">
      <h3>제목: {{ post.title }}</h3>
      <hr>
      <p style="min-height: 100px;">{{ post.content }}</p>
    </div>
    <button @click="$router.push('/board/list')">목록보기</button>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const post = ref(null);

onMounted(async () => {
  const idx = route.params.idx;
  try {
    const response = await axios.get(`http://localhost:8080/board/${idx}`);
    post.value = response.data;
  } catch (error) {
    alert("게시글을 찾을 수 없습니다.");
    router.push('/board/list');
  }
});
</script>
