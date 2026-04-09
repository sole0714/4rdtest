import { createRouter, createWebHistory } from 'vue-router'
import BoardList from '../views/BoardList.vue'
import BoardDetail from '../views/BoardDetail.vue'
import BoardRegister from '../views/BoardRegister.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/board/list', name: 'list', component: BoardList },
    { path: '/board/:idx', name: 'detail', component: BoardDetail, props: true },
    { path: '/board/reg', name: 'register', component: BoardRegister },
    { path: '/', redirect: '/board/list' } // 기본 페이지 설정
  ]
})

export default router
