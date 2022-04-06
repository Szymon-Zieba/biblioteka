<script>
import { ref } from "vue";

export default {
  setup() {
    const books = ([
        {
            id: 1,
            title: 'Harry Potter - TOM 1',
            author: 'J.K.Rowling',
            genre: 'Fantasy',
            date_borrow: "01/01/2022",
            date_borrow_end: "01/05/2022",  
            date_return: "26/04/2022",      
        },
        {
            id: 2,
            title: 'Harry Potter - TOM 2',
            author: 'J.K.Rowling2',
            genre: 'Fantasy2',
            date_borrow: "01/01/2022",
            date_borrow_end: "30/04/2022",    
        },
        {
            id: 3,
            title: 'Harry Potter - TOM 3',
            author: 'J.K.Rowling3',
            genre: 'Fantasy3',
            date_borrow: "01/01/2022",
            date_borrow_end: "10/01/2022",    
            
        },
      ]);
    return {
      tab: ref(null),
      user: ref({
        firstName: "Jan",
        lastName: "Kowalski",
        email: "jankowalski@gmail.com",
        phone: "123456789",
        street: "Cicha 2/704",
        zip: "35-326",
        city: "Rzeszów",
        pesel: "12345678910",

        count_rentals: 16,
        count_rentals_in_progress: 8,
        count_rentals_end: 8,
        last_rental: "01/04/2022",
      }),
      books,
    };
  },
};
</script>

<template>
  <v-container>
    <v-tabs v-model="tab">
      <v-tab value="details">Dane osobowe</v-tab>
      <v-tab value="loans-count">Wypożyczenia<br>ilość</v-tab>
      <v-tab value="loans-details">Wypożyczenia<br>szczegóły</v-tab>
      <v-tab value="settings">Zarządzanie</v-tab>
    </v-tabs>
    <v-window v-model="tab" justify="center" align="center">
      <!-- DANE OSOBOWE -->
      <v-window-item value="details"> <br>
        <div class="details">{{user.firstName}} {{user.lastName}} <br>
        tel. {{user.phone}} <br>
        {{user.email}} <br>
        ul. {{user.street}}, {{user.zip}} {{user.city}} <br>
        PESEL: {{user.pesel}}
        </div>
      </v-window-item> 
      <!-- LICZBA WYPOŻYCZEŃ W BIBLIOTECE -->
      <v-window-item value="loans-count">
        <div class="details"> <br>
          Liczba wypożyczonych łącznie książek: {{user.count_rentals}}.<br>
          Liczba książek aktualnie wypożyczonych: {{user.count_rentals_in_progress}}.<br>
          Liczba książek, która została oddana do biblioteki: {{user.count_rentals_end}}.<br><br>
          Ostatnia data wypożyczenia książki: {{user.last_rental}}r.
        </div>
      </v-window-item>
      <v-window-item value="loans-details">
        <div> <br>
          <v-expansion-panels style="margin: auto; max-width: 1000px !important;">
            <v-expansion-panel v-for="book in books" :key="book.id">
                <v-expansion-panel-title disable-icon-rotate>
                (id: {{book.id}}) {{book.title}}
                <template v-slot:actions>

                    <div v-if="book.id==1">
                        <div class="ended">Książka oddana.<br>Termin zwrotu: {{book.date_borrow_end}}</div>
                    </div>
                    <div v-else-if="book.id==2">
                        <div class="borrowed">Książka wypożyczona.<br>Termin zwrotu: {{book.date_borrow_end}}</div>
                    </div>
                    <div v-else-if="book.id==3">
                        <div class="after_deadline">Książka po terminie wypozyczenia.<br>Termin zwrotu: {{book.date_borrow_end}}</div>
                    </div>
                </template>
                </v-expansion-panel-title>
                <v-expansion-panel-text>
                    <div style="font-weight: 900; font-size: 24px">{{book.title}}</div>
                    
                    Autor książki: {{book.author}}
                    <br>
                    Gatunek książki: {{book.genre}}
                    <br> <br>
                    Książkę wypożyczono {{book.date_borrow}}r.
                    <br>
                    Książka wypożyczona do {{book.date_borrow_end}}r.
                    <br>
                    <div v-if="book.date_return">
                        Książkę zwrócono dnia {{book.date_return}}r.
                    </div>
                    
                </v-expansion-panel-text>
            </v-expansion-panel>
        </v-expansion-panels>
        </div>
      </v-window-item>
      <!-- WYPOŻYCZONE KSIĄŻKI - SZCZEGÓŁY -->
      <v-window-item value="settings">
        <div> <br>
          <v-btn elevation="2" rounded text
          >Zablokuj użytkownika</v-btn>
          <br><br>
          <v-btn elevation="2" rounded text
          >Usuń użytkownika</v-btn>
          <br><br>
        </div>
      </v-window-item>
    </v-window>
  </v-container>
</template>

<style scoped>
.save-button {
  background-color: rgb(23, 201, 100);
}

.cancel-button {
  background-color: rgb(210, 210, 210);
}

.details {
  font-weight: 600;
  font-size: 1.2rem;
}

.ended {
  color: rgb(0, 100, 0);
}
.borrowed {
  color: rgb(255, 174, 0);
}
.after_deadline {
  color: red;
  font-weight: 900;
}
</style>
