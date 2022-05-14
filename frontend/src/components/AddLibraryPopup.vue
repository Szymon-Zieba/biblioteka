<script>
export default {
  data() {
    return {
      dialog: false,
    };
  },
};
</script>

<template>
  <v-row justify="center" class="mb-15" style="box-shadow: 0 0 0 black">
    <v-dialog v-model="dialog" persistent>
      <template v-slot:activator="{ props }">
        <v-btn v-bind="props"> Dodaj bibliotekę </v-btn>
      </template>
      <v-card class="pa-15">
        <v-card-title class="text-h5">
          Podaj dane biblioteki, którą chcesz dodac.
        </v-card-title>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            v-model="city"
            label="Miasto"
            required
          ></v-text-field>

          <v-text-field
            v-model="streetAndNumber"
            label="Ulica i numer"
            required
          ></v-text-field>

          <v-text-field v-model="email" label="E-mail" required></v-text-field>

          <v-text-field
            v-model="postCode"
            label="Kod pocztowy"
            required
          ></v-text-field>

          <v-text-field
            v-model="phoneNumber"
            label="Numer telefonu"
            required
          ></v-text-field>

          <v-checkbox
            v-model="checkbox"
            :rules="[(v) => !!v || 'You must agree to continue!']"
            label="Potwierdz, aby zapisać"
            required
          ></v-checkbox>
        </v-form>
        <v-card-actions class="mt-16">
          <v-spacer></v-spacer>
          <v-btn color="orange" text @click="dialog = false"> Reset </v-btn>
          <v-btn color="orange" text @click="dialog = false"> Wyjdź </v-btn>
          <v-btn color="orange" text @click="dialog = false">
            Zapisz biblioteke
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
