import axios from "axios";

const API_URL = "http://localhost:8083";

const getBooks = async () =>{
    const response = await axios.get(`${API_URL}/books`)
    const books =  await response.data
    return books
}

const getBookById = async (id) =>{
    const response = await axios.get(`${API_URL}/book/${id}`)
    const book=  await response.data

    return book
}

const addBook = async (book) =>{
    await axios.post(`${API_URL}/book`, book)    
}

const updateBook = async (id, status) =>{
    console.log(id + ' '+ status)
    await axios.patch(`${API_URL}/book/${id}?status=${status}`)    
}

const deleteBookById = async (id) =>{
    await axios.delete(`${API_URL}/book/${id}`)
}
export {getBooks, getBookById, addBook, deleteBookById, updateBook}







