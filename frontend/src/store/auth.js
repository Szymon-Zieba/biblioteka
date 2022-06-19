import { defineStore } from "pinia";
import AuthService from "@/services/auth.service";
import { getLibrariesUser } from "../services/library.service"

const user = JSON.parse(localStorage.getItem("user"));
const initialState = user
  ? { status: { loggedIn: true }, user }
  : { status: { loggedIn: false }, user: null };

export const useAuth = defineStore("auth", {
  state: () => {
    return initialState;
  },
  actions: {
    async login(user) {
      return AuthService.login(user).then(
        async (user) => {

          await this.getUserLibraries(user);

          this.loginSuccess(user);
          
          return Promise.resolve(user);
        },
        (error) => {
          this.loginFailure();
          return Promise.reject(error);
        }
      );
    },
    logout() {
      AuthService.logout();
      this.logoutSuccess();
    },
    async register(user) {
      return AuthService.register(user).then(
        (response) => {
          this.registerSuccess();
          return Promise.resolve(response.data);
        },
        (error) => {
          this.registerFailure();
          return Promise.reject(error);
        }
      );
    },

    loginSuccess(_user) {
      this.status.loggedIn = true;
      this.user = _user;
    },
    loginFailure() {
      this.status.loggedIn = false;
      this.user = null;
    },
    logoutSuccess() {
      this.status.loggedIn = false;
      this.user = null;
    },
    registerSuccess() {
      this.status.loggedIn = false;
    },
    registerFailure() {
      this.status.loggedIn = false;
    },
    async getUserLibraries(user){
      const library = await getLibrariesUser(user.id)
      user.libraryId = library.id 
      localStorage.setItem("user", JSON.stringify(user))
    }
  },
});
