import axios from "axios";

const API_URL = "http://localhost:8083";

const getLibraries = async () =>{
    const response = await axios.get(`${API_URL}/libraries`)
    const libraries =  await response.data;

    return libraries;
}

export {getLibraries}