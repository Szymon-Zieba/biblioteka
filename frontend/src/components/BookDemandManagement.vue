<script>
export default {

name:"BookDemandManegment",
    setup(){
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
     return { 
      demands,
        }
    }
    }
</script>

<template>
<div> 
    <div class="tit">
        <h1> Lista zapotrzebowania książek </h1>
    </div >
    <div class="addbook">
        <v-expansion-panels>
      <v-expansion-panel
      >
        <v-expansion-panel-title
        style="background-color: #462e26; color: white"
        >
        </v-expansion-panel-title>
        <v-expansion-panel-text>
            <div>
              <div class="trash" ></div>
              <div class="title">
                  <v-col
                    cols="12"
                    sm="6"
                    md="0"
                >
                    <v-text-field
                        style="height: 3rem ; " 
                        color="#462e26"
                        label="Tytuł"
                        placeholder="Podaj tytuł"
                        variant="underlined"
                    ></v-text-field>
                </v-col>
              </div>
              <div class="authoredit"> 
                  <v-col
                    cols="12"
                    sm="6"
                    md="0"
                >
                    <v-text-field
                        style="height: 3rem ; " 
                        color="#462e26"
                        label="Autor"
                        placeholder="Podaj autora"
                        variant="underlined"
                    ></v-text-field>
                </v-col>
              </div>
                <div class="counter"> 
                  <v-col
                    cols="12"
                    sm="6"
                    md="0"
                >
                    <v-text-field
                        style="height: 3rem ; " 
                        color="#462e26"
                        label="Ilość"
                        placeholder="Ilość"
                        variant="underlined"
                    ></v-text-field>
                </v-col>
              </div> 
              <div class="yes" style="height: 3rem ; " ><v-btn variant="outlined">Dodaj</v-btn></div>
              <div style="clear:both;"></div>
      </div>
        </v-expansion-panel-text>
      </v-expansion-panel>
    </v-expansion-panels>
    </div>
    <v-row>
    <v-col >
      <v-card >
        <v-list lines="one" >
          <v-list-item
          prepend-avatar="../../public/img/bookicon.png"
          >
            <template v-slot:title>
              <div class="trash" ></div>
              <div class="title"><b>Tytuł</b></div>
              <div class="author"> <b> Autor </b></div>
              <div class="id" ><b>Ilość zgłoszeń</b></div> 
              <div style="clear:both;"></div>
            </template>
            
          </v-list-item>
          <v-divider inset></v-divider>
        </v-list>
      </v-card>
    </v-col>
  </v-row>

<v-row>
    <v-col >
      <v-card >
        <v-list lines="two" v-for="demand in demands" :key="demand.id" >
          <v-list-item
          prepend-avatar="../../public/img/bookicon.png"
          >
            <template v-slot:title>
              <div class="title">{{demand.title}}</div>
              <div class="author">{{demand.author}}</div>
              <div class="id">{{demand.count}}</div> 
              <div class="yes"><v-btn variant="outlined">Dodaj</v-btn></div>
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
.addbook{
     color:  #462e26;
  margin-bottom: 15px;
}

.tit{
  color:  #462e26;
  margin-top: 15px;
  margin-bottom: 15px;
}
.title{
  float: left; 
  width: 400px;
}
.author{
  float: left; 
  width: 180px;
  text-align: center;
  margin-left: 20px;
}
.authoredit{
  float: left; 
  width: 280px;
  text-align: center;
  margin-left: 20px;
}
.id{
  float: left; 
  width: 120px;
  text-align: center;
  margin-left: 20px;
}
.counter{
    float: left; 
  width: 150px;
  text-align: center;
  margin-left: 20px;
}
.no{
  float: right; 
  width: 50px;
  text-align: center;
  margin-right: 10px;
  color: red; 
}
.yes{
  float: right; 
  width: 120px;
  margin-top: 20px;
  margin-right: 10px;
  color: rgb(134, 93, 45); 
}
.yes:hover{
    color: rgb(23, 153, 77); 
}

</style>