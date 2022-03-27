const validatePassword = (password) => {
    return password.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/)
}

const validateEmail = (email) => {
    return email.match(/^\S+@\S+\.\S+$/)
}

export {
    validatePassword,
    validateEmail
}