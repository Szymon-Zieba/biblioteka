<script>
import { ref } from '@vue/reactivity'
export default {
    setup(){
        const showPassword = ref(false);

        return{
            showPassword
        }
    }
}
</script>

<template>


<div class=container>
    <v-img class="ma-16" style="opacity: 75%" src="@/assets/img/logo-library.png"></v-img>
    <div class="loginBox">
        <div class="loginBox-login">LOGOWANIE</div>
        <v-form>
            <!-- E-mail input -->
            <v-text-field
            append-icon='mdi-account'
            :type="'text'"
            label="E-mail"
            hint="Wprowadź swój e-mail"
            ></v-text-field>

            <!-- Password input -->
            <v-text-field
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            :type="showPassword ? 'text' : 'password'"
            label="Hasło"
            hint="Podaj co najmniej 8 znaków"
            @click:append="showPassword = !showPassword"
            ></v-text-field>
        </v-form>
        <v-btn
        size="x-large"
        top="50"
        color=brown
        to="/"
        >ZALOGUJ</v-btn>

        <router-link style="color: black; margin-top:70px" to="/register">Nie masz konta? Zarejestruj</router-link>


    </div>
</div>

</template>

<style scoped>
*{
    border: 0;
    font-size:14px;
}

.v-text-field{
    width: 400px;
}

.loginBox-login{
    font-weight: bold;
    margin-bottom: 50px;
    font-size: 2rem;

}


.loginBox{
    height: 100%;
    width: 40rem;
    background-color: burlywood;
    justify-content: center;
    align-items: center;
    display: flex;
    flex-direction: column;

}

.container{
    background-image: url("../../public/img/home-background-image.jpg");
    background-size: cover;
    height: 100vh;
    display: flex;
    justify-content: right;
}

</style>