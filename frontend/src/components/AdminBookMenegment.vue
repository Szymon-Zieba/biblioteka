<script>
export default {
    name:"AdminBookMenegment",
    setup(){
        const books = ([
        {
        id: '1',
        title: 'Zgredek',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '2',
        title: 'Harry Potter2',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '3',
        title: 'Harry Potter3',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '4',
        title: 'Harry Potter4',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '5',
        title: 'Harry Potter5',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '6',
        title: 'Harry Potter6',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody... ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '7',
        title: 'Pinokio',
        author: 'C. Collodi',
        genre: 'Bajka',
        text: 'To drewniany pajacyk, wystrugany przez starego stolarza Dżeppetta z kawałka magicznego pniaka. ',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        },
        {
        id: '8',
        title: 'Potop',
        author: 'H. Sienkiewicz',
        genre: 'Historyczna',
        text: 'Potop to druga powieść z tworzących Trylogię Henryka Sienkiewicza.',        
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

         
  <div class="booksAdmin"> 
    <div class="title">
        <h1> Lista książek </h1>
    </div>
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
    

  <div class="add">
    <v-btn 
      variant="outlined"
      size="large"
      icon
      color="#462e26"
    >
      <v-icon>mdi-plus</v-icon>
    </v-btn>
  </div> 

  <v-row>
    <v-col >
      <v-card >
        <v-list lines="two"
        v-for="book in books" :key="book.id">
  <!--        <v-list-subheader>Dostępne książki</v-list-subheader>-->
  <!-- dodawanie awataru w list-item prepend-avatar="src/assets/img/bookicon.jpg"-->
          <v-list-item
          prepend-avatar="../../public/img/bookicon.png"
          >
            <template v-slot:title>
              {{book.title}} <span class="grey--text text--lighten-1"></span>
            </template>
            <template v-slot:subtitle>
              <div class="des"><span class="font-weight-bold">{{book.genre}}</span> &mdash; {{book.text}} </div>
              <div class="id">{{book.id}}</div>
              <div class="author">{{book.author}}</div>
              <div style="clear:both;"></div>
            </template>
            
            
          </v-list-item>
          <v-divider inset></v-divider>

        </v-list>
      </v-card>
    </v-col>
  </v-row>
  </div>
</template>



<style>
.title{
  color:  #462e26;
  margin-top: 15px;
  margin-bottom: 15px;
}
.add{
  margin-top: 25px;
  padding: 15px;
  text-align: right;
}
.des{
  float: left; 
  width: 690px;
}
.author{
  float: right; 
  width: 200px;
  text-align: center;
  margin-left: 20px;
}
.id{
  float: right; 
  width: 150px;
  text-align: center;
  margin-left: 20px;
  
}

</style>