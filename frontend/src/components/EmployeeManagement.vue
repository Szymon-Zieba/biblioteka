<script>
import AddEmployeePopup from "@/components/AddEmployeePopup.vue";
import { ref, reactive, computed } from "vue";
export default {
  components: { AddEmployeePopup },
  setup() {
    const showScheduleForm = false;

    const clients = reactive([
      {
        name: "Asia",
        lastName: "Asia",
        phoneNumber: "213412123",
        streetNumber: "Cicha 2",
        zip: "35-202",
        city: "Rzeszow",
        pesel: "213412123",
        email: "jatoty@gamil.com",
        role: "EMPLOYEE",
      },
      {
        name: "Asia",
        lastName: "Asia",
        phoneNumber: "213412123",
        streetNumber: "Cicha 2",
        zip: "35-202",
        city: "aasdasdasdasdasdasdas",
        pesel: "213412123",
        email: "jatoty@gasssmil.com",
        role: "EMPLOYEE",
      },
    ]);
    const search = ref("");

    const filteredList = computed(() => {
      return clients.filter((client) =>
        (client.name + client.lastName)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
      showScheduleForm,
      clients,
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
          v-for="(client, index) in filteredList"
          :key="client"
        >
          <td>{{ index }}</td>
          <td>{{ client.name }}</td>
          <td>{{ client.lastName }}</td>
          <td>{{ client.phoneNumber }}</td>
          <td>{{ client.streetNumber }}</td>
          <td>{{ client.zip }}</td>
          <td>{{ client.city }}</td>
          <td>{{ client.pesel }}</td>
          <td><v-btn color="red">Usun</v-btn></td>
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
