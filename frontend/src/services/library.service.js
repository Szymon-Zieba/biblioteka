import axios from "axios";

const API_URL = "http://localhost:8083";

const getLibraries = async () => {
  const response = await axios.get(`${API_URL}/libraries`);
  const libraries = await response.data;

  return libraries;
};

const addLibrary = (library) => {
  axios.post(`${API_URL}/library`, {
    city: library.city,
    email: library.email,
    phoneNumber: library.phoneNumber,
    postCode: library.postCode,
    streetAndNumber: library.streetAndNumber,
  });
};

const deleteLibraryById = (id) => {
  axios.delete(`${API_URL}/library/${id}`);
};

export { getLibraries, addLibrary, deleteLibraryById };
