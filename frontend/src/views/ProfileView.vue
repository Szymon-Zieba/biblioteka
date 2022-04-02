<script>
import ProfileSidebar from "@/components/ProfileSidebar.vue";
import MainHeader from "@/components/MainHeader.vue";
import { computed } from "@vue/runtime-core";
export default {
  components: { MainHeader, ProfileSidebar },
  setup() {
    const sidebarWidth = 256;
    const style = computed(() => {
      return "margin-left: " + sidebarWidth + "px !important;";
    });

    return {
      sidebarWidth,
      style,
    };
  },
};
</script>

<template>
  <main-header></main-header>

  <profile-sidebar :width="sidebarWidth" class="sidebar"></profile-sidebar>
  <v-container class="content" :style="style"> </v-container>
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
