<script>
import EmployeeMenu from "@/components/EmployeeMenu.vue";
import MainHeader from "@/components/MainHeader.vue";
import { computed } from "@vue/runtime-core";
import AboutClients from '@/components/AboutClients.vue';
export default {
  components: { MainHeader, EmployeeMenu, AboutClients },
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

  <v-container
    class="content"
    style="margin-top: 6rem !important"
    :style="style"
  >
    <about-clients style="position: relative" />
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
