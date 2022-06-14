import { getGiveBacksByUserId } from "../services/giveback.service";
import { ref } from "vue";
import { useAuth } from "../store/auth";

export default function useGiveBacks() {
  const giveBacks = ref([]);

  const auth = useAuth();
  const id = auth.user.id;

  const loadGiveBacks = async () => {
    giveBacks.value = await getGiveBacksByUserId(id);
  };
  return { giveBacks, loadGiveBacks };
}
