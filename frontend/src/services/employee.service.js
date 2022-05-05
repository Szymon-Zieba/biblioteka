import axios from "axios";

const API_URL = "http://localhost:8083";

const getEmployees = async () =>{
    const response = await axios.get(`${API_URL}/employees`)
    const employees =  await response.data;

    return employees;
}

const getEmployeeById = async (id) =>{
    const response = await axios.get(`${API_URL}/employees/${id}`)
    const employee =  await response.data;

    return employee;
}

const addEmployee = async (user) =>{
    await axios.post(`${API_URL}/employee`, {
    body: {
        email: user.email,
        phoneNumber: user.phoneNumber,
        firstName: user.firstName,
        lastName: user.lastName,
        streetNumber: user.streetNumber,
        zip: user.zip,
        role: {
            id:null,
            name:"ROLE_EMPLOYEE"
        },
        city: user.city,
        pesel: user.pesel}
    })

}
const deleteEmployeeById = async (id) =>{
    await axios.delete(`${API_URL}/employee/${id}`)
}
export {getEmployees, getEmployeeById, addEmployee, deleteEmployeeById}