// Importar componentes
import React, { Component } from 'react';
import { Container, Row, Col, Table, Button, Alert } from "react-bootstrap";
import axios from 'axios';
import { Link } from 'react-router-dom';

// Crear componente
class ViewExtraHour extends Component {
    
        // Declaración de variables
        // Se declaran las variables que se utilizarán en el componente
        state = {
            showAlert: false,
            messageAlert: '',
            extraHours: [],
        }
    
        // Función para obtener los datos de las horas extras
        // Se obtienen los datos de las horas extras desde la API
        getExtraHours = async () => {
            try {
                let url = 'http://localhost:8080/hour';
                let response = await axios.get(url);
                if (response.status === 200) {
                    this.setState({
                        extraHours: response.data,
                    });
                }
            } catch (error) {
                console.log(error.message);
            }
        }
    
        // Función para eliminar una hora extra
        // Se envía el id de la hora extra a eliminar a la API
        deleteExtraHour = async (id) => {
            try {
                let url = 'http://localhost:8080/hour/' + id;
                let response = await axios.delete(url);
                if (response.status === 200) {
                    this.setState({
                        showAlert: true,
                        messageAlert: 'Hora extra eliminada correctamente.',
                    });
                    this.getExtraHours();
                }
            } catch (error) {
                this.setState({
                    showAlert: true,
                    messageAlert: 'Error al eliminar hora extra.',
                });
                console.log(error.message);
            }
        }
    
        // Función para mostrar el mensaje de alerta
        // Se muestra el mensaje de alerta si la variable showAlert es true
        showAlert = () => {
            if (this.state.showAlert) {
                return (
                    <Alert variant="success" onClose={() => this.setState({ showAlert: false })} dismissible>
                        <Alert.Heading>¡Éxito!</Alert.Heading>
                        <p>
                            {this.state.messageAlert}
                        </p>
                    </Alert>
                );
            }
        }
    
        // Función para mostrar las horas extras
        // Se muestran las horas extras en una tabla
        showExtraHours = () => {
            return (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>Rut</th>
                            <th>Fecha</th>
                            <th>Categoría</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.extraHours.map((extraHour) => (
                            <tr key={extraHour.id}>
                                <td>{extraHour.rut}</td>
                                <td>{extraHour.date}</td>
                                <td>{extraHour.category}</td>
                                <td>
                                    <Link to={"/editExtraHour/" + extraHour.id}>
                                        <Button variant="warning">Editar</Button>
                                    </Link>
                                    <Button variant="danger" onClick={() => this.deleteExtraHour(extraHour.id)}>Eliminar</Button>
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

            // Se obtienen los datos de las horas extras
            this.getExtraHours();

            return (
                <Container stye={{display: 'flex', justifyContent: 'center', marginTop: '90px'}}>
                    <Row className="mt-5">
                        <Col sm="8">
                            <h1>Horas Extras</h1>
                            {this.showAlert()}
                            {this.showExtraHours()}
                        </Col>
                    </Row>
                </Container>
            );
        }
    }

    // Exportar componente
    export default ViewExtraHour;
