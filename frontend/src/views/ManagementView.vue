<script>
import EmployeeMenu from "@/components/EmployeeMenu.vue";
import MainHeader from "@/components/MainHeader.vue";
import { computed } from "@vue/runtime-core";
import { ref } from "vue";
import AboutClients from "@/components/AboutClients.vue";
import BookDemandManagement from "@/components/BookDemandManagement.vue";
import AdminBookManagement from "@/components/AdminBookManagement.vue"; 
import EmployeeManagement from "@/components/EmployeeManagement.vue";
import LibraryManagment from '@/components/LibraryManagment.vue';
import HiresManagement from '@/components/HiresManagement.vue';

export default {
  components: {
    MainHeader,
    EmployeeMenu,
    AboutClients,
    BookDemandManagement,
    AdminBookManagement,
    EmployeeManagement,
    LibraryManagment,
    HiresManagement
  },
  setup() {
    const sidebarWidth = 256;
    const style = computed(() => {
      return "margin-left: " + sidebarWidth + "px !important;";
    });

    const selected = ref("clients");

    const onSelected = (value) => {
      selected.value = value;
    };

    const user = {
      role: JSON.parse(localStorage.getItem("user")).role.name
    };

    return {
      onSelected,
      selected,
      user,
      sidebarWidth,
      style,
    };
  },
};
</script>

<template>
  <main-header></main-header>
  <EmployeeMenu
    @select-content="onSelected"
    :role="user.role"
    :width="sidebarWidth"
    class="sidebar"
  />

  <v-container
    class="content"
    style="margin-top: 6rem !important"
    :style="style"
  >
    <about-clients v-if="selected === `clients`" style="position: relative" />
    <BookDemandManagement
      :role="user.role"
      v-if="selected === `demands`"
      style="position: relative"
    />
    <AdminBookManagement
      :role="user.role"
      v-if="selected === `books`"
      style="position: relative"
    />
    <EmployeeManagement
      v-if="selected === `employees`"
      style="position: relative"
    />
    <LibraryManagment
      v-if="selected === `libraries`"
      style="position: relative"
    />
     <HiresManagement
      v-if="selected === `hires`"
      style="position: relative"
    />
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
