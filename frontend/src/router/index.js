import { createRouter, createWebHistory } from "vue-router";
import LoginView from "../views/LoginView.vue";
import RegisterView from "../views/RegisterView.vue";
import HomeView from "../views/HomeView.vue";
import BookView from "../views/BookView.vue";
import BookInfoView from "../views/BookInfoView.vue";
import ProfileView from "../views/ProfileView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
    meta: { requiresAuth: false },
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: { requiresAuth: false },
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
  },
  {
    path: "/books",
    name: "books",
    component: BookView,
    meta: { requiresAuth: false },
  },
  {
    path: '/book',
    name: 'book',
    component: BookInfoView,
    meta: { requiresAuth: false },
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    meta: { requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
