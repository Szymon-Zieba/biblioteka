<script>
export default {
  name: "MainHeader",
  setup() {
    // Jeśli user === null wyświetla wersję dla niezalogowanego
    // W przeciwnym wypadku wyświetla wersję dla zalogowanego
    // Jeśli zalogowany user ma role EMPLOYEE/ADMIN/HEADADMIN wyświetla przycisk panelu zarządania

    //const user = null;
    const user = {
      role: "ADMIN",
    };

    const isEntitledFunction = () => {
      if (user) {
        return (
          user.role === "EMPLOYEE" ||
          user.role === "ADMIN" ||
          user.role === "HEADADMIN"
        );
      } else {
        return false;
      }
    };

    const isEntitled = isEntitledFunction();

    console.log(user);
    console.log(isEntitled);

    return {
      user,
      isEntitled,
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
        v-if="isEntitled"
        elevation="0"
        color="transparent"
        style="color: red"
        >PANEL ZARZĄDZANIA</v-btn
      >
      <v-btn to="/books" tile elevation="0" color="transparent">OFERTA</v-btn>
      <v-btn tile elevation="0" color="transparent">KONTAKT</v-btn>
      <v-btn v-if="user === null" to="/login" elevation="0" color="transparent">
        LOGOWANIE
      </v-btn>
      <v-btn
        v-if="user === null"
        to="/register"
        elevation="0"
        color="transparent"
      >
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
              <v-list-item-title>Wyloguj</v-list-item-title>
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
}

#header-menu {
  color: white;
}
</style>
