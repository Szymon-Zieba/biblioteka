<script>
import AddBookFromBookDemandingPopup from './AddBookFromBookDemandingPopup.vue';
export default {
  components: { AddBookFromBookDemandingPopup },

name:"BookDemandManegment",
props: ["role"],
    setup(){
      const showScheduleForm = false;

      const demands = ([
      {
      id: '1',
      count: '5',
      title: 'Zmierzch',
      author: 'S. Meyer',
      },
      {
      id:'2',
      count: '2',
      title: '365 dni',
      author: 'B. Lipińska',
      },
      {
      id:'3',
      count: '6',
      title: 'Ogniem i mieczem ',
      author: 'H. Sienkiewicz',
      }
        ]);

      const user = {
        role: "HEADADMIN",
      };
     return { 
      demands,
      user,
      showScheduleForm
        }
    }
    }
</script>

<template>
  <div class="main">


<!--  POPUP TUTAJ ZMIEN KURWA dsaaaaaaaaaaaaaaaaa-->



    <v-table theme="light">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Tytuł</th>
          <th class="text-left">Autor</th>
          <th class="text-left">Liczba zapytań</th>
        </tr>
      </thead>
      <tbody>
        <tr
          style="margin-top: 50px"
          v-for="demand in demands"
          :key="demand"
        >
          <td>{{ demand.id }}</td>
          <td>{{ demand.title }}</td>
          <td>{{ demand.author }}</td>
          <td>{{ demand.count }}</td>
          <div v-if="user.role === `HEADADMIN`">
            <td><AddBookFromBookDemandingPopup v-model="showScheduleForm" /> </td>
            <td><v-btn class="button" color="red">Usun z rejestru</v-btn></td>
          </div>
        </tr>
        <tr>
          <td><v-text-field style="margin-bottom: -30px;"
              label="Tytuł"
          ></v-text-field></td>
          <td><v-text-field style="margin-bottom: -30px;"
              label="Autor"
          ></v-text-field></td>
          <td><v-text-field style="margin-bottom: -30px;"
              label="Ile osób"></v-text-field></td>
          <td><v-btn color="green">Dodaj do rejestru</v-btn></td>
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
.button{
  margin-left: 2rem;
}
</style>
