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
    <div class="registerBox">
        <div class="registerBox-login">Rejestracja</div>
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

            <!-- Re-Password input -->
            <v-text-field
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            :type="showPassword ? 'text' : 'password'"
            label="Powtórz hasło"
            hint="Powtórz hasło"
            @click:append="showPassword = !showPassword"
            ></v-text-field>
        </v-form>
        <v-btn
        top="50"
        color=brown
        >Zarejestruj</v-btn>

    </div>
</div>

</template>

<style scoped>
*{
    font-size:14px;
}

.v-text-field{
    width: 400px;
}

.registerBox-login{
    margin-bottom: 50px;
    font-size: 2rem;

}


.registerBox{
    border-radius: 2%;
    border: 2px solid black;
    width: 40rem;
    height: 40rem;
    background-color: burlywood;
    justify-content: center;
    align-items: center;
    display: flex;
    flex-direction: column;

}

.container{
    background-image: url("../../public/img/login-biblioteka.jpg");
    background-size: cover;
    height: 100vh;
    align-items: center;
    display: flex;
    justify-content: center;
}

</style>