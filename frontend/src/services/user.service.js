import axios from "axios";

const API_URL = "http://localhost:8083";

const getUsers = async () => {
  const response = await axios.get(`${API_URL}/users`);
  const users = await response.data;

  return users;
};

const getUserById = async (id) => {
  const response = await axios.get(`${API_URL}/user/${id}`);
  const user = await response.data;

  return user;
};

const updateUser = async (id, user) => {
  await axios.put(`${API_URL}/user/${id}`, user);
};

const updateUserPrivateData = async (id, privateDataRequest) => {
  await axios.patch(`${API_URL}/user/${id}`, privateDataRequest);
};

const deleteUserById = async (id) => {
  await axios.delete(`${API_URL}/user/${id}`);
};
export {
  getUsers,
  getUserById,
  updateUser,
  updateUserPrivateData,
  deleteUserById,
};
