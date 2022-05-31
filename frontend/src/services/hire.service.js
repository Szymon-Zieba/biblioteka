import axios from "axios";

const API_URL = "http://localhost:8083";

const getHireById = async (id) =>{
    const response = await axios.get(`${API_URL}/hire/${id}`)
    const hire =  await response.data;

    return hire;
}

const addHire = async (hire) =>{
    await axios.post(`${API_URL}/hire`, {
        body: hire
    })  
}

const getHireByUserId = async (id) =>{
    const response = await axios.get(`${API_URL}/hire/user/${id}`)
    const hire =  await response.data;

    return hire;
}

const getHireByLibraryId = async (id) =>{
    const response = await axios.get(`${API_URL}/hire/library/${id}`)
    const hire =  await response.data;

    return hire;
}

export {getHireById, addHire, getHireByUserId , getHireByLibraryId }

