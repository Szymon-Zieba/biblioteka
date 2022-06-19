<script>
import useHires from '../composables/useHires.js';
import useGiveBacks from '../composables/useGiveBacks.js';

export default {
  setup() {
    const {hires, loadHires} = useHires();
    loadHires();

    const {giveBacks, loadGiveBacks} = useGiveBacks();
    loadGiveBacks();

    const isOverDate=(d1)=>{
      const today = new Date();
      const dateBorrow = new Date(d1);
      const diffTime = Math.abs(today - dateBorrow);
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)); 
      return diffDays;
    }
    
    return { 
      hires,
      giveBacks,
      isOverDate,
    }
  },
};
</script>

<template>
  
    <v-container class="text-center">
      
        <div class="text-subtitle-2 mb-2">Twoje wypożyczone książki</div>
        <v-expansion-panels v-if="hires" style="margin: auto; max-width: 1000px !important;">
            <v-expansion-panel v-for="hire in hires" :key="hire.id">
                <v-expansion-panel-title disable-icon-rotate>
                (id: {{hire.id}}) {{hire.book.title}}
                <template v-slot:actions>
                  

                    <div v-if="hire.status=='NOT_AVAILABLE'">
                        <div class="ended">Książka zwrócona.</div> 
                    </div>

                    <div v-else-if="isOverDate(hire.hireDate.split('T')[0])>14">
                        <div class="after_deadline">Książka po terminie wypozyczenia.<br>Oddaj ją do biblioteki!<br>{{isOverDate(hire.hireDate.split('T')[0])-14}} dni po terminie!</div>
                    </div> 

                    <div v-else-if="hire.status=='HIRED'">
                        <div class="borrowed">Książka wypożyczona.<br>Pozostało do zwrotu: {{14-isOverDate(hire.hireDate.split('T')[0])}} dni </div>
                    </div>

                    <div v-else-if="hire.status=='RESERVED'">
                        <div class="reserved">Wysłano prośbę o wypożyczenie.<br>Pozostało do rozpatrzenia prośby: {{7-isOverDate(hire.hireDate.split('T')[0])}} dni </div>
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
                      Książkę wypożyczono {{hire.hireDate.split("T")[0]}}
                    </div> 
                    <br>
                    
                    <div v-if="hire.status=='HIRED' && 14-isOverDate(hire.hireDate.split('T')[0])>0">
                      Pozostało do zwrotu: {{14-isOverDate(hire.hireDate.split('T')[0])}} dni
                    </div> 
                    <div v-else-if="hire.status=='HIRED' && 14-isOverDate(hire.hireDate.split('T')[0])<0">
                      Książka po terminie wypożyczenia!
                    </div>
                    <div v-if="hire.status=='NOT_AVAILABLE' && giveBacks">

                      <span v-for="giveback in giveBacks" :key="giveback.id">
                        <div v-if="giveback.hire.id==hire.id">
                          Książkę zwrócono {{giveback.returnDate.split("T")[0]+" "+giveback.returnDate.split("T")[1]}} 
                        </div>
                      </span>
                    </div>
                </v-expansion-panel-text>
            </v-expansion-panel>
        </v-expansion-panels>
    </v-container>
</template>

<style scoped>
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
.reserved {
  color: rgb(51, 102, 255);
}
</style>