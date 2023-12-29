import { createRouter, createWebHistory } from 'vue-router'
import Index from '../views/Index.vue'
import Dashboard from '../views/Dashboard.vue'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'
import Leftbar from '../views/Leftbar.vue'
import Mainboard from '../views/Mainboard.vue'

const routes = [
  {
    path: '/',
    name: 'index',
    component: Index,
    meta: { darkMode: true },
  },
  {
    path: '/leftbar',
    name: 'leftbar',
    component: Leftbar,
    meta: { darkMode: true },
  },
  {
    path: '/mainboard',
    name: 'mainboard',
    component: Mainboard,
    meta: { darkMode: true },
  },
  {
    path: '/signup',
    name: 'signup',
    component: Signup,
    meta: { darkMode: true },
  },
  {
    path: '/login/:widthPercentage?',
    name: 'login',
    component: Login,
    meta: { darkMode: true },
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: Dashboard,
    meta: { darkMode: true },
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
