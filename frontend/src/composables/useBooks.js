import { getBookById, getBooks } from "../services/book.service";
import { ref } from "vue";

export default function useBooks() {
  const books = ref([]);
  const book = ref(null)

  const loadBooks = async () => {
    books.value = await getBooks();
  };

  const loadBookById= async (id) =>{
    book.value = await getBookById(id)

  }
  return { books, loadBooks, book, loadBookById };
}
