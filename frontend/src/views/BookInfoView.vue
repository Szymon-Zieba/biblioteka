<script>
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import ReservationPopup from "@/components/ReservationPopup.vue";
import useBooks from "../composables/useBooks.js";
import { useRoute } from "vue-router";
import { useAuth } from "../store/auth";
export default {
  components: { MainHeader, MainFooter, ReservationPopup },
  setup() {

     const auth = useAuth();
     const id = auth.user.id;

    const route = useRoute();
    const { book, loadBookById } = useBooks();

    console.log(route.params);
    loadBookById(route.params.id);

    function authorNameLastName(authors) {
      return authors
        .map((author) => author.name + " " + author.lastName)
        .join(", ");
    }

    const selected = "0";
    const showScheduleForm = false;
    const isAvible = (quantity) => {
      if (quantity <= 0) return false;
      else return true;
    };

    return {
      id,
      authorNameLastName,
      book,
      selected,
      isAvible,
      showScheduleForm,
    };
  },
};
</script>

<template>
  <MainHeader style="background: #795548" />

  <div v-if="book" class="container">
    <img :src="`${book.imgUrl}`" class="book-img" />

    <div class="book-details">
      <div class="book-title">{{ book.title }}</div>
      <div class="book-author">{{ authorNameLastName(book.author || []) }}</div>
      <div class="book-genre">{{ book.category.name }}</div>
      <div class="book-description">{{ book.description }}</div>
      <div class="book-localization">Lokalizacja : {{ book.library.city }}</div>
      <div class="book-reservation">
        <ReservationPopup
          v-model="showScheduleForm"
          :bookId="book.id"
          :libraryId="book.library.id"
          :userId="id"   
        ></ReservationPopup>
      </div>
    </div>
  </div>

  <MainFooter />
</template>

<style scoped>
.container {
  position: relative;
  width: 100vw;
  background: #efebe9;
  display: flex;
  padding-top: 8rem;
  padding-bottom: 2rem;
  justify-content: center;
  flex-direction: row;
}

.book-img {
  width: 30rem;
  height: 75vh;
}

.book-details {
  overflow-wrap: break-word;
  white-space: pre-line;
  background-color: #efebe9;
  flex-direction: column;
  display: flex;
  width: 60rem;
  overflow-y: auto;
  overflow-x: hidden;
  background-color: white;
  height: 75vh;
}

.book-details * {
  margin-left: 20px;
}

.book-genre {
  font-weight: bold;
}

.book-author {
  margin-top: 20px;
  font-size: 1.5rem;
}
.book-title {
  font-size: 2.5rem;
}
.book-localization {
  margin-top: 20px;
}

.book-description {
  margin-top: 20px;
}

.book-reservation {
  position: absolute;
  bottom: 0;
  left: 56.5%;
}
</style>
