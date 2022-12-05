import axios from "axios";

const baseDomain = "http://localhost:8082";
const baseURL = `${baseDomain}/`

export default axios.create({
    baseURL,
    header: {
        "Authorization": localStorage.getItem('token')
    }
})