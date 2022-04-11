<script>
  export default {
    data () {
      return {
        dialog: false,
        book: '',
      }
    },
  }
</script>

<template>
  <div class="main">
      <v-row class=""
        :align="align"
        no-gutters
      >
        <v-col class="text-h4 mt-16">
          <v-card class="pa-15">
            Wpisz książkę jaką chcesz dodać do rejerstru zapotrzebowania
          </v-card>
        </v-col>
      </v-row>
       <v-col class="mt-16">
            <v-text-field
                v-model="book"
                label="Wpisz tytuł"
            ></v-text-field> 
        </v-col>
        <v-col class="mt-10">
            <v-text-field
                v-model="book"
                label="Wpisz autora"
            ></v-text-field> 
        </v-col>
      <v-col class="button">   
        <v-dialog
            v-model="dialog"
            persistent
          >
            <template v-slot:activator="{ props }">
              <v-btn 
                class="pa-7 "
                color="brown"
                v-bind="props"
              >
                Dodaj
              </v-btn>
            </template>
            <v-card class="pa-15">
              <v-card-title class="text-h5">
                Czy na pewno chcesz dodać tę książkę do rejestru??
              </v-card-title>
              <v-card-text>Klikając przycisk "Dodaj" prześlesz odpowiedź wyżej</v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="brown"
                  text
                  @click="dialog = false"
                >
                  Dodaj
                </v-btn>
                <v-btn
                  color="brown"
                  text
                  @click="dialog = false"
                >
                  Anuluj
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-col>
    </div>
</template>

<style scoped>
    .main{
      margin-left: 5%;
      margin-right: 10%;
    }
    span{
        text-align: start;
    }
    .v-col{
        display: flex;
        justify-content: center;
    }
    .v-text-field{
        width: 100%;
    }
    .button{
      display: flex;
      justify-content: center;
    }
    .inbut{
      display: flex;
      justify-content: center;
    }
</style>