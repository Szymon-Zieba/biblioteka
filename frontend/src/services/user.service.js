import axios from "axios";

const API_URL = "http://localhost:8083";

const getUsers = async () =>{
    const response = await axios.get(`${API_URL}/users`)
    const users =  await response.data

    return users
}

const getUserById = async (id) =>{
    const response = await axios.get(`${API_URL}/user/${id}`)
    const user =  await response.data

    return user
}

const addUser = async (user) =>{
    await axios.put(`${API_URL}/user`, {
        body: user
    })  
}

const deleteUserById = async (user) =>{
    await axios.delete(`${API_URL}/book/${user}`)
}
export {getUsers, getUserById, addUser, deleteUserById}






