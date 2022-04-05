<script>
import EmployeeMenu from "@/components/EmployeeMenu.vue";
import MainHeader from "@/components/MainHeader.vue";
import { computed } from "@vue/runtime-core";
import AdminBookMenegment from '@/components/AdminBookMenegment.vue';
export default {
  components: { MainHeader, EmployeeMenu, AdminBookMenegment },
  setup() {
    const sidebarWidth = 256;
    const style = computed(() => {
      return "margin-left: " + sidebarWidth + "px !important;";
    });

    const user = {
      role: "HEADADMIN",
    };

    return {
      user,
      sidebarWidth,
      style,
    };
  },
};
</script>

<template>
  <main-header></main-header>
  <EmployeeMenu :role="user.role" :width="sidebarWidth" class="sidebar" />
  <v-container class="content" :style="style">
    <admin-book-menegment> </admin-book-menegment>
  </v-container>
</template>

<style>
.v-navigation-drawer {
  margin-top: 96px !important;
  height: calc(100% - 96px) !important;
}
</style>

<style scoped>
header {
  background-color: #795548;
}

.sidebar {
  top: 6rem !important;
}
</style>
