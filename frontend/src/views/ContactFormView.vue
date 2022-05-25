<script>
import { ref} from "vue";
import {getLibraries} from '../services/library.service.js'

  export default {
    setup(){
        const libraries = ref([])
        const loadLibraries = async () =>{
            libraries.value = await getLibraries()
        }

        loadLibraries()

        return {
            libraries,
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
                                        Biblioteka: {{ library.city }}
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
                                                {{ library.email }}
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
                                              {{library.city + ' ' + library.postCode + '   ul.' + library.streetAndNumber}}
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
                                                {{ library.phoneNumber }}
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