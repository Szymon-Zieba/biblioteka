import axios from "axios";

const API_URL = "http://localhost:8083/auth/";

class AuthService {
  async login(user) {
    return await axios
      .post(API_URL + "login", {
        email: user.email,
        password: user.password,
      })
      .then((response) => {
        if (response.data.token) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }
        return response.data;
      })
      .catch((error) => {
        return error.response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  async register(user) {
    return axios.post(API_URL + "register", {
      email: user.email,
      password: user.password,
    });
  }
}

export default new AuthService();
