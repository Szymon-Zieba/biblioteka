<script>
import { reactive} from "vue";

  export default {
    setup(){
        const libraries = reactive([
            {
                id: "1",
                mail: "dsadas@dasdas.com",
                adress: "Rzeszów Ul.Cicha 56",
                phone: "103-323-312",
            },
            {
                id: "2",
                mail: "dsadas@dasdas.com",
                adress: "Bźdiszewo Ul.Martwa 58",
                phone: "103-323-312",
            },
            {
                id: "3",
                mail: "dsadas@dasdas.com",
                adress: "Rzeszów Ul.Cicha 56",
                phone: "103-323-312",
            },
            {
                id: "4",
                mail: "dsadas@dasdas.com",
                adress: "Rzeszów Ul.Cicha 56",
                phone: "103-323-312",
            },
            {
                id: "5",
                mail: "dsadas@dasdas.com",
                adress: "Białystok Ul.Cicha 56",
                phone: "103-323-312",
            },
            {
                id: "6",
                mail: "dsadas@dasdas.com",
                adress: "Poznań Ul.Cicha 56",
                phone: "103-323-312",
            },
            {
                id: "7",
                mail: "dsadas@dasdas.com",
                adress: "Kraków Ul.Cicha 56",
                phone: "103-323-312",
            },
        ])

        const getCityFromAdress = function(library){
            const splited = library.adress.split(' ')
            return splited[0]
        }

        return {
            libraries,
            getCityFromAdress
        }
    }
  }
</script>

<template>
    <div class="imgBackgorund">
        <div class="imgBackgorundOpacity">
            <div class="img">
                <router-link to="/">
                    <v-img
                        src="@/assets/img/logo-library.png"
                        height="9rem"
                    ></v-img>
                </router-link>
            </div>
            <v-container fluid>
                <v-row>
                    <v-col cols="12">
                        <v-row class="font-size">
                            <v-col>
                                <v-icon
                                    large
                                    color="teal darken-2"
                                    >
                                    mdi-email
                                </v-icon>
                                <span  class="text">biblioteka@gmail.com</span>
                            </v-col>
                            <v-col>
                                <v-icon
                                    large
                                    color="green darken-2"
                                    >
                                    mdi-domain
                                </v-icon>
                                <span  class="text">Rzeszów ul.Piłsudzkiego 13</span>
                            </v-col>
                            <v-col>
                                <v-icon
                                    large
                                    color="orange darken-2"
                                    >
                                    mdi-phone-classic
                                </v-icon>
                                <span  class="text">
                                    644-322-123
                                </span>
                            </v-col>
                        </v-row>
                    </v-col>
                    <v-col cols="12">
                        <v-expansion-panels style="font-size: 1.3rem;">
                             <v-expansion-panel
                                v-for="library in libraries"
                                :key="library"
                                style="padding: 0.5rem;"
                             >
                                <v-expansion-panel-title>
                                    <v-row no-gutters>
                                        <v-col cols="4" class="d-flex justify-start" style="font-size: 1.5rem;">
                                        Biblioteka: {{ getCityFromAdress(library) }}
                                        </v-col>
                                        <v-col
                                        cols="8"
                                        class="text-black"
                                        >
                                        </v-col>
                                    </v-row>
                                </v-expansion-panel-title>
                                <v-expansion-panel-text>
                                    <v-row >
                                        <v-col>
                                            <v-icon
                                                large
                                                color="teal darken-2"
                                                >
                                                mdi-email
                                            </v-icon>
                                            <span  class="text">
                                                {{ library.mail }}
                                            </span>
                                        </v-col>
                                        <v-col>
                                            <v-icon
                                                large
                                                color="green darken-2"
                                                >
                                                mdi-domain
                                            </v-icon>
                                            <span  class="text">
                                                {{ library.adress }}
                                            </span>
                                        </v-col>
                                        <v-col>
                                            <v-icon
                                                large
                                                color="orange darken-2"
                                                >
                                                mdi-phone-classic
                                            </v-icon>
                                            <span  class="text">
                                                {{ library.phone }}
                                            </span>
                                        </v-col>
                                    </v-row>
                                </v-expansion-panel-text>
                            </v-expansion-panel>
                        </v-expansion-panels>
                    </v-col>
                </v-row>
            </v-container>
        </div>
    </div>
</template>

<style scoped>

.imgBackgorund{
    color: white;
    min-height: 100vh;
    height: 100%;
    background: url("@/assets/img/contactBackground.jpg");

}
.imgBackgorundOpacity{
    background-color:rgba(0, 0, 0, 0.6);
    min-height: 100vh;
    height: 100%;
    padding: 3rem;
}
.img{
    width: 15rem;
    margin: auto;
    margin-bottom: 2rem;
}

.font-size{
    font-size: 2rem;
}
.text{
    padding: 0.5rem;
}
</style>