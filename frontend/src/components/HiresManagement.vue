<script>
import useHires from "../composables/useHires"
import {updateHire} from "../services/hire.service"
import {updateBook} from "../services/book.service"

import {ref} from 'vue'
export default {
    setup(){

    const {hiresByPesel, loadHiresByPesel} = useHires()

    const search = ref("")

    const cancelHire = (hireId, bookId) =>{
      updateHire(hireId, 'CANCELED')
      updateBook(bookId, "IN_STOCK")
    }

    const acceptHire = (hireId, bookId) =>{
      updateHire(hireId, 'HIRED')
      updateBook(bookId, "HIRED")
    }
        
    const finishHire = (hireId, bookId) =>{
      updateHire(hireId, 'RETURNED')
      updateBook(bookId, "IN_STOCK")
    }
    console.log(hiresByPesel.value)
    return{
      cancelHire,
      acceptHire,
      finishHire,
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

          
          <td v-if="hire.status=='RESERVED'"> <v-btn @click="cancelHire(hire.id, hire.book.id)">Odrzuć</v-btn>
                <v-btn @click="acceptHire(hire.id, hire.book.id)" style="margin-left: 20px;">Wypożycz</v-btn>
          </td>
          <td v-if="hire.status=='HIRED' || hire.status=='DELAYED'"> <v-btn @click="finishHire(hire.id, hire.book.id)">Zwróć</v-btn>

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