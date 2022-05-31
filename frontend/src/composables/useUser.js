import { getUserById } from "../services/user.service";
import { ref } from "vue";

export default function useUser(id) {
  const user = ref();

  const loadUser = async () => {
    user.value = await getUserById(id);
  };
  return { user, loadUser };
}
