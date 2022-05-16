<script>
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import { ref, reactive, computed } from "vue";
export default {
  components: { MainHeader, MainFooter },
  setup() {
    const books = reactive([
      {
        id: "1",
        title: "zgredek",
        author: "J.K.Rowling",
        genre: "Fantasy",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "2",
        title: "Harry Potter2",
        author: "J.K.Rowling2",
        genre: "Fantasy2",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "3",
        title: "Harry Potter3",
        author: "J.K.Rowling3",
        genre: "Fantasy3",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "4",
        title: "Harry Potter4",
        author: "J.K.Rowling4",
        genre: "Fantasy4",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "5",
        title: "Harry Potter5",
        author: "J.K.Rowling5",
        genre: "Fantasy5",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "6",
        title: "Harry Potter6",
        author: "J.K.Rowling6",
        genre: "Fantasy6",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "7",
        title: "Harry Potter7",
        author: "J.K.Rowling7",
        genre: "Fantasy4",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
      {
        id: "8",
        title: "Harry Potter8",
        author: "J.K.Rowling8",
        genre: "Fantasy4",
        text: "Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ",
        img: "../../public/img/Harry_Potter_I_Więzień_Azkabanu.png",
      },
    ]);

    const search = ref("");

    const filteredList = computed(() => {
      return books.filter((book) =>
        (book.title + book.genre)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
      books,
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
                src="../../public/img/harry-potter-kamien-filozoficzny.jpg"
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
