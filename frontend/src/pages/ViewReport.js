import { useEffect, useState } from "react";
import { Container, Row, Col, Table, Button, Alert } from "react-bootstrap";
import axios from 'axios';

const ViewReport = () => {
    const [showAlert, setShowAlert] = useState(false);
    const [messageAlert, setMessageAlert] = useState('');
    const [reports, setReports] = useState([]);

    const getReports = async () => {
        try {
            let url = 'http://localhost:8080/template';
            let response = await axios.get(url);
            if (response.status === 200) {
                setReports(response.data);
            }
        } catch (error) {
            console.log(error.message);
        }
    };

    const downloadReports = async () => {
        try {
            let url = 'http://localhost:8080/template/export';
            await axios.get(url);
        } catch (error) {
            setShowAlert(true);
            setMessageAlert('No existen reportes suficientes.')
            console.log(error.message);
        }
    };

    useEffect(() => {
        getReports();
    }, []);

    return (
        <Container style={{marginTop: '70px'}}>
            <Row>
                <Col>
                    <h1>Planilla de sueldos</h1>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col lg="3" sm="4">
                    {/* <Button href="/employees/new">+ Nuevo Empleado</Button> */}
                    <Button variant="success" onClick={downloadReports}>Descargar Planilla de sueldo</Button>
                </Col>
                <Col lg="9" sm="8">
                    <Alert variant="danger" style={{width: "100%", height:"40px"}} show={showAlert} >
                        <p style={{marginTop: "-8px"}}>{messageAlert}</p>
                    </Alert>
                </Col>
            </Row>
            <Row>
                <Col cols="8">
                    <Table striped className="mt-4">
                        <thead>
                            <tr>
                            <th>ID</th>
                            <th>RUT</th>
                            <th>Nombre empleado</th>
                            <th>Categoria</th>
                            <th>Años de servicio empresa</th>
                            <th>Sueldo fijo mensual</th>
                            <th>Monto Bonificación años servicio</th> 
                            <th>Monto Pago Horas extras</th>
                            <th>Monto Descuento</th>
                            <th>Sueldo Bruto</th>
                            <th>Cotización Previsional</th>
                            <th>Cotización Salud</th>
                            <th>Monto sueldo final</th>
                            </tr>
                        </thead>
                        <tbody>
                            {reports.map((report, index) => (
                                <tr key={index}>
                                    <td>{report.id}</td>
                                    <td>{report.rut}</td>
                                    <td>{report.fullName}</td>
                                    <td>{report.category}</td>
                                    <td>{report.yearsCompany}</td>
                                    <td>{report.fixedSalary}</td>
                                    <td>{report.yearBonus}</td>
                                    <td>{report.extraHoursBonus}</td>
                                    <td>{report.discounts}</td>
                                    <td>{report.grossSalary}</td>
                                    <td>{report.pensionContribution}</td>
                                    <td>{report.healthContribution}</td>
                                    <td>{report.finalSalary}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>
    );
    
};

export default ViewReport;


