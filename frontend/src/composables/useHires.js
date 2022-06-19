import {
  getHiresByUserId,
  getHiresByUserPesel,
} from "../services/hire.service";
import { ref } from "vue";
import { useAuth } from "../store/auth";

export default function useHires() {
  const hires = ref([]);
  const hiresByPesel = ref([]);

  const auth = useAuth();
  const id = auth.user.id;

  const loadHires = async () => {
    hires.value = await getHiresByUserId(id);
  };

  const loadHiresByPesel = async (pesel) => {
    hiresByPesel.value = await getHiresByUserPesel(pesel);
  };

  return { hires, loadHires, hiresByPesel, loadHiresByPesel };
}
