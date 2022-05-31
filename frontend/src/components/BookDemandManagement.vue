<script>
import AddBookFromBookDemandingPopup from './AddBookFromBookDemandingPopup.vue';
import { computed } from "vue";
import useBooks from "../composables/useBooks.js"
import { addBook, updateBook } from '../services/book.service.js'
export default {
  components: { AddBookFromBookDemandingPopup },

name:"BookDemandManegment",
props: ["role"],
    setup(){
      const showScheduleForm = false;

      const {books, loadBooks} = useBooks()
      
      loadBooks()

      const demands = computed(() => {
        return books.value.filter((book) =>
          book.status === "IN_DEMAND")  
      })

      function authorNameLastName(authors){
        return authors.map(author => author.name + ' ' + author.lastName).join(', ')
      }
      const statusDelete = "NOT_AVAILABLE"
      const statusAdd = "IN_STOCK"

      async function updateBookFunction(id, status){
        await updateBook(id, status)

        loadBooks()
      } 

     return { 
      demands,
      showScheduleForm,
      authorNameLastName,
      addBook,
      statusDelete,
      statusAdd,
      updateBookFunction
    }
    }
    }
</script>

<template>
  <div class="main">

    <v-table theme="light">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Tytuł</th>
          <th class="text-left">Autorzy</th>
          <th class="text-left">Rok publikacji</th>
          <th class="text-left">Wydawnictwo</th>
          <th class="text-left">Kategoria</th>
          <th class="text-left">Opis</th>
          <th class="text-left">Zdjęcie</th>
        </tr>
      </thead>
      <tbody>
        <tr
          style="margin-top: 50px"
          v-for="demand in demands"
          :key="demand"
        >
          <td>{{ demand.id }}</td>
          <td>{{ demand.title }}</td>
          <td>{{ authorNameLastName(demand.author) }}</td>
          <td>{{ demand.publishmentYear }}</td>
          <td>{{ demand.publishmentHouse.name }}</td>
          <td>{{ demand.category.name }}</td>
          <td>{{ demand.description.substring(0,20) + '...' }}</td>
          <td><img :src="demand.imgUrl"></td>
          <td v-if="role === `ROLE_HEADADMIN` || role === `ROLE_ADMIN`"><v-btn class="button" @click="updateBookFunction(demand.id, statusDelete)" color="red">Usun</v-btn></td>
          <td v-if="role === `ROLE_HEADADMIN`"><v-btn class="button" @click="updateBookFunction(demand.id, statusAdd)" color="blue">Dodaj</v-btn></td>
        </tr>
        
      </tbody>
    </v-table>
    <div class="center-button">
      <AddBookFromBookDemandingPopup  :role="role" v-model="showScheduleForm"/>
    </div>
  </div>
</template>

<style scoped>
  .main {
    padding: 2rem;
    max-width: 90%;
  }
  .center-button{
    margin-top: 2rem;
    display: flex;
    justify-content: center;
  }
</style>
