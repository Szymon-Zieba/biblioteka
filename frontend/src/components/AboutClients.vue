<script>
import { ref, reactive, computed } from "vue"
export default {
  setup() {
    const showScheduleForm = false

    const clients = reactive([
        {name:'Asia', lastName:'Asia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Kasia', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Mariola', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Karol', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Ktos', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'}   
    ])
    const search = ref("")

    const filteredList = computed(() => {
      return clients.filter((client) =>
        (client.name + client.lastName)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      )
    })
    return {
      showScheduleForm,
      clients,
      search,
      filteredList,
    };
  },
}
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
          <td>{{ client.email }}</td>
          <td>{{ client.pesel }}</td>
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
