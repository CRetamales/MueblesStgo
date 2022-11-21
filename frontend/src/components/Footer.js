//Footer de la aplicacion
// Este esta al final de cada pagina de color negro 
// y con el nombre de la empresa en el centro

import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';

const Footer = () => {
    return (
        <footer className="mt-5 bg-dark text-white">
            <Container fluid={true}>
                <Row className="border-top justify-content-between p-3">
                    <Col className="p-0 text-center" md={3}>
                        <h3>MueblesStgo</h3>
                    </Col>
                    <Col className="p-0 d-flex justify-content-end " md={3}>
                        Creado por Carlos Retamales
                    </Col>
            
                </Row>
            </Container>
        </footer>
    )
}

export default Footer;