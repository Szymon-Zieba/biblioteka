import {
  getHiresByUserId,
  getHiresByUserPesel,
} from "../services/hire.service";
import { ref } from "vue";
import { useAuth } from "../store/auth";

export default function useHires(user_id) {
  const hires = ref([]);
  const hiresByPesel = ref([]);

  const auth = useAuth();
  const id = auth.user.id;

  const id_user = user_id;

  const loadHires = async () => {
    hires.value = await getHiresByUserId(id);
  };

  const loadHiresByUserId = async () => {
    hires.value = await getHiresByUserId(id_user);
  };

  const loadHiresByPesel = async (pesel) => {
    hiresByPesel.value = await getHiresByUserPesel(pesel);
  };

  return { hires, loadHires, hiresByPesel, loadHiresByPesel, loadHiresByUserId };
}
