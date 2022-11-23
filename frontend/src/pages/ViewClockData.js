import { useEffect, useState } from "react";
import { Container, Row, Col, Table } from "react-bootstrap";
import axios from 'axios';

const ViewClockData = () => {

    const [clockData, setClockData] = useState([]);

    const getClockData = async () => {
        try {
            let url = 'http://localhost:8080/mark';
            let response = await axios.get(url);
            if (response.status === 200) {
                setClockData(response.data);
            }
        } catch (error) {
            console.log(error.message);
        }
    }


    useEffect(() => {
        getClockData();
    }, []);

    return (
        <Container style={{marginTop: '70px'}}>
            <Row>
                <Col>
                    <h1>Lista de marcaciones</h1>
                </Col>
            </Row>
            <Row>
                <Col cols="12">
                    <Table striped className="mt-4">
                        <thead>
                            <tr>
                            <th>ID</th>
                            <th>Rut</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            </tr>
                        </thead>
                        <tbody>
                            {clockData.map((mark) => (
                                <tr key={mark.id}>
                                    <td>{mark.id}</td>
                                    <td>{mark.rut}</td>
                                    <td>{mark.date}</td>
                                    <td>{mark.hour}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>
    );
}

export default ViewClockData;