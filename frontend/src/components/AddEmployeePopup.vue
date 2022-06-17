<script>
import { ref } from "vue";
import {addEmployee} from "../services/employee.service"

export default {
  setup() {

    const dialog = ref(false)

    const employee = ref({
      firstName: null,
      pesel: null,
      lastName: null,
      city: null,
      streetNumber: null,
      email: null,
      zip: null,
      phoneNumber: null,
    })
  
    return {
      employee,
      addEmployee,
      dialog,
    };
  },
};
</script>

<template>
  <v-row justify="center" class="mb-15" style="box-shadow: 0 0 0 black">
    <v-dialog v-model="dialog" persistent>
      <template v-slot:activator="{ props }">
        <v-btn v-bind="props"> Dodaj pracownika </v-btn>
      </template>
      <v-card class="pa-15">
        <v-card-title class="text-h5">
          Podaj dane pracownika, ktorego chcesz dodac.
        </v-card-title>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            v-model="employee.firstName"
            label="Imie"
            required
          ></v-text-field>

          <v-text-field
            v-model="employee.lastName"
            label="Nazwisko"
            required
          ></v-text-field>

          <v-text-field v-model="employee.email" label="E-mail" required></v-text-field>

          <v-text-field
            v-model="employee.phoneNumber"
            label="Telefon"
            required
          ></v-text-field>

          <v-text-field
            v-model="employee.streetNumber"
            label="Adres"
            required
          ></v-text-field>

          <v-text-field
            v-model="employee.zip"
            label="Kod pocztowy"
            required
          ></v-text-field>

          <v-text-field v-model="employee.city" label="Miasto" required></v-text-field>

          <v-text-field v-model="employee.pesel" label="Pesel" required></v-text-field>

        </v-form>
        <v-card-actions class="mt-16">
          <v-spacer></v-spacer>
          <v-btn color="orange" text @click="dialog = false"> Reset </v-btn>
          <v-btn color="orange" text @click="dialog = false"> Wyjdź </v-btn>
          <v-btn color="orange" text @click="addEmployee(employee)">
            Zapisz pracownika
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
