import axios from "axios";

const API_URL = "http://localhost:8083";

const getGiveBacksByUserId = async (id) =>{
    const response = await axios.get(`${API_URL}/givebacks/user/${id}`)
    const giveback_userId =  await response.data

    return giveback_userId
}

const getGiveBackById = async (id) =>{
    const response = await axios.get(`${API_URL}/giveback/${id}`)
    const giveback =  await response.data

    return giveback
}

const addGiveBack = (giveback) => {
  axios.post(`${API_URL}/giveback`, giveback);
};

export { getGiveBacksByUserId, getGiveBackById, addGiveBack};
