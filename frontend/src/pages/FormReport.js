//Importacion de librerias
import React, { useState } from 'react';
import { Form, Button, Col, Row, Container } from 'react-bootstrap';
import axios from 'axios';


const FormReport = () => {

    const[, setShowAlert] = useState(false);
    const[, setMessageAlert] = useState('');

    //Este componente se encargar 
    //de mandar peticiones get a la api
    //Un Boton para todos los reportes
    //Un boton para cada pedir por año
    //Un boton para pedir por mes

    const getAllReport = async () => {
        try {
            let url = 'http://localhost:8080/report';
            await axios.get(url);
        } catch (error) {
            setShowAlert(true);
            setMessageAlert('No existen empleados suficientes.')
            console.log(error.message);
        }
    };

    //Recibe un año y hace una peticion get a la api
    const getReportByYear = async (year) => {
        try {
            let url = 'http://localhost:8080/report/year';
            await axios.get(url+ '/' + year);
        } catch (error) {
            setShowAlert(true);
            setMessageAlert('No existen empleados suficientes.')
            console.log(error.message);
        }
    };

    //Recibe un mes y hace una peticion get a la api
    const getReportByMonth = async (month) => {
        try {
            let url = 'http://localhost:8080/report/month';
            await axios.get(url+ '/' + month);
        } catch (error) {
            setShowAlert(true);
            setMessageAlert('No existen empleados suficientes.')
            console.log(error.message);
        }
    };

    return (
        <Container style={{marginTop: '70px'}}>
            <Row>
                <Col>
                    <h1>Reportes</h1>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col lg="3" sm="4">
                    <Button variant="success" onClick={getAllReport}>Crear Todos los reportes</Button>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col lg="3" sm="4">
                    <Button variant="success" onClick={getReportByYear}>Crear reportes por año</Button>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col lg="3" sm="4">
                    <Button variant="success" onClick={getReportByMonth}>Crear reportes por mes</Button>
                </Col>
            </Row>
            <Form>
                <Form.Group as={Row} className="mb-3" controlId="formPlaintextEmail">
                    <Form.Label column sm="2">
                        Año
                    </Form.Label>
                    <Col sm="10">
                        <Form.Control type="text" placeholder="Año" />
                    </Col>
                </Form.Group>
            </Form>
            <Form>
                <Form.Group as={Row} className="mb-3" controlId="formPlaintextEmail">
                    <Form.Label column sm="2">
                        Mes
                    </Form.Label>
                    <Col sm="10">
                        <Form.Control type="text" placeholder="Mes" />
                    </Col>
                </Form.Group>
            </Form>
        </Container>
    );
}

export default FormReport;

