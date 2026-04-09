<template>
  <div class="container">
    <h2>게시글 등록</h2>
    <div style="display: flex; flex-direction: column; gap: 10px;">
      <input v-model="form.title" placeholder="제목을 입력하세요" style="padding: 10px;" />
      <textarea v-model="form.content" placeholder="내용을 입력하세요" rows="10" style="padding: 10px;"></textarea>
      <button @click="handleSave" style="padding: 10px; background-color: #4CAF50; color: white; border: none; cursor: pointer;">
        저장
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const router = useRouter();
const form = ref({ title: '', content: '' });

const handleSave = async () => {
  if (!form.value.title || !form.value.content) {
    alert("제목과 내용을 입력해주세요.");
    return;
  }

  try {
    const response = await axios.post('http://localhost:8080/board/reg', form.value);
    if (response.status === 201 || response.data.status === "success") {
      alert("게시글이 성공적으로 등록되었습니다.");
      router.push('/board/list');
    }
  } catch (error) {
    alert("등록 중 오류가 발생했습니다.");
    console.error(error);
  }
};
</script>
