<script>
  export default {
    data: () => ({
      valid: false,
      title: '',
      msg: '',
      msgRules: [
        v => !!v || 'Wiadomość jest wymagana',
      ],
      titleRules: [
        v => !!v || 'Tytuł jest wymagany',
      ],
      email: '',
      emailRules: [
        v => !!v || 'E-mail jest wymagany',
        v => /.+@.+/.test(v) || 'E-mail musi być poprawny',
      ],
    }),
  }
</script>

<template>
    <div class="imgBackgorund">
        <div class="imgBackgorundOpacity">
            <div class="img">
                <router-link to="/">
                    <v-img
                        src="@/assets/img/logo-library.png"
                        height="10rem"
                    ></v-img>
                </router-link>
            </div>
            <v-form class="form" v-model="valid">
                <v-divider></v-divider>
                <v-text-field
                    v-model="email"
                    label="E-mail"
                    :rules="emailRules"
                    maxlength="70"
                    single-line
                    full-width
                    required
                ></v-text-field>
                <v-divider></v-divider>
                <v-text-field
                    v-model="title"
                    label="Temat"
                    :rules="titleRules"
                    single-line
                    full-width
                    counter
                    maxlength="30"
                    required
                ></v-text-field>
                <v-divider></v-divider>
                <v-textarea
                    v-model="msg"
                    :rules="msgRules"
                    label="Wiadomość"
                    counter
                    maxlength="250"
                    full-width
                    required
                ></v-textarea>
                <div class="button">
                    <v-btn
                        class="btn"
                        size="x-large"
                        color="white"
                        type="submit"
                    >
                        Wyślij
                    </v-btn>
                </div>
            </v-form>
        </div>
    </div>
</template>

<style scoped>

.imgBackgorund{
    height: 100vh;
    background: url("@/assets/img/contactBackground.jpg");

}
.imgBackgorundOpacity{
    background-color:rgba(0, 0, 0, 0.6);
    height: 100vh;
    padding: 5rem;
}
.img{
    width: 15rem;
    margin: auto;
    margin-bottom: 5rem;
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