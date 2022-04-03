<script>
//import { ref } from "vue";

export default {
  props: ["width"],
  emits: ["select-content"],

  setup(props, context) {
    const emitToParent = () => {
      context.emit("select-content");
    };

    return {
      props,
      emitToParent,
    };
  },
};
</script>

<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer
        :width="props.width"
        permanent
        style="background: burlywood"
      >
        <v-card-title>Profil</v-card-title>
        <v-divider></v-divider>
        <v-list nav style="background: inherit">
          <v-list-item
            @click="$emit('select-content', 'details')"
            prepend-icon="mdi-account"
            title="Szczegóły konta"
          >
          </v-list-item>
          <v-list-item
            @click="$emit('select-content', 'loans')"
            prepend-icon="mdi-bookshelf"
            title="Wypożyczenia"
          ></v-list-item>
        </v-list>
        <template v-slot:append>
          <div class="pa-2">
            <v-btn to="/logout" block color="brown"> Wyloguj </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
    </v-layout>
  </v-card>
</template>

<style></style>
