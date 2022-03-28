<script>
export default {
    name:"MainFooter",
    setup(){
        return{

        }
    }
}
</script>

<template>
    <v-footer absolute class="footer text-center">
        <v-row class="footer-content">
            <v-col>
                <span class="font-weight-bold">Kontakt</span>
                <br>+48 123 123 123
                <br>biblioteka@gmail.com
                <br>FAX: (22) 999-00-11
            
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
</template>

<style>
    .footer{
        bottom: 0;
        width: 100%;
        background: burlywood;
    }

    .footer-content{
        font-size: 0.7rem;
    }
</style>