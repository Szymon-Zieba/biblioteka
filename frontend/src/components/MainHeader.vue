<script>
export default {
    name:"MainHeader",
    setup(){
        
        return{

        }
    }
}
</script>

<template>
    <header>
        <router-link to="/">
            <v-img src="@/assets/img/logo-library.png" width="6.6rem" height="6rem"></v-img>
        </router-link>

        <v-spacer/>
        <v-item-group id="header-menu">
            <v-btn to="/books" tile elevation="0" color="transparent">OFERTA</v-btn>
            <v-btn tile elevation="0" color="transparent">KONTAKT</v-btn>
            <v-btn to="/login" tile elevation="0" color="transparent">
                LOGOWANIE
            </v-btn>
            <v-btn to="/register" tile elevation="0" color="transparent">
                REJESTRACJA
            </v-btn>
        </v-item-group>
    </header>
</template>

<style>
    header{
        background: rgba(0, 0, 0, 30%);
        height: 6rem;
        display: flex;
        align-items: center;
        justify-content: space-between;
        color: white;
        padding: 0 3rem 0 3rem;
    }

    #header-menu{
        color: white;
    }
</style>