<script>
import { ref } from "vue";
import { useAuth } from "../store/auth";
import { useRouter } from "vue-router";

export default {
  name: "MainHeader",
  setup() {
    const auth = useAuth();
    const loggedIn = ref(auth.status.loggedIn);
    const user = ref(auth.user);

    const router = useRouter();

    const isEntitledFunction = () => {
      if (user.value) {
        return (
          user.value.role.name === "ROLE_EMPLOYEE" ||
          user.value.role.name === "ROLE_ADMIN" ||
          user.value.role.name === "ROLE_HEADADMIN"
        );
      } else {
        return false;
      }
    };

    const isEntitled = isEntitledFunction();

    function logout() {
      auth.logout();
      router.push({ name: "home" });
    }

    return {
      user,
      isEntitled,
      loggedIn,
      logout,
    };
  },
};
</script>

<template>
  <header>
    <router-link to="/">
      <v-img
        src="@/assets/img/logo-library.png"
        width="6.6rem"
        height="6rem"
      ></v-img>
    </router-link>

    <v-spacer />
    <v-item-group id="header-menu">
      <v-btn
        to="/management"
        v-if="loggedIn && isEntitled"
        elevation="0"
        color="transparent"
        style="color: red"
        >PANEL ZARZĄDZANIA</v-btn
      >
      <v-btn to="/books" tile elevation="0" color="transparent">OFERTA</v-btn>
      <v-btn to="contact" tile elevation="0" color="transparent">KONTAKT</v-btn>
      <v-btn v-if="!loggedIn" to="/login" elevation="0" color="transparent">
        LOGOWANIE
      </v-btn>
      <v-btn v-if="!loggedIn" to="/register" elevation="0" color="transparent">
        REJESTRACJA
      </v-btn>
      <v-btn
        append-icon="mdi-chevron-down"
        v-else
        elevation="0"
        color="transparent"
      >
        Konto
        <v-menu activator="parent">
          <v-list nav>
            <v-list-item to="/profile">
              <v-list-item-title>Szczegóły konta</v-list-item-title>
            </v-list-item>
            <v-list-item>
              <v-list-item-title @click="logout()">Wyloguj</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-btn>
    </v-item-group>
  </header>
</template>

<style>
header {
  background: rgba(0, 0, 0, 30%);
  height: 6rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
  color: white;
  padding: 0 3rem 0 3rem;
  position: fixed;
  width: 100%;
  z-index: 999;
}

#header-menu {
  color: white;
}
</style>
