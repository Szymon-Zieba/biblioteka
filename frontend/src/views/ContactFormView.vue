<script>
  export default {
    data () {
      return {
        select: ['Vuetify', 'Programming'],
        items: [
          'Programming',
          'Design',
          'Vue',
          'Vuetify',
        ],
      }
    },
  }
</script>

<template>
    <div class="imgBackgorund">
        <div class="imgBackgorundOpacity">
            <div class="img">
                <router-link to="/">
                    <v-img
                        src="@/assets/img/logo-library.png"
                        height="5rem"
                    ></v-img>
                </router-link>
            </div>
            <v-container fluid>
                <v-row>
                    <v-col cols="12">
                        <v-row>
                            <v-col>
                                <v-icon
                                    large
                                    color="teal darken-2"
                                    >
                                    mdi-email
                                </v-icon>
                                <span>dsadasdasdsa</span>
                            </v-col>
                            <v-col>
                                <v-icon
                                    large
                                    color="green darken-2"
                                    >
                                    mdi-domain
                                </v-icon>
                                <span>dsadasdasdsa</span>
                            </v-col>
                            <v-col>
                                <v-icon
                                    large
                                    color="yellow darken-2"
                                    >
                                    mdi-phone-classic
                                </v-icon>
                                <span>dsadasdasdsa</span>
                            </v-col>
                        </v-row>
                    </v-col>
                    <v-col cols="12">
                        <v-expansion-panels>
                            <v-expansion-panel
                                v-for="i in 5"
                                :key="i"
                                title="Item"
                                text="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            >

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

.form{
    color: white;
}
.button{
    width: 100%;
    display: flex;
    justify-content: space-around;
}
.btn{
    padding: 3rem;
}
</style>