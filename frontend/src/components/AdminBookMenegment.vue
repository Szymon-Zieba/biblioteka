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
    },

  name2: 'add',
  data(){
    return{
      showModal: false
    }
  },


  data1: () => ({
      valid: true,
      title: '', 
      author: '',
      description: '',
      select: null,
      items: [
        'Bajka',
        'Dramat',
        'Fantasy',
        'Historyczna',
      ]
    }),

    methods: {
      add () {
        this.$refs.form.add()
      },
    },
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
    class="button"
      variant="outlined"
      size="large"
      icon
      color="#462e26"
      @click="showModal = true"
    >
      <v-icon size="x-large">mdi-plus</v-icon>
    </v-btn>
    <transition name="fade" appear>
      <div class="modal-overlay" v-if="showModal" @click = "showModal = false"></div>
    </transition>
    <transition  name="slide" appear>
      <div class="modal" v-if="showModal">
        <button class="button" @click="showModal = false">
          <v-icon>mdi-close</v-icon>
        </button>
        <h1 class="modalh1">Książka</h1>
         <v-form
          ref="form"
          v-model="valid"
          lazy-validation
        >
          <v-text-field
            v-model="title"
            :counter="50"
            label="Tytuł"
            required
          ></v-text-field>

          <v-text-field
            v-model="author"
            :counter="32"
            label="Autor"
            required
          ></v-text-field>

          <v-text-field
            v-model="description"
            label="Opis"
            required
          ></v-text-field>

          <v-select
            v-model="select"
            :items="items"
            label="Gatunek"
            required
          ></v-select>

          <v-file-input
          show-size
          counter
          multiple
          label="Obraz"
        ></v-file-input>

          <v-btn
            :disabled="!add"
            color="brown"
            class="mr-4"
            @click="showModal = false"
          >
            Dodaj
          </v-btn>
        </v-form>
      </div>
    </transition>
  </div> 


  <v-row>
    <v-col >
      <v-card >
        <v-list lines="two"
        v-for="book in books" :key="book.id" @click="showModal= true">
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
              <div class="trash"><v-icon>mdi-delete</v-icon></div>
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
  width: 180px;
  text-align: center;
  margin-left: 20px;
}
.id{
  float: right; 
  width: 120px;
  text-align: center;
  margin-left: 20px;
}
.trash{
  float: right; 
  width: 20px;
  text-align: center;
  margin-left: 10px;
  color: red; 
}

.modal-overlay {
  position: absolute;
 top: 0;
 left: 0;
 right: 0;
 bottom: 0;
 z-index: 98;
 background-color: rgba(0, 0, 0, 0.3);
}

.modal {
 position: fixed;
 top: 50%;
 left: 50%;
 transform: translate(-50%, -50%);
 z-index: 99;
 
 width: 100%;
 max-width: 400px;
 background-color: #FFF;
 border-radius: 16px;
 
 padding: 25px;


}
.modalh1 {
  color:  #462e26;
  font-size: 32px;
  font-weight: 900;
  margin-bottom: 15px;
  text-align: left;
 }


.fade-enter-active,
.fade-leave-active {
 transition: opacity .5s;
}

.fade-enter,
.fade-leave-to {
 opacity: 0;
}

.slide-enter-active,
.slide-leave-active {
 transition: transform .5s;
}

.slide-enter,
.slide-leave-to {
 transform: translateY(-50%) translateX(100vw);
}
</style>