import { getEmployees } from "@/services/employee.service";
import { ref } from "vue";

export default function useEmployees() {
  const employees = ref([]);

  const loadEmployees = async () => {
    employees.value = await getEmployees();
  };
  return { employees, loadEmployees };
}
