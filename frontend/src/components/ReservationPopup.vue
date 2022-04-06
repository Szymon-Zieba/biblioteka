<script>
  export default {
    data () {
      return {
        dialog: false,
      }
    },
  }
</script>

<template>
  <v-row 
   justify="center"
   class="mb-15"
   style="box-shadow: 0 0 0 black;"
  >
    <v-dialog
      v-model="dialog"
      persistent
    >
      <template v-slot:activator="{ props }">
        <v-btn 
          class="pa-7"
          color="orange"
          v-bind="props"
        >
          Rezerwuj
        </v-btn>
      </template>
      <v-card class="pa-15">
        <v-card-title class="text-h5">
          Czy na pewno chesz wypożyczyć książkę?
        </v-card-title>
        <v-card-text>Klikając przycisk "Rezerwuj" książka automatycznie zostanie przez Ciebie</v-card-text>
        <v-card-text>zarezerwowana na okres 7 dni w wybranej bibliotece</v-card-text>
        <v-card-actions
          class="mt-16">
          <v-spacer></v-spacer>
          <v-btn
            color="orange"
            text
            @click="dialog = false"
          >
            Rezerwuj
          </v-btn>
          <v-btn
            color="orange"
            text
            @click="dialog = false"
          >
            Nie chce rezerwować
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<style scoped>
 .btn-reserve{
    padding: 2rem;
  }
</style>