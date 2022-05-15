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
  <v-row justify="center" style="box-shadow: 0 0 0 black">
    <v-dialog v-model="dialog" persistent>
      <template v-slot:activator="{ props }">
        <v-btn color="green" v-bind="props"> Dodaj Książkę do bazy </v-btn>
      </template>
      <v-card class="pa-15">
        <v-card-title class="text-h5">
          Podaj dane Książki którą chcesz dodać.
        </v-card-title>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            v-model="title"
            label="Tytuł"
            required
          ></v-text-field>

          <v-text-field
            v-model="author"
            label="Autorzy"
            required
          ></v-text-field>

          <v-text-field 
            v-model="publishmentYear" 
            label="Rok publikacji" 
            required>
          </v-text-field>

          <v-text-field
            v-model="publishmentHouse"
            label="Wydawnitwo"
            required
          ></v-text-field>

          <v-text-field
            v-model="category"
            label="Kategoria"
            required
          ></v-text-field>

          <v-text-field
            v-model="description"
            label="Opis"
            required
          ></v-text-field>

          <v-text-field
            v-model="imgUrl"
            label="Adress zdjęcia"
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
            Zapisz książkę
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<style scoped>
</style>
