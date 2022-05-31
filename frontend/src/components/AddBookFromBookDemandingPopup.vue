<script>
import {ref, reactive} from 'vue'
import { addBook } from '../services/book.service.js'
export default {
  props: ["role"],
  setup(){
    let form = ref(null)
    let valid = ref(false)
    let dialog = ref(false)
    let imgFile = ref([])
    let snackbar = ref(false)

    let book = reactive({
      title: "",
      author: [
        {
        name: "",
        lastName: ""
        }
      ],
      publishmentYear: "",
      publishmentHouse: {
        name: ""
      },
      category: {
        name: ""
      },
      description: "",
    })

    const submitFormHeadAdmin = () => {
      form.value.validate().then((call) => {
        if(call.valid){
          addBook({...book, imgUrl: imgFile.value[0].name, status: "IN_STOCK"} )
          dialog.value = false
          snackbar.value = true
        }
      })    
    }

    const submitFormEmployee = () => {
      form.value.validate().then((call) => {
        if(call.valid){
          addBook({...book, imgUrl: imgFile.value[0].name, status: "IN_DEMAND"} )
          dialog.value = false
          snackbar.value = true
        }
      })    
    }

    function addInput(){
      if(book.author.length > 4){
        return
      }
      book.author.push({
        name: "",
        lastName: ""
      })
    }

    function removeInput(index){
      if(index == 0){
        return
      }
      book.author.splice(index,1)
    }  

    return {
      dialog,
      addInput,
      removeInput,
      book,
      submitFormEmployee,
      submitFormHeadAdmin,
      valid,
      form,
      imgFile,
      snackbar
    }
  }  
};

</script>

<template>
  <v-row justify="center" style="box-shadow: 0 0 0 black">
    <v-dialog v-model="dialog" persistent>
      <template v-slot:activator="{ props }">
        <v-btn color="green" v-if="role === `ROLE_HEADADMIN`"  v-bind="props"> Dodaj Książkę do bazy </v-btn>
        <v-btn color="green"  v-if="role === `ROLE_EMPLOYEE` || role === `ROLE_ADMIN`" v-bind="props"> Dodaj Książkę do rejestru zapotrzebowania </v-btn>
      </template>
      <v-card class="pa-15">
        <v-card-title class="text-h5">
          Podaj dane Książki którą chcesz dodać.
        </v-card-title>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            :rules="[v => !!v || 'Tytuł jest wymagany']"
            v-model="book.title"
            label="Tytuł"
          ></v-text-field>
          <div class="autors" v-for="(author, i) in book.author" :key="i">
            <v-text-field
              :rules="[v => !!v || 'Imie Autora ' + i + ' jest wymagane']"
              v-model="author.name"
              :label='"Imię Autora " + (i+1)'
            ></v-text-field>
            <v-text-field
              :rules="[v => !!v || 'Nazwisko Autora ' + i + ' jest wymagane']"
              v-model="author.lastName"
              :label='"Nazwisko Autora " + (i+1)'
            ></v-text-field>
            <v-icon class="autors-button" @click="addInput();" color="orange">
              mdi-plus
            </v-icon>
            <v-icon class="autors-button" @click="removeInput(i);" color="orange">
              mdi-minus
            </v-icon>
          </div>
          <v-text-field 
            v-model="book.publishmentYear" 
            label="Rok publikacji" 
            :rules="[v => !!v || 'Rok publikacji jest wymagany']"
          ></v-text-field>

          <v-text-field
            v-model="book.publishmentHouse.name"
            label="Wydawnictwo"
            :rules="[v => !!v || 'Wydawnictwo jest wymagane']"
          ></v-text-field>

          <v-text-field
            v-model="book.category.name"
            label="Kategoria"
            :rules="[v => !!v || 'Kategoria jest wymagana']"
          ></v-text-field>

          <v-text-field
            v-model="book.description"
            label="Opis"
            :rules="[v => !!v || 'Opis jest wymagany']"
          ></v-text-field>

         <v-file-input
            v-model="imgFile"
            accept="image/*"
            label="Zdjęcie"
            :rules="[v => !!v || 'Zdjęcie jest wymagane']"
          ></v-file-input>

          <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="orange" text @click="dialog = false"> Wyjdź </v-btn>
          <v-btn v-if="role === `ROLE_HEADADMIN`" color="orange" text @click="submitFormHeadAdmin()"> Zapisz książkę </v-btn>
          <v-btn v-if="role === `ROLE_EMPLOYEE` || role === `ROLE_ADMIN`" color="orange" text @click="submitFormEmployee()"> Zapisz książkę </v-btn>
        </v-card-actions>
        </v-form>
        
      </v-card> 
    </v-dialog>
    <v-snackbar
          v-model="snackbar"
        >
          Pomyślnie dodano książkę
          <template v-slot:actions>
            <v-btn
              color="pink"
              variant="text"
              @click="snackbar = false"
            >
              Zamknij
            </v-btn>
          </template>
        </v-snackbar>     
  </v-row>
</template>

<style scoped>
.autors{
  display: flex;
}
.autors-button{
  height: 3.5rem;
  width: 3.5rem;
  cursor: pointer;
}
.autors-button:hover{
  opacity:70%;
  background: rgb(196, 196, 196);
}

</style>
