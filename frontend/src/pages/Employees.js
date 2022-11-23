import { useEffect, useState } from "react";
import { Container, Row, Col, Table, Button, Alert } from "react-bootstrap";
import axios from 'axios';

const Employees = () => {
    const [showAlert, setShowAlert] = useState(false);
    const [messageAlert, setMessageAlert] = useState('');
    const [employees, setEmployees] = useState([]);

    const getEmployees = async () => {
        try {
            let url = 'http://localhost:8080/employee';
            let response = await axios.get(url);
            if (response.status === 200) {
                setEmployees(response.data);
            }
        } catch (error) {
            console.log(error.message);
        }
    };

    const downloadEmployeesReport = async () => {
        try {
            let url = 'http://localhost:8080/employee/export';
            let response = await axios.get(url);
        } catch (error) {
            setShowAlert(true);
            setMessageAlert('No existen empleados suficientes.')
            console.log(error.message);
        }
    };

    useEffect(() => {
        getEmployees();
    }, []);

    return (
        <Container style={{marginTop: '70px'}}>
            <Row>
                <Col>
                    <h1>Lista de empleados</h1>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col lg="3" sm="4">
                    {/* <Button href="/employees/new">+ Nuevo Empleado</Button> */}
                    <Button variant="success" onClick={downloadEmployeesReport}>Descargar Reporte</Button>
                </Col>
                <Col lg="9" sm="8">
                    <Alert variant="danger" style={{width: "100%", height:"40px"}} show={showAlert} >
                        <p style={{marginTop: "-8px"}}>{messageAlert}</p>
                    </Alert>
                </Col>
            </Row>
            <Row>
                <Col cols="12">
                    <Table striped className="mt-4">
                        <thead>
                            <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Fecha de Nacimiento</th>
                            <th>Categoria</th>
                            <th>Fecha de Ingreso</th>
                            </tr>
                        </thead>
                        <tbody>
                            {employees.map((employee) => (
                                <tr key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.names}</td>
                                    <td>{employee.lastNames}</td>
                                    <td>{employee.bornDate}</td>
                                    <td>{employee.category}</td>
                                    <td>{employee.entryDate}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>
    );
};

export default Employees;