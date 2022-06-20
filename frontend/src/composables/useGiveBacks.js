import { getGiveBacksByUserId } from "../services/giveback.service";
import { ref } from "vue";
import { useAuth } from "../store/auth";

export default function useGiveBacks(user_id) {
  const giveBacks = ref([]);

  const auth = useAuth();
  const id = auth.user.id;

  const id_user = user_id;

  const loadGiveBacks = async () => {
    giveBacks.value = await getGiveBacksByUserId(id);
  };

  const loadGiveBacksByUserId = async () => {
    giveBacks.value = await getGiveBacksByUserId(id_user);
  };

  return { giveBacks, loadGiveBacks, loadGiveBacksByUserId };
}
