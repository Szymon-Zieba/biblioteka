<script>
export default {
  name: "EmployeeMenu",
  props: ["role"],

  setup(props) {
    console.log(props.role);
    return {
      props,
    };
  },
};
</script>

<template>
  <!-- Renderowanie komponentow w zaleznosci od roli -->
  <v-card>
    <v-layout>
      <v-navigation-drawer
        :width="props.width"
        permanent
        style="background: burlywood"
      >
        <!-- Menu pracownika -->
        <v-list
          v-if="props.role === `EMPLOYEE`"
          nav
          style="background: inherit"
        >
          <v-list-item prepend-icon="mdi-account-group" title="Klienci">
          </v-list-item>
          <v-list-item prepend-icon="mdi-basket" title="Wypożyczenia">
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-book-search"
            title="Rejestr zapotrzebowania"
          >
          </v-list-item>
        </v-list>

        <!-- Menu admina -->
        <v-list v-if="props.role === `ADMIN`" nav style="background: inherit">
          <v-list-item prepend-icon="mdi-account-group" title="Klienci">
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-account-multiple"
            title="Pracownicy"
          ></v-list-item>
          <v-list-item prepend-icon="mdi-basket" title="Wypożyczenia">
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-book-search"
            title="Rejestr zapotrzebowania"
          >
          </v-list-item>
        </v-list>

        <!-- Menu head admina -->
        <v-list
          v-if="props.role === `HEADADMIN`"
          nav
          style="background: inherit"
        >
          <v-list-item prepend-icon="mdi-account-group" title="Klienci">
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-account-multiple"
            title="Pracownicy"
          ></v-list-item>
          <v-list-item prepend-icon="mdi-basket" title="Wypożyczenia">
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-book-search"
            title="Rejestr zapotrzebowania"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-bookshelf"
            title="Biblioteki"
          ></v-list-item>
        </v-list>

        <template v-slot:append>
          <div class="pa-2">
            <v-btn to="/" block color="brown"> Wyloguj </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
    </v-layout>
  </v-card>
</template>

<style></style>
