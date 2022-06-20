<script>
import { ref, computed } from "vue";
import useBooks from "../composables/useBooks"
import {  deleteBookById } from "@/services/book.service";
export default {
  name:"AdminBookManagement",
  props: ["role"],
  setup() {

    const {books, loadBooks} = useBooks()
    loadBooks();

    const search = ref("");


     function authorNameLastName(authors){
        return authors.map(author => author.name + ' ' + author.lastName).join(', ')
      }

    const filteredList = computed(() => {
      return books.value.filter((book) =>
        (book.title + book.id )
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
      deleteBookById,
      authorNameLastName,
      books,
      search,
      filteredList,
    };
  },
};
</script>

<template>
  <div class="main">
    <v-text-field
      style="width: 95rem"
      v-model="search"
      label="Wpisz tytuł lub id książki"
    >
    </v-text-field>

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
          <th class="text-left"></th>
        </tr>
      </thead>
      <tbody>
        <tr
          style="margin-top: 50px"
          v-for="book in filteredList"
          :key="book"
        >
          <td>{{ book.id }}</td>
          <td>{{ book.title }}</td>
          <td>{{ authorNameLastName(book.author) }}</td>
          <td>{{ book.publishmentYear }}</td>
          <td>{{ book.publishmentHouse.name }}</td>
          <td>{{ book.category.name }}</td>
          <td>{{ book.description.substring(0,20) + '...' }}</td>
          <td><img style="width:130px" :src="book.imgUrl"></td>
          <td v-if="role === `ROLE_ADMIN`"><v-btn class="button" @click="deleteBookById(book.id)" color="red">Usun</v-btn></td>
        </tr>
      </tbody>
    </v-table>
  </div>
</template>

<style scoped>
.main {
  padding: 2rem;
  max-width: 102rem;
}
</style>
