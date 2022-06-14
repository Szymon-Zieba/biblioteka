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

const getHiresByUserId = async (id) =>{
    const response = await axios.get(`${API_URL}/hires/user/${id}`)
    const hires =  await response.data;

    return hires;
}

const getHiresByLibraryId = async (id) =>{
    const response = await axios.get(`${API_URL}/hires/library/${id}`)
    const hires =  await response.data;

    return hires;
}

export {getHireById, addHire, getHiresByUserId , getHiresByLibraryId }

