<script>
import { ref } from "vue";

export default {
  setup() {
    return {
      tab: ref(null),
      user: ref({
        firstName: "Jan",
        lastName: "Kowalski",
        email: "jankowalski@gmail.com",
        phone: "123456789",
        street: "Cicha 2/704",
        zip: "35-326",
        city: "Rzeszów",
        pesel: "12345678999",
      }),
    };
  },
};
</script>

<template>
  <v-container>
    <v-tabs v-model="tab">
      <v-tab value="details">Dane osobowe</v-tab>
      <v-tab value="address">Adres</v-tab>
      <v-tab value="privacy">Prywatność</v-tab>
    </v-tabs>
    <v-window v-model="tab" justify="center" align="center">
      <!-- DANE OSOBOWE -->
      <v-window-item value="details">
        <v-form class="pt-12" style="width: 500px">
          <v-text-field
            v-model="user.firstName"
            variant="underlined"
            label="Imię"
          ></v-text-field>
          <v-text-field
            v-model="user.lastName"
            variant="underlined"
            label="Nazwisko"
          ></v-text-field>
          <v-text-field
            v-model="user.email"
            variant="underlined"
            label="Email"
          ></v-text-field>
          <v-text-field
            v-model="user.phone"
            variant="underlined"
            label="Numer telefonu"
          ></v-text-field>
        </v-form>
        <v-btn class="save-button mx-4" size="x-large">ZAPISZ</v-btn>
        <v-btn class="cancel-button mx-4" size="x-large">ANULUJ</v-btn>
      </v-window-item>
      <!-- ADRES -->
      <v-window-item value="address">
        <v-form class="pt-12" style="width: 500px">
          <v-text-field
            v-model="user.street"
            variant="underlined"
            label="Ulica i numer"
          ></v-text-field>
          <v-text-field
            v-model="user.zip"
            variant="underlined"
            label="Kod pocztowy"
          ></v-text-field>
          <v-text-field
            v-model="user.city"
            variant="underlined"
            label="Miasto"
          ></v-text-field>
        </v-form>
        <v-btn class="save-button mx-4" size="x-large">ZAPISZ</v-btn>
        <v-btn class="cancel-button mx-4" size="x-large">ANULUJ</v-btn>
      </v-window-item>
      <!-- PRYWATNOŚĆ -->
      <v-window-item value="privacy">
        <v-form class="pt-12" style="width: 500px">
          <v-text-field
            type="password"
            variant="underlined"
            label="Nowe hasło"
          ></v-text-field>
          <v-text-field
            type="password"
            variant="underlined"
            label="Powtórz nowe hasło"
          ></v-text-field>
          <v-text-field
            v-model="user.pesel"
            variant="underlined"
            label="PESEL"
          ></v-text-field>
          <v-divider class="my-4"></v-divider>
          <span class="text-caption"
            >Podaj aktualne hasło, aby zapisać zmiany.</span
          >
          <v-text-field
            variant="underlined"
            label="Aktualne hasło"
          ></v-text-field>
        </v-form>
        <v-btn class="save-button mx-4" size="x-large">ZAPISZ</v-btn>
        <v-btn class="cancel-button mx-4" size="x-large">ANULUJ</v-btn>
      </v-window-item>
    </v-window>
  </v-container>
</template>

<style scoped>
.save-button {
  background-color: rgb(23, 201, 100);
}

.cancel-button {
  background-color: rgb(210, 210, 210);
}
</style>
