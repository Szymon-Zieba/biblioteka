<script>
import AddEmployeePopup from "@/components/AddEmployeePopup.vue";
import { ref, computed } from "vue";
import useEmployees from "../composables/useEmployees"
import {deleteEmployeeById} from "../services/employee.service"
export default {
  components: { AddEmployeePopup },
  setup() {

    const {employees, loadEmployees} = useEmployees()
    loadEmployees();
    
    const showScheduleForm = false;

    const search = ref("");

    const filteredList = computed(() => {
      return employees.value.filter((employee) =>
        (employee.name + employee.lastName)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
      deleteEmployeeById,
      employees,
      showScheduleForm,
      search,
      filteredList,
    };
  },
};
</script>

<template>
  <div class="main">
    <v-text-field
      style="width: 95rem"
      v-model="search"
      label="Wpisz Imię lub Nazwisko"
    >
    </v-text-field>

    <AddEmployeePopup v-model="showScheduleForm" />
    <v-table theme="light">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Imie</th>
          <th class="text-left">Nazwisko</th>
          <th class="text-left">Telefon</th>
          <th class="text-left">Adres</th>
          <th class="text-left">ZIP</th>
          <th class="text-left">Miasto</th>
          <th class="text-left">Pesel</th>
        </tr>
      </thead>
      <tbody>
        <tr
          style="margin-top: 50px"
          v-for="(employee) in filteredList"
          :key="employee"
        >
          <td>{{ employee.id }}</td>
          <td>{{ employee.firstName }}</td>
          <td>{{ employee.lastName }}</td>
          <td>{{ employee.phoneNumber }}</td>
          <td>{{ employee.streetNumber }}</td>
          <td>{{ employee.zip }}</td>
          <td>{{ employee.city }}</td>
          <td>{{ employee.pesel }}</td>
          <td><v-btn @click="deleteEmployeeById(employee.id)" color="red">Usun</v-btn></td>
        </tr>
      </tbody>
    </v-table>
  </div>
</template>

<style scoped>
.main {
  padding: 2rem;
  max-width: 102rem;
}
</style>
