<script>
import { ref, computed } from "vue";
import { getUsers } from "@/services/user.service";
export default {
  setup() {
    const clients = ref([]);

    const loadClients = async () => {
      clients.value = await getUsers();
    };
    loadClients();

    const search = ref("");

    const filteredList = computed(() => {
      return clients.value.filter((client) =>
        (client.pesel + client.email)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
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

    <v-table theme="light">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Imie</th>
          <th class="text-left">Nazwisko</th>
          <th class="text-left">Email</th>
          <th class="text-left">Pesel</th>
          <th class="text-left">Zaawansowane opcje</th>
        </tr>
      </thead>
      <tbody>
        <tr
          style="margin-top: 50px"
          v-for="client in filteredList"
          :key="client"
        >
          <td>{{ client.id }}</td>
          <td>{{ client.firstName }}</td>
          <td>{{ client.lastName }}</td>
          <td>{{ client.email }}</td>
          <td>{{ client.pesel }}</td>
          <td>
            <v-btn :to="`/client/${client.id}`">Szczegóły</v-btn>
          </td>
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
