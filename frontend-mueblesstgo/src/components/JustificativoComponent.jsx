import React, { Component } from "react";
import NavbarComponent3 from "./NavbarComponent3";
import styled from "styled-components";
import JustificativoService from "../services/JustificativoService";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import swal from 'sweetalert';

class JustificativoComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {
            rut: "",
          fecha: ""
        };
        this.changeRutHandler = this.changeRutHandler.bind(this);
        this.changeFechaHandler = this.changeFechaHandler.bind(this);
    }

    changeFechaHandler = (event) => {
        this.setState({ fecha: event.target.value });
        console.log(this.state.fecha);
    };

    changeRutHandler = (event) => {
        this.setState({ rut: event.target.value });
        console.log(this.state.rut);
    };
    
    ingresarJustificativo = (e) => {
        e.preventDefault();
        swal({
            title: "¿Está seguro de que desea enviar el justificativo?",
            text: "Una vez enviado, no podrá ser modificado. El empleado quedará JUSTIFICADO de su ausencia en la FECHA indicada.",
            icon: "warning",
            buttons: ["Cancelar", "Enviar"],
            dangerMode: true
        }).then(respuesta=>{
            if(respuesta){
                swal("Justificativo enviado correctamente!", {icon: "success", timer: "3000"});
                let justificativo = { rut: this.state.rut, fecha: this.state.fecha};
                console.log("justificativo => " + JSON.stringify(justificativo));
                JustificativoService.IngresarJustificativo(justificativo).then(
                    (res) => {
                    }
                  );
                }
            else{
                swal({text: "Justificativo no enviado.", icon: "error"});
            }
        });
    };

    
    render(){
        return(
            <div className="home">
                <NavbarComponent3 />
                <Styles>
                    <div className="mainclass">
                        <div className="form1">
                            <h1 className="text-center"><b>Justificativos</b></h1>
                            <div className="formcontainer">
                                <hr></hr>
                                <div className="container">
                                    <Form>
                                        <Form.Group className="mb-3" controlId="rut" onChange={this.changeRutHandler}>
                                            <Form.Label>Rut del empleado</Form.Label>
                                            <Form.Control type="rut" placeholder="Rut del empleado en formato xx.xxx.xxx-x" />
                                        </Form.Group>

                                        <Form.Group className="mb-3" controlId="fecha" onChange={this.changeFechaHandler}>
                                            <Form.Label>Fecha del justificativo</Form.Label>
                                            <Form.Control type="fecha" placeholder="Fecha en formato AAAA/MM/DD" />
                                        </Form.Group>
                                    </Form>
                                </div>
                                <Button className="boton" onClick={this.ingresarJustificativo}>Registrar Justificativo</Button>
                            </div>
                        </div>
                    </div>
                </Styles>
            </div>
        )
    }
}

export default JustificativoComponent;

const Styles = styled.div`

.text-center {
    text-align: center;
    justify-content: center;
    padding-top: 8px;
}


.mainclass{
    margin-top: 20px;
    display: flex;
    justify-content: center;
    font-family: Roboto, Arial, sans-serif;
    font-size: 15px;
}

.form1{
    border: 9px solid #f1f1f1;
}

input[type=rut], input[type=fecha] {
    width: 100%;
    padding: 16px 8px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

Button {
    background-color: #42bfbb;
    color: white;
    padding: 14px 0;
    margin: 10px 0;
    border: none;
    cursor: grabbing;
    width: 100%;
}

Button:hover {
    opacity: 0.8;
}

.formcontainer {
    text-align: left;
    margin: 24px 100px 12px;
}

.container {
    padding: 24px 0;
    text-align:left;
}

span.psw {
    float: right;
    padding-top: 0;
    padding-right: 15px;
}
`