<script>
import AddLibraryPopup from "@/components/AddLibraryPopup.vue";
import { ref, reactive, computed } from "vue";
export default {
  components: { AddLibraryPopup },
  setup() {
    const showScheduleForm = false;

    const libraries = reactive([
      {
        city: "Rzeszów",
        streetAndNumber: "cicha 12",
        postCode: "39-322",
        phoneNumber: "323-321-321",
        email: "email@dsa.com",
      },
      {
        city: "Rzeszów",
        streetAndNumber: "cicha 12",
        postCode: "39-322",
        phoneNumber: "323-321-321",
        email: "email@dsa.com",
      },
    ]);
    const search = ref("");

    const filteredList = computed(() => {
      return libraries.filter((library) =>
        (library.city + library.streetAndNumber)
          .toLowerCase()
          .includes(search.value.toLowerCase())
      );
    });
    return {
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
          v-for="(library, index) in filteredList"
          :key="library"
        >
          <td>{{ index }}</td>
          <td>{{ library.city }}</td>
          <td>{{ library.streetAndNumber }}</td>
          <td>{{ library.postCode }}</td>
          <td>{{ library.phoneNumber }}</td>
          <td>{{ library.email }}</td>
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
