<script>
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import { ref, computed } from "vue";
import useBooks from "../composables/useBooks.js"

export default {
  components: { MainHeader, MainFooter },
  setup() {

    const {books, loadBooks} = useBooks()
    
    loadBooks()
    const search = ref("");


    const filteredList = computed(() => {
      return books.value.filter((book) =>
        (book.title + book.genre)
          .toLowerCase()
          .includes(search.value.toLowerCase()) &&
       book.status === "IN_STOCK") 
    });

    return {
      filteredList,
      search,
    };
  },
};
</script>

<template>
  <div style="padding-top: 6rem !important" fill-height class="container">
    <MainHeader style="margin-top: -6rem !important; background: #795548" />
    <v-container>
      <v-text-field
        variant="outlined"
        prepend-icon="mdi-magnify"
        v-model="search"
        label="Tytuł/Gatunek"
      >
      </v-text-field>

      <v-row cols="12">
        <v-col
          v-for="book in filteredList"
          :key="book"
          xl="2"
          lg="3"
          md="4"
          sm="4"
          xs="6"
        >
          <v-card elevation="1" class="book-card">
            <router-link to="/book">
              <v-img
                class="book-img"
                cover
                :src="book.imgUrl"
              >
                <div class="book-img-overlay">
                  <span class="book-img-overlay-button">Szczegóły</span>
                </div>
              </v-img>
            </router-link>
            <v-card-title> {{ book.title }} </v-card-title>
            <v-card-subtitle class="text-subtitle-1">
              {{ book.author }}
            </v-card-subtitle>
            <v-card-subtitle class="text-subtitle-2 mt-2">
              Gatunek: {{ book.genre }}
            </v-card-subtitle>
            <v-card-text class="text-caption"> {{ book.text }} </v-card-text>
            <v-card-actions style="justify-content: end">
              <v-btn to="/book" size="small" append-icon="mdi-chevron-right"
                >Szczegóły</v-btn
              >
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <MainFooter />
  </div>
</template>

<style scoped>
.book-img-overlay {
  display: flex;
  position: absolute;
  background: black;
  opacity: 0%;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
}

.book-img-overlay:hover {
  opacity: 75%;
}

.container {
  background: #efebe9;
}

.book-img-overlay-button {
  color: white;
}
</style>
