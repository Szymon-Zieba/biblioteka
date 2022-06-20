<script>
import { ref } from "vue";
import { useAuth } from "../store/auth";
import { useField, useForm } from "vee-validate";
import * as yup from "yup";
import { useRouter } from "vue-router";

export default {
  setup() {
    const showPassword = ref(false);

    const auth = useAuth();

    const user = ref({
      email: "",
      password: "",
    });

    const router = useRouter();

    const snackbar = ref(false);
    const snackbarText = ref("");

    function register() {
      schema
        .validate({
          password: password.value,
          rePassword: rePassword.value,
          email: email.value,
        })
        .then(() => {
          user.value.email = email.value;
          user.value.password = password.value;
          auth
            .register(user.value)
            .then((response) => {
              if (response.message) {
                snackbarText.value = response.message;
                snackbar.value = true;
              }
            })
            .catch((error) => {
              snackbarText.value = error.response.data.message;
              snackbar.value = true;
            });
        })
        .catch((error) => {
          snackbar.value = true;
          snackbarText.value = error.errors[0];
        });
    }

    const schema = yup.object({
      password: yup
        .string()
        .min(8, "Hasło musi mieć przynajmniej 8 znaków")
        .nullable()
        .notRequired(),
      rePassword: yup
        .string()
        .oneOf([yup.ref("password"), null], "Hasła muszą być takie same")
        .when("password", {
          is: (password) => password?.length > 0,
          then: yup.string().required("Powtórz nowe hasło"),
        }),
      email: yup.string().email().required("Email jest wymagany"),
    });

    useForm({
      validationSchema: schema,
    });

    const { value: password, errorMessage: passwordError } =
      useField("password");
    const { value: rePassword, errorMessage: rePasswordError } =
      useField("rePassword");
    const { value: email, errorMessage: emailError } = useField("email");

    return {
      router,
      showPassword,
      user,
      password,
      passwordError,
      rePassword,
      rePasswordError,
      email,
      emailError,
      snackbar,
      snackbarText,
      register,
    };
  },
};
</script>

<template>
  <div class="container">
    <v-img
      @click="router.push({ name: 'home' })"
      class="ma-16"
      style="opacity: 75%; cursor: pointer"
      src="@/assets/img/logo-library.png"
    ></v-img>
    <div class="registerBox">
      <div class="registerBox-register">REJESTRACJA</div>
      <v-form>
        <!-- E-mail input -->
        <v-text-field
          v-model="email"
          append-icon="mdi-account"
          label="E-mail"
          name="email"
          :hint="emailError"
          persistent-hint
        ></v-text-field>

        <!-- Password input -->
        <v-text-field
          v-model="password"
          :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
          :type="showPassword ? 'text' : 'password'"
          label="Hasło"
          @click:append="showPassword = !showPassword"
          name="password"
          :hint="passwordError"
          persistent-hint
        ></v-text-field>

        <!-- Re-Password input -->
        <v-text-field
          v-model="rePassword"
          :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
          :type="showPassword ? 'text' : 'password'"
          label="Powtórz hasło"
          @click:append="showPassword = !showPassword"
          name="rePassword"
          :hint="rePasswordError"
          persistent-hint
        ></v-text-field>
      </v-form>
      <v-btn size="x-large" top="50" color="brown" @click="register()"
        >ZAREJESTRUJ</v-btn
      >

      <router-link style="color: black; margin-top: 70px" to="/login"
        >Masz juz konto? Zaloguj</router-link
      >
    </div>
  </div>
  <v-snackbar v-model="snackbar">
    {{ snackbarText }}

    <template v-slot:actions>
      <v-btn color="blue" variant="text" @click="snackbar = false">
        Close
      </v-btn>
    </template>
  </v-snackbar>
</template>

<style scoped>
* {
  font-size: 14px;
}

.v-text-field {
  width: 400px;
}

.registerBox-register {
  font-weight: bold;
  margin-bottom: 50px;
  font-size: 2rem;
}

.registerBox {
  width: 40rem;
  height: 100%;
  background-color: burlywood;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
}

.container {
  background-image: url("../../public/img/home-background-image.jpg");
  background-size: cover;
  height: 100vh;
  display: flex;
  justify-content: right;
}
</style>
