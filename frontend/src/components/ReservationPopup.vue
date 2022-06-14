<script>
import { ref } from "vue";
import { updateBook } from "../services/book.service.js";

export default {
  props: {
    bookId: Number,
  },

  setup() {
    const dialog = ref(false);
    const reserveBook = (id, status) => {
      updateBook(id, status);
      dialog.value = false;
    };

    return {
      dialog,
      reserveBook,
    };
  },
};
</script>

<template>
  <v-row justify="center" class="mb-15" style="box-shadow: 0 0 0 black">
    <v-dialog v-model="dialog" persistent>
      <template v-slot:activator="{ props }">
        <v-btn class="pa-7" v-bind="props"> {{ bookId }}</v-btn>
      </template>
      <v-card class="pa-15">
        <v-card-title class="text-h5">
          Czy na pewno chesz wypożyczyć książkę?
        </v-card-title>
        <v-card-text
          >Klikając przycisk "Rezerwuj" książka automatycznie zostanie przez
          Ciebie</v-card-text
        >
        <v-card-text
          >zarezerwowana na okres 7 dni w wybranej bibliotece</v-card-text
        >
        <v-card-actions class="mt-16">
          <v-spacer></v-spacer>
          <v-btn color="orange" text @click="reserveBook(bookId, 'RESERVED')">
            Rezerwuj
          </v-btn>
          <v-btn color="orange" text @click="dialog = false">
            Nie chce rezerwować
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<style scoped>
.btn-reserve {
  padding: 2rem;
}
</style>
