// Importar componentes
import React, { Component } from 'react';
import { Container, Row, Col, Table, Button, Alert } from "react-bootstrap";
import axios from 'axios';
import { Link } from 'react-router-dom';

// Crear componente
class ViewJustification extends Component {

    // Declaración de variables
    // Se declaran las variables que se utilizarán en el componente
    state = {
        showAlert: false,
        messageAlert: '',
        justifications: [],
    }

    // Función para obtener los datos de las justificaciones
    // Se obtienen los datos de las justificaciones desde la API
    getJustifications = async () => {
        try {
            let url = 'http://localhost:8080/justification';
            let response = await axios.get(url);
            if (response.status === 200) {
                this.setState({
                    justifications: response.data,
                });
            }
        } catch (error) {
            console.log(error.message);
        }
    }

    // Función para eliminar una justificación
    // Se envía el id de la justificación a eliminar a la API
    deleteJustification = async (id) => {
        try {
            let url = 'http://localhost:8080/justification/' + id;
            let response = await axios.delete(url);
            if (response.status === 200) {
                this.setState({
                    showAlert: true,
                    messageAlert: 'Justificación eliminada correctamente.',
                });
                this.getJustifications();
            }
        } catch (error) {
            this.setState({
                showAlert: true,
                messageAlert: 'Error al eliminar justificación.',
            });
            console.log(error.message);
        }
    }

    // Función para mostrar el mensaje de alerta
    // Se muestra el mensaje de alerta si la variable showAlert es true
    showAlert = () => {
        if (this.state.showAlert) {
            return (
                <Alert variant='success' onClose={() => this.setState({ showAlert: false })} dismissible>
                    {this.state.messageAlert}
                </Alert>
            );
        }
    }

    // Funcion para mostrar las justificaciones
    // Se muestran las justificaciones en una tabla
    showJustifications = () => {
        return (
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Categoria</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.justifications.map((justification) => (
                        <tr key={justification.id}>
                            <td>{justification.id}</td>
                            <td>{justification.date}</td>
                            <td>{justification.category}</td>
                            <td>
                                <Link to={'/edit-justification/' + justification.id}>
                                    <Button variant='warning'>Editar</Button>
                                </Link>
                                <Button variant='danger' onClick={() => this.deleteJustification(justification.id)}>Eliminar</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        );
    }

    // Función para mostrar el componente
    // Se muestra el componente
    render() {

        // Se obtienen los datos de las justificaciones
        this.getJustifications();

        return (
            <Container>
                <Row>
                    <Col>
                        <h1>Justificaciones</h1>
                        {this.showAlert()}
                        {this.showJustifications()}
                    </Col>
                </Row>
            </Container>
        );
    }
}

// Exportar componente
export default ViewJustification;
