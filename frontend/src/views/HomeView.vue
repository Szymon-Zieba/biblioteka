<script>
export default {
    name:"HomeView",
    data: () => ({
      
    }),
}
</script>

<template>

    <div id="container">

        <header>
            {Library.name}

            <v-spacer/>
            <v-item-group id="header-menu">
                <v-btn tile elevation="0" color="transparent">OFERTA</v-btn>
                <v-btn tile elevation="0" color="transparent">KONTAKT</v-btn>
                <v-btn to="/login" tile elevation="0" color="transparent">
                    LOGOWANIE
                </v-btn>
                <v-btn to="/register" tile elevation="0" color="transparent">
                    REJESTRACJA
                </v-btn>
            </v-item-group>
        </header>

        <div id="content" class="text-center">
            <span class="text-h1 font-weight-regular">WITAJ W <span class="text-h1 font-weight-regular highlighted">BIBLIOTECE ONLINE</span></span>
            <span class="text-h3 mt-16">Przeglądaj i wypożyczaj książki <span class="text-h3 mt-16 highlighted">ONLINE</span></span>
        </div>

        <v-footer absolute class="footer text-center">
            <v-row>
                <v-col>
                        <span class="font-weight-bold">Kontakt</span>
                        <br>+48 123 123 123
                        <br>biblioteka@gmail.com
                
                </v-col>

                <v-col>
                    <span class="font-weight-bold">Biblioteki są otwarte w godzinach:</span> 
                    <v-row>
                        <v-col align="right">
                            Poniedziałek<br>
                            Wtorek<br>
                            Środa<br>
                            Czwartek<br>
                            Piątek
                        </v-col>
                        <v-col align="left">
                            8:00 - 16:00<br>
                            8:00 - 16:00<br>
                            10:00 - 18:00<br>
                            8:00 - 16:00<br>
                            8:00 - 16:00
                        </v-col>
                    </v-row>
                </v-col>
            </v-row>
            
        </v-footer>
    
    </div>
    
</template>

<style scoped>

*{
    font-size: 20px;
    overflow: hidden;
}

#container{
    background-image: url("../../public/img/home-background-image.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    height: 100vh;
}

header{
    background: rgba(0, 0, 0, 30%);
    height: 5rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
    color: white;
    padding: 0 3rem 0 3rem;
}

#header-menu{
    color: white;
}

#content{
    margin-top: 10rem;
    width: 100%;
    color: white;
    display: flex;
    flex-direction: column;
}

.highlighted{
    color: burlywood;
}

.footer{
    bottom: 0;
    width: 100%;
    background: burlywood;
}

</style>