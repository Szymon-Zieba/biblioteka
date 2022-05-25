import axios from "axios";

const API_URL = "http://localhost:8083";

const getSettlementsByUserId = async (id) =>{
    const response = await axios.get(`${API_URL}/settlements/user/${id}`)
    const settlement_userId =  await response.data

    return settlement_userId
}

const getSettlementById = async (id) =>{
    const response = await axios.get(`${API_URL}/settlement/${id}`)
    const settlement =  await response.data

    return settlement
}

const addSettlement = (settlement) => {
  axios.post(`${API_URL}/settlement`, {
    amount: settlement.amount,
    hire_id: settlement.hire_id,
  });
};

export { getSettlementsByUserId, getSettlementById, addSettlement};
