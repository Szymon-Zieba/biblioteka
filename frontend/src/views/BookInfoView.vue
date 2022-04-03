<script>
import MainHeader from '@/components/MainHeader.vue';
import MainFooter from '@/components/MainFooter.vue';
  export default {
  components: { MainHeader,MainFooter},
    setup(){
      const book = 
        [{
        id: '1',
        title: 'zgredekdsadsadas dasdasdsadasdasdasdasdasd',
        author: 'J.K.Rowling',
        genre: 'Fantasy',
        text: 'Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygodyZnasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody vZnasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody Znasz już Harry`ego Pottera, młodego czarodzieja, który przeżywa coraz to nowe przygody',        
        img: '../../public/img/Harry_Potter_I_Więzień_Azkabanu.png'
        }];
      const libraries = 
        [{
        id: '1',
        city: 'Rzeszów',
        adress: 'Ul.Cicha 56',
        quantity: '10'
        },
        {
        id: '2',
        city: 'Kraków',
        adress: 'Ul.Cicha 56',
        quantity: '0'
        },
        {
        id: '3',
        city: 'Wrocław',
        adress: 'Ul.Cicha 56',
        quantity: '12'
        },
        ];
     const items =  ['Wroclaw', 'Krakow', 'Warszawa', 'Cos']
     const selected = '0'  
     
     const isAvible = (quantity) => {
       if(quantity <= 0)
        return false  
       else
        return true
     }

    return { 
      book,
      libraries,
      selected,
      isAvible,
      items
    }
  }  
}  
</script>

<template>
  <div class="all">
    <MainHeader/>
    <v-container fill-height class="container">
      <v-row 
        align="center"
        justify="center"
      >
        <v-col class="v-col-vimg">
          <v-card
            class="vcard-height pa-2"
            outlined
            tile
          >
          <v-img src="../../public/img/books-product.jpg" class="card-vimg"></v-img>
          </v-card>
        </v-col>
        <v-col class="v-col-text">
          <v-card
          class="vcard-height pa-2"  
          >
          <div class="text-h4 mb-10">
            {{book[0].title}}
          </div>
          
          <div
            class="mb-7 text-h5">
              {{book[0].author}}
          </div>

          <div class="mb-7 text-h5">
              {{book[0].genre}}
          </div>

          <v-card-text style="font-size: 0.9rem">
          {{book[0].text}}
          </v-card-text>
         </v-card>
        </v-col>
        <v-col>
          <v-card
            class="vcard-height pa-2 vcard-buttons"
            outlined
            tile
          >
          <div class="mt-15">
            <v-col cols="12" class="mb-7">
              <v-select
                :items="items"
                :menu-props="{ top: true, offsetY: true }"
                label="Wybierze Biblioteke"
              ></v-select>
            </v-col>
            <v-btn
              class="btn-reserve mt-15 mb-15"
              color="orange"
              style="color:black;"
              fab
              x-large
              dark
            >Rezerwacja
            </v-btn>

            <div class="text-h5 mt-16">
              12 dostepnych w tej bibliotece
            </div>
          </div>
         

          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <MainFooter/>
  </div>
</template>

<style scoped>
  .all{
    background-image: url("../../public/img/books-background.jpg");
    background-repeat: no-repeat;
    background-size: cover;
  }
  .container{
    margin: 0.5rem 3rem; 
    padding: 1rem;
  }
  .v-row{
    padding: 2rem;
    box-shadow: 0 0 5rem black;
  }
  .v-col{
    padding: 1rem;
  }
  .v-col-text{
    text-align: center;
  }
  .vcard-height{
    height: 100%;
    min-height: 70vh;
    background-color: burlywood;
    text-align: center;
  }
  .card-vimg{
    background-repeat: no-repeat;
    background-size: cover;
    height: 25rem;
    margin: 6rem 10%;
    min-width: 8rem;
  }
  .vcard-info{

  }
  .btn-reserve{
    padding: 2rem;
  }
  .vcard-height-cos{
    width:30rem
  }
</style>