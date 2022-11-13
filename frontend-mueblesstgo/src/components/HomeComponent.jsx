import React, { Component } from "react";
import "../assets/css/styles.css";

class HomeComponent extends Component {
    render() {
        return (
            <div>
                <h1 className="text-center"> <b1>MueblesStgo</b1></h1>
                <div class="box-area">
                    <div class="single-box">
                        <a href= "/fileUpload">
                            <div class="img-area">
                            </div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Cargar DATA.txt</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/lista">
                            <div class="img-area">
                            </div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Ver empleados</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/reportePlanilla">
                            <div class="img-area"></div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Planilla de sueldos</strong></span>
                            <p></p>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/subirJustificativo">
                            <div class="img-area"></div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Ingresar justificativos</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href= "/subirAutorizacion">
                        <div class="img-area"></div>
                    </a>
                    <div class="img-text">
                        <span class="header-text"><strong>Ingresar autorizaciones</strong></span>
                    </div>
                </div>
                </div>
            </div>
        );
    }
}

export default HomeComponent;