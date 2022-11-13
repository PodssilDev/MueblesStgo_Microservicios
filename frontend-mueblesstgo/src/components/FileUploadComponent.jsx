import React, { Component } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import NavbarComponent from "./NavbarComponent";
import FileUploadService from "../services/FileUploadService";
import styled from "styled-components";

class FileUploadComponent extends Component{
  constructor(props) {
    super(props);
    this.state = {
      file: null,
    };
    this.onFileChange = this.onFileChange.bind(this);
  }

  onFileChange(event) {
    this.setState({ file: event.target.files[0] });
  }
  
  onFileUpload = () => {
    const formData = new FormData();
    formData.append("file", this.state.file);
    FileUploadService.CargarArchivo(formData).then((res) => {
      window.location.href = "/";
    });
  };

  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <Styles>
          <div class="f">
            <div class="container">
              <h1><b>Cargar el archivo de datos</b></h1>
              <Row className="mt-4">
                <Col col="12">
                  <Form>
                    <Form.Group className="mb-3" controlId="file">
                      <Form.Control type="file" onChange={this.onFileChange} />
                    </Form.Group>
                    <Button varian="primary" onClick={this.onFileUpload}>
                      Subir</Button>
                  </Form>
                </Col>
              </Row>
            </div>
          </div>
        </Styles>
      </div>
    );
  }
}

export default FileUploadComponent;


const Styles = styled.div`
.container{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 2%;
}
.f{
  margin-top: 40px;
  border: 3px solid rgb(162, 161, 161);
  padding: 40px;
  padding-top: 10px;
  border-radius: 40px;
  margin-left: 300px;
  margin-right: 300px;
}
@media(max-width: 1200px){
  .f{margin-left: 200px;
    margin-right: 200px;}
  
}
`