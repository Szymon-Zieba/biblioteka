<script>
import useHires from "../composables/useHires"
import {ref} from 'vue'
export default {
    setup(){

    const {hiresByPesel, loadHiresByPesel} = useHires()

    const search = ref("")
        
    console.log(hiresByPesel.value)
    return{
        hiresByPesel,
        search,
        loadHiresByPesel,
        }
    }


}
</script>


<template>
    <div class="main">
      
    <v-text-field
        variant="outlined"
        prepend-icon="mdi-magnify"
        v-model="search"
        label="Pesel"
      >
      </v-text-field>

      <v-btn style="margin-left: 45%;" @click="loadHiresByPesel(search)">Znajdz</v-btn>

    <v-table theme="light">

       
      <thead>
        <tr>
          <th class="text-left">Imie</th>
          <th class="text-left">Nazwisko</th>
          <th class="text-left">Pesel</th>
          <th class="text-left">Tytuł książki</th>
          <th class="text-left">Id ksiązki</th>
          <th class="text-left">Status</th>
          <th class="text-left"></th>
        </tr>
      </thead>
      <tbody v-if="hiresByPesel">
        <tr
          style="margin-top: 50px"
          v-for="hire in hiresByPesel"
          :key="hire"
        >
          <td>{{hire.user.firstName}}</td>
          <td>{{hire.user.lastName}}</td>
          <td>{{hire.user.pesel}}</td>
          <td>{{hire.book.title}}</td>
          <td>{{hire.book.id}}</td>
          <td style="font-weight: bold;">{{hire.status}}</td>

  
          <td> <v-btn>Usun</v-btn>
                <v-btn style="margin-left: 20px;">Wypoż</v-btn>
          </td>
        </tr>
        
      </tbody>
    </v-table>
    <div class="center-button">
      <AddBookFromBookDemandingPopup  :role="role" v-model="showScheduleForm"/>
    </div>
  </div>
    
  
</template>

<style>

</style>