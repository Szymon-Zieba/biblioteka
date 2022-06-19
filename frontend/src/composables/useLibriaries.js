import {getLibraries} from "../services/library.service"
import {ref} from 'vue'

export default function useLibraries() {

  const libraries = ref([])
  const loadLibraries = async () => {
    libraries.value = await getLibraries();
  };

  return { libraries, loadLibraries };
}
