import { getBooks } from "../services/book.service";
import { ref } from "vue";

export default function useBooks() {
  const books = ref([]);

  const loadBooks = async () => {
    books.value = await getBooks();
  };
  return { books, loadBooks };
}
