<script>
import MainHeader from '@/components/MainHeader.vue';
import MainFooter from '@/components/MainFooter.vue';
  export default {
  components: { MainHeader, MainFooter},
    setup(){
      const books = ([
        {
        id: '1',
        title: 'zgredek',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '2',
        title: 'Harry Potter2',
        author: 'J.K.Rowling2',
        genre: 'Fantasy2',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '3',
        title: 'Harry Potter3',
        author: 'J.K.Rowling3',
        genre: 'Fantasy3',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '4',
        title: 'Harry Potter4',
        author: 'J.K.Rowling4',
        genre: 'Fantasy4',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '5',
        title: 'Harry Potter5',
        author: 'J.K.Rowling5',
        genre: 'Fantasy5',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '6',
        title: 'Harry Potter6',
        author: 'J.K.Rowling6',
        genre: 'Fantasy6',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '7',
        title: 'Harry Potter7',
        author: 'J.K.Rowling7',
        genre: 'Fantasy4',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '8',
        title: 'Harry Potter8',
        author: 'J.K.Rowling8',
        genre: 'Fantasy4',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        
      ]);

    return { 
      books,
    }
  }  
}  
</script>

<template>
    <div fill-height  class="container">
      <MainHeader/>
      <v-card class="search">
        <v-container fluid>
          <v-row
            align="center"
          >
            <v-col cols="12">
              <v-autocomplete
                v-model="value"
                :items="books"
                label="Szukaj"
              ></v-autocomplete>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
      <v-container fill-height fluid>
        <v-row justify="center" dense style="margin:2rem;">
          <v-col v-for="book in books" :key="book.id" class="custom7cols" >
            <v-card
              color="#1F7087"
            >
              <div 
              >
                <router-link
                  to="/book" 
                  class="disabled-link d-flex"
                >
                  <div>
                    <v-card-title class="text-h5 mb-6">
                      {{book.title}}
                    </v-card-title>
                    
                    <v-card-subtitle
                      class="mb-5">
                      {{book.author}}
                    </v-card-subtitle>

                    <v-card-subtitle>
                      {{book.genre}}
                    </v-card-subtitle>

                    <v-card-text style="font-size: 0.8rem">
                    {{book.text}}
                    </v-card-text>

                    
                  </div>
                  <div
                    class="avatar" 
                    rounded="0"
                  >
                    <v-img class="img" src="../../public/img/books-product.jpg"></v-img>
                  </div>
                </router-link>
              </div>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
      <MainFooter/>
    </div>
</template>

<style scoped>

  .container{
    background-image: url("../../public/img/books-background.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    justify-items: center;
  }

  .v-card{
    background: rgb(219, 197, 168) !important;
    box-shadow: 0 0 2rem black;
    opacity: 0.9;
  }

  .v-card:hover{
    background: burlywood !important;
    box-shadow: 0 0 0.5rem black;
    opacity: 1;
  }

  .avatar{
    height: 100%;
    width: 100%;
  }

  .disabled-link{       
  text-decoration: none;
  }

  a{
    color: black !important;
  }
  .custom7cols {
  max-width: 24%;
  flex-basis: 20%;
  margin: 1rem;
}
  .search{
    margin: 2rem 15rem;
  }
</style>