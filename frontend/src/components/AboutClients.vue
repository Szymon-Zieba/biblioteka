<script>
import { ref, reactive, computed } from 'vue'
  export default {
    setup(){
    const names = ['NR', 'Imię', 'Nazwisko', 'PESEL', 'Email']
    const clients = reactive([
        {name:'Asia', lastName:'Asia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Kasia', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Mariola', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Karol', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Ktos', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'}   
    ])
     const search = ref('')

    const filteredList = computed(() => {
      return clients.filter(client => 
        (client.name+client.lastName).toLowerCase().includes(search.value.toLowerCase())
      )
    })
      return {
        clients,
        names,
        search,
        filteredList
      }
    },
  }
</script>

<template>
  <div class="main">
    <v-container fluid>
      <v-row
        align="center"
      >  
      <v-col>
          <v-text-field 
            v-model="search"
            label="Wpisz Imię lub Nazwisko"
          >
          </v-text-field>
        </v-col>
      </v-row>
    </v-container>
    <v-container fluid>
      <v-row
        :align="align"
        no-gutters
      >  
        <v-col         
          v-for="name in names"
          :key="name">
          <v-card
            class="pa-6 text-h5 v-card-nav"
            style="background-color:none; "
            outlined
            tile
          >
           {{ name }}
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <v-container
      v-for="(client, index) in filteredList"
      :key="client"
      class="mb-9"
    >
    <router-link 
      to="/client"
    class="disabled-link"
    >
      <v-row
        :align="align"
        no-gutters
        style="height: 1rem; " 
        class="v-row1 text-h6"        
      >
        <v-col>
          <v-card
            class="pa-6 v-card-number"
            outlined
            tile
          >
           {{ index+1 }}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-6"
            outlined
            tile
          >
           {{ client.name }}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-6"
            outlined
            tile
          >
          {{ client.lastName }}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-6"
            outlined
            tile
          >
           {{ client.pesel}}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-6"
            outlined
            tile
          >
             {{ client.email}}
          </v-card>
        </v-col>
      </v-row>
    </router-link>
    </v-container>
  </div>
</template>


<style scoped>
  .main{
    padding: 2rem;
  }
  .disabled-link{       
  text-decoration: none;
  }
  .v-card-number{
    background-color: rgb(245, 245, 245) !important; 
  }
  .v-card-nav{
    background-color: rgb(245, 245, 245) !important;
  }
 .v-row1:hover{
    opacity: 0.6;
  }
  .v-row{
    text-align: center;
  }
  .v-card{
      background-color: burlywood;
  }
</style>