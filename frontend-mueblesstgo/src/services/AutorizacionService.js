import axios from "axios";

const API_URL = "http://localhost:8080/autorizacion";

class AutorizacionService {
    
    IngresarAutorizacion(autorizacion){
        return axios.post(API_URL, autorizacion);
    }
}

export default new AutorizacionService();