<script>
import { ref } from "vue";
import useUser from "@/composables/useUser";
import { useAuth } from "../store/auth";
import { updateUser, updateUserPrivateData } from "@/services/user.service";
import { useField, useForm } from "vee-validate";
import * as yup from "yup";

export default {
  setup() {
    const auth = useAuth();
    const id = auth.user.id;

    const { user, loadUser } = useUser(id);
    loadUser().then(() => {
      pesel.value = user.value.pesel;
    });

    const snackbar = ref(false);
    const snackbarText = ref("Zapisano zmiany!");

    function update() {
      updateUser(id, user.value).then(() => {
        snackbarText.value = "Zapisano zmiany";
        snackbar.value = true;
      });
    }

    const privateData = ref({
      newPassword: "",
      PESEL: "",
      oldPassword: "",
    });

    function updatePrivateData() {
      schema
        .validate({
          newPassword: newPassword.value,
          reNewPassword: reNewPassword.value,
          pesel: pesel.value,
          oldPassword: oldPassword.value,
        })
        .then(() => {
          privateData.value.PESEL = pesel.value;
          privateData.value.oldPassword = oldPassword.value;
          if (newPassword.value && newPassword.value !== "") {
            privateData.value.newPassword = newPassword.value;
          }
          updateUserPrivateData(id, privateData.value)
            .then(() => {
              snackbarText.value = "Zapisano zmiany";
              snackbar.value = true;
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

    function reset() {
      loadUser();
      pesel.value = user.value.pesel;
      newPassword.value = "";
      reNewPassword.value = "";
      privateData.value.newPassword = "";
      oldPassword.value = "";
    }

    const schema = yup.object({
      newPassword: yup
        .string()
        .min(8, "Hasło musi mieć przynajmniej 8 znaków")
        .nullable()
        .notRequired(),
      reNewPassword: yup
        .string()
        .oneOf([yup.ref("newPassword"), null], "Hasła muszą być takie same")
        .when("newPassword", {
          is: (newPassword) => newPassword?.length > 0,
          then: yup.string().required("Powtórz nowe hasło"),
        }),
      pesel: yup
        .string()
        .length(11, "PESEL składa się z dokładnie 11 znaków")
        .required("PESEL jest wymagany")
        .nullable(),
      oldPassword: yup.string().required("Aktualne hasło jest wymagane"),
    });

    useForm({
      validationSchema: schema,
    });

    const { value: newPassword, errorMessage: newPasswordError } =
      useField("newPassword");
    const { value: reNewPassword, errorMessage: reNewPasswordError } =
      useField("reNewPassword");
    const { value: pesel, errorMessage: peselError } = useField("pesel");
    const { value: oldPassword, errorMessage: oldPasswordError } =
      useField("oldPassword");

    return {
      tab: ref(null),
      snackbar,
      snackbarText,
      user,
      update,
      updatePrivateData,
      privateData,
      reset,
      newPassword,
      newPasswordError,
      reNewPassword,
      reNewPasswordError,
      pesel,
      oldPassword,
      oldPasswordError,
      peselError,
    };
  },
};
</script>

<template>
  <v-container>
    <v-tabs v-model="tab">
      <v-tab value="details">Dane osobowe</v-tab>
      <v-tab value="address">Adres</v-tab>
      <v-tab value="privacy">Prywatność</v-tab>
    </v-tabs>
    <div v-if="!user"></div>
    <v-window v-model="tab" justify="center" align="center" v-else>
      <!-- DANE OSOBOWE -->
      <v-window-item value="details">
        <v-form class="pt-12" style="width: 500px">
          <v-text-field
            v-model="user.firstName"
            variant="underlined"
            label="Imię"
          ></v-text-field>
          <v-text-field
            v-model="user.lastName"
            variant="underlined"
            label="Nazwisko"
          ></v-text-field>
          <v-text-field
            v-model="user.email"
            variant="underlined"
            label="Email"
          ></v-text-field>
          <v-text-field
            v-model="user.phoneNumber"
            variant="underlined"
            label="Numer telefonu"
          ></v-text-field>
        </v-form>
        <v-btn @click="update()" class="save-button mx-4" size="x-large"
          >ZAPISZ</v-btn
        >
        <v-btn @click="reset()" class="cancel-button mx-4" size="x-large"
          >ANULUJ</v-btn
        >
      </v-window-item>
      <!-- ADRES -->
      <v-window-item value="address">
        <v-form class="pt-12" style="width: 500px">
          <v-text-field
            v-model="user.streetNumber"
            variant="underlined"
            label="Ulica i numer"
          ></v-text-field>
          <v-text-field
            v-model="user.zip"
            variant="underlined"
            label="Kod pocztowy"
          ></v-text-field>
          <v-text-field
            v-model="user.city"
            variant="underlined"
            label="Miasto"
          ></v-text-field>
        </v-form>
        <v-btn @click="update()" class="save-button mx-4" size="x-large"
          >ZAPISZ</v-btn
        >
        <v-btn @click="reset()" class="cancel-button mx-4" size="x-large"
          >ANULUJ</v-btn
        >
      </v-window-item>
      <!-- PRYWATNOŚĆ -->
      <v-window-item value="privacy">
        <v-form class="pt-12" style="width: 500px">
          <v-text-field
            type="password"
            variant="underlined"
            label="Nowe hasło"
            name="newPassword"
            v-model="newPassword"
            :hint="newPasswordError"
            persistent-hint
          ></v-text-field>
          <v-text-field
            type="password"
            variant="underlined"
            label="Powtórz nowe hasło"
            name="reNewPassword"
            v-model="reNewPassword"
            :hint="reNewPasswordError"
            persistent-hint
          ></v-text-field>
          <v-text-field
            v-model="pesel"
            variant="underlined"
            label="PESEL"
            name="pesel"
            :hint="peselError"
            persistent-hint
          ></v-text-field>
          <v-divider class="my-4"></v-divider>
          <span class="text-caption"
            >Podaj aktualne hasło, aby zapisać zmiany.</span
          >
          <v-text-field
            type="password"
            v-model="oldPassword"
            variant="underlined"
            label="Aktualne hasło"
            name="oldPassword"
            :hint="oldPasswordError"
            persistent-hint
          ></v-text-field>
        </v-form>

        <v-btn
          @click="updatePrivateData()"
          class="save-button mx-4"
          size="x-large"
          >ZAPISZ</v-btn
        >
        <v-btn @click="reset()" class="cancel-button mx-4" size="x-large"
          >ANULUJ</v-btn
        >
      </v-window-item>
    </v-window>
    <v-snackbar v-model="snackbar">
      {{ snackbarText }}

      <template v-slot:actions>
        <v-btn color="blue" variant="text" @click="snackbar = false">
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </v-container>
</template>

<style scoped>
.save-button {
  background-color: rgb(23, 201, 100);
}

.cancel-button {
  background-color: rgb(210, 210, 210);
}
</style>
