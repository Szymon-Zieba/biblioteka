import axios from "axios";

const API_URL = "http://localhost:8083";

const getBooks = async () =>{
    const response = await axios.get(`${API_URL}/books`)
    const books =  await response.data

    return books
}

const getBookById = async (id) =>{
    const response = await axios.get(`${API_URL}/book/${id}`)
    const employee =  await response.data

    return employee
}

const addBook = async (book) =>{
    await axios.post(`${API_URL}/book`, book)  
}

const deleteBookById = async (id) =>{
    await axios.delete(`${API_URL}/book/${id}`)
}
export {getBooks, getBookById, addBook, deleteBookById}







