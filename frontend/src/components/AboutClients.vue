<script>
  export default {
    setup(){

    const clients = ([
        {name:'Asia', lastName:'Asia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Kasia', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Mariola', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Karol', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},
        {name:'Ktos', lastName:'NieAsia', email:'jatoty@gamil.com', pesel:'213412123'},   
    ])

      return {
        clients,
      }
    }
  }
</script>

<template>
  <div class="main">
    <v-container
      v-for="(client, index) in clients"
      :key="client"
      class="grey lighten-5 mb-6 "
    >
    <router-link 
      to="/"
    class="disabled-link"
    >
      <v-row
        :align="align"
        no-gutters
        style="height: 1rem; text-align: center;"         
      >
        <v-col>
          <v-card
            class="pa-2"
            outlined
            tile
          >
           {{ index }}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-2"
            outlined
            tile
          >
          Imię : {{ client.name }}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-2"
            outlined
            tile
          >
          Nazwisko :  {{ client.lastName}}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-2"
            outlined
            tile
          >
          PESEL :   {{ client.pesel}}
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-2"
            outlined
            tile
          >
           EMAIL :  {{ client.email}}
          </v-card>
        </v-col>
      </v-row>
    </router-link>
    </v-container>
  </div>
</template>


<style>
  .main{
    padding: 2rem;
  }
  .disabled-link{       
  text-decoration: none;
  }

.v-row:hover{
    box-shadow: 0 0 2rem black;
    opacity: 0.7;
  }
  .v-card{
      background-color: burlywood;
  }
</style>