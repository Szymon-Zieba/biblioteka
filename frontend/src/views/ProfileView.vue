<script>
import ProfileSidebar from "@/components/ProfileSidebar.vue";
import MainHeader from "@/components/MainHeader.vue";
import { computed } from "@vue/runtime-core";
import ProfileDetails from "@/components/ProfileDetails.vue";
import { ref } from "vue";
export default {
  components: { MainHeader, ProfileSidebar, ProfileDetails },
  setup() {
    const sidebarWidth = 256;
    const style = computed(() => {
      return "margin-left: " + sidebarWidth + "px !important;";
    });

    let selected = ref("details");

    const onSelected = (value) => {
      selected.value = value;
    };

    return {
      sidebarWidth,
      style,
      selected,
      onSelected,
    };
  },
};
</script>

<template>
  <main-header></main-header>

  <profile-sidebar
    @child-to-parent="onSelected"
    :width="sidebarWidth"
    class="sidebar"
  ></profile-sidebar>
  <v-container class="content" :style="style">
    <profile-details v-if="selected === 'details'"></profile-details>
    <loans-details v-if="selected === 'loans'"></loans-details>
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
