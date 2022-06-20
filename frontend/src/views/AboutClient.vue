<script>
import { ref } from "vue";
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import useHires from '../composables/useHires.js';
import useGiveBacks from '../composables/useGiveBacks.js';
import useUser from "@/composables/useUser";
import { useRoute } from "vue-router";

export default {
  components: { MainHeader, MainFooter },
  setup() {
    const route = useRoute();
    const id = route.params.id;


    const {hires, loadHiresByUserId} = useHires(id);
    loadHiresByUserId();

    const {giveBacks, loadGiveBacksByUserId} = useGiveBacks(id);
    loadGiveBacksByUserId();

    const { user, loadUser } = useUser(id);
    loadUser();

    const isOverDate=(d1)=>{
      const today = new Date();
      const dateBorrow = new Date(d1);
      const diffTime = Math.abs(today - dateBorrow);
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)); 
      return diffDays;
    }

    return {
      tab: ref(null),
      hires,
      giveBacks,
      isOverDate,
      user,
    };
  },
};
</script>

<template>
  <MainHeader style="background: #795548"/>
  <v-container style="padding-top: 6rem">
    
    <v-tabs v-model="tab">
      <v-tab value="details">Dane osobowe</v-tab>
      <v-tab value="loans">Wypożyczenia książek</v-tab>
    </v-tabs>
    <v-window v-model="tab" justify="center" align="center">
      <!-- DANE OSOBOWE -->
      <v-window-item value="details">
        <div v-if="!user"></div>
        <div v-else class="details"> <br>
          <div>
          ID użytkownika: {{user.id}}
          <br>
          Imię: {{user.firstName}}
          <br>
          Nazwisko: {{user.lastName}}
          <br>
          Email: {{user.email}}
          <br>
          Numer telefonu: {{user.phoneNumber}}
          <br>
          Numer PESEL: {{user.pesel}}
          <br>
          </div>
        </div>
      </v-window-item> 

      <!-- WYPOŻYCZENIA UŻYTKOWNIKA -->
      <v-window-item value="loans">
        <div> <br>
           <v-expansion-panels v-if="hires" style="margin: auto; max-width: 1000px !important;">
            <v-expansion-panel v-for="hire in hires" :key="hire.id">
                <v-expansion-panel-title disable-icon-rotate>
                (id: {{hire.id}}) {{hire.book.title}}
                <template v-slot:actions>
                  

                    <div v-if="hire.status=='RETURNED'">
                        <div class="ended">Książka zwrócona.</div> 
                    </div>

                    <div v-else-if="isOverDate(hire.hireDate.split('T')[0])>14 && hire.status=='DELAYED'">
                        <div class="after_deadline">Książka po terminie wypozyczenia.<br>Oddaj ją do biblioteki!<br>{{isOverDate(hire.hireDate.split('T')[0])-14}} dni po terminie!</div>
                    </div> 

                    <div v-else-if="hire.status=='HIRED'">
                        <div class="borrowed">Książka wypożyczona.<br>Pozostało do zwrotu: {{14-isOverDate(hire.hireDate.split('T')[0])}} dni </div>
                    </div>

                    <div v-else-if="hire.status=='RESERVED'">
                        <div class="reserved">Wysłano prośbę o wypożyczenie.<br>Pozostało do rozpatrzenia prośby: {{7-isOverDate(hire.hireDate.split('T')[0])}} dni </div>
                    </div>
                     <div v-else-if="hire.status=='CANCELED'">
                        <div class="canceled">Anulowano rezerwacje</div>
                    </div>
                    
                      
                </template>
                </v-expansion-panel-title>
                <v-expansion-panel-text>
                    <div style="font-weight: 900; font-size: 24px">{{hire.book.title}}</div>
                    
                    Autorzy:
                    <div v-for="author in hire.book.author" :key="author.id">
                      {{author.name+" "+author.lastName}}
                    </div>
                    
                    <br>
                    Wydawnictwo książki: {{hire.book.publishmentHouse.name}}
                    <br> <br>
                    <div v-if="hire.status=='RESERVED'">
                      Książkę zarezerwowano {{hire.hireDate.split("T")[0]}}
                    </div> 
                    <div v-else>
                      <div v-if="hire.status!='CANCELED'">
                        Książkę wypożyczono {{hire.hireDate.split("T")[0]}}
                      </div>
                      <div v-else>
                        Książkę zarezerowano dnia {{hire.hireDate.split("T")[0]}}, ale rezerwacja została odrzucona przez pracownika.
                      </div>
                    </div> 
                    <br>
                    
                    <div v-if="hire.status=='HIRED' && 14-isOverDate(hire.hireDate.split('T')[0])>0">
                      Pozostało do zwrotu: {{14-isOverDate(hire.hireDate.split('T')[0])}} dni
                    </div> 
                    <div v-else-if="hire.status=='HIRED' && 14-isOverDate(hire.hireDate.split('T')[0])<0">
                      Książka po terminie wypożyczenia!
                    </div>
                    <div v-if="hire.status=='RETURNED' && giveBacks">

                      <span v-for="giveback in giveBacks" :key="giveback.id">
                        <div v-if="giveback.hire.id==hire.id">
                          Książkę zwrócono {{giveback.returnDate.split("T")[0]+" "+giveback.returnDate.split("T")[1]}} 
                        </div>
                      </span>
                    </div>
                </v-expansion-panel-text>
            </v-expansion-panel>
        </v-expansion-panels>
        </div>
      </v-window-item>
    </v-window>
   
  </v-container>
   <MainFooter />
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
