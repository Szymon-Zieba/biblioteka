<script>
import AddLibraryPopup from "@/components/AddLibraryPopup.vue";
import { ref, computed } from "vue";
import {getLibraries, deleteLibraryById} from "../services/library.service"

export default {
  components: { AddLibraryPopup },
  setup() {

  const libraries = ref({})
  const loadLibraries = async () =>{
     libraries.value = await getLibraries()
  }

  loadLibraries()

  console.log(libraries.value)

    const showScheduleForm = false;

  
    const search = ref("");

    const filteredList = computed(() => {
      return libraries.value.filter((library) =>
        (library.city + library.streetAndNumber)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
      deleteLibraryById,
      showScheduleForm,
      libraries,
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
      label="Wpisz miasto lub ulice"
    >
    </v-text-field>

    <AddLibraryPopup v-model="showScheduleForm" />
    <v-table theme="light">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Miasto</th>
          <th class="text-left">Ulica i numer</th>
          <th class="text-left">Adres pocztowy</th>
          <th class="text-left">Telefon</th>
          <th class="text-left">Email</th>
        </tr>
      </thead>

      <tbody>
        <tr
          style="margin-top: 50px"
          v-for="(library) in filteredList"
          :key="library"
        >
          <td>{{ library.id }}</td>
          <td>{{ library.city }}</td>
          <td>{{ library.streetAndNumber }}</td>
          <td>{{ library.postCode }}</td>
          <td>{{ library.phoneNumber }}</td>
          <td>{{ library.email }}</td>
          <td><v-btn @click="deleteLibraryById(library.id)" color="red">Usun</v-btn></td>
    
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
