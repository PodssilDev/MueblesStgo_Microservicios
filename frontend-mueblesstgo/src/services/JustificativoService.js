import axios from "axios";

const API_URL = "http://localhost:8080/justificativo";

class JustificativoService {
    
    IngresarJustificativo(justificativo){
        return axios.post(API_URL, justificativo);
    }
}

export default new JustificativoService();