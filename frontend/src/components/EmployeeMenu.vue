<script>
export default {
  name: "EmployeeMenu",
  props: ["role"],

  setup(props, context) {
    const emitToParent = () => {
      context.emit("select-content");
    };

    console.log(props.role);
    return {
      emitToParent,
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
          v-if="props.role === `ROLE_EMPLOYEE`"
          nav
          style="background: inherit"
        >
          <v-list-item
            prepend-icon="mdi-account-group"
            title="Klienci"
            @click="$emit('select-content', 'clients')"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-basket"
            title="Wypożyczenia"
            @click="$emit('select-content', 'hires')"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-book-search"
            title="Rejestr zapotrzebowania"
            @click="$emit('select-content', 'demands')"
          >
          </v-list-item>
        </v-list>

        <!-- Menu admina -->
        <v-list v-if="props.role === `ROLE_ADMIN`" nav style="background: inherit">
          <v-list-item
            prepend-icon="mdi-account-group"
            title="Klienci"
            @click="$emit('select-content', 'clients')"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-account-multiple"
            title="Pracownicy"
            @click="$emit('select-content', 'employees')"
          ></v-list-item>
          <v-list-item prepend-icon="mdi-basket" title="Wypożyczenia">
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-book-search"
            title="Rejestr zapotrzebowania"
            @click="$emit('select-content', 'demands')"
          >
          </v-list-item>
        </v-list>

        <!-- Menu head admina -->
        <v-list
          v-if="props.role === `ROLE_HEADADMIN`"
          nav
          style="background: inherit"
        >
          <v-list-item
            prepend-icon="mdi-account-group"
            title="Klienci"
            @click="$emit('select-content', 'clients')"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-account-multiple"
            title="Pracownicy"
            @click="$emit('select-content', 'employees')"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-basket"
            title="Wypożyczenia"
            @click="$emit('select-content', 'hires')"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-book-search"
            title="Rejestr zapotrzebowania"
            @click="$emit('select-content', 'demands')"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-bookshelf"
            title="Biblioteki"
            @click="$emit('select-content', 'libraries')"
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
