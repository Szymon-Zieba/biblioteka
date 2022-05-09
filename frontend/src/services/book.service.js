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
    await axios.post(`${API_URL}/book`, {
        body: book
    })  
}

const deleteBookById = async (id) =>{
    await axios.delete(`${API_URL}/book/${id}`)
}
export {getBooks, getBookById, addBook, deleteBookById}

// {
//     id: 46,
//     title: "Piotruś pan",
//     author: [
//         {
//             id: 75,
//             name: "Adam",
//             lastName: "Jakiś"
//         },
//         {
//             id: 74,
//             name: "Ja",
//             lastName: "Nieja"
//         }
//     ],
//     publishmentYear: "2000",
//     publishmentHouse: {
//         id: 10,
//         name: "Wydawnictwo"
//     },
//     category: {
//         id: 12,
//         name: "dramat"
//     },
//     description: "dsadasdasdsadsadasdasas",
//     imgUrl: "dsadasdasdsadasdsa"
// }





