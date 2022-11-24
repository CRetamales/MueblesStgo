//Importaciones de librerias
import { useEffect, useState } from "react";
import { Container, Row, Col, Table, Button, Alert } from "react-bootstrap";
import axios from 'axios';

//Componente de React
//Siendo un componente de React, 
//que se encarga de mostrar un formulario para registrar horas extras
//y luego enviar los datos a la API en formato JSON
const FormExtraHour = () => {
    
        //Declaración de variables
        //Se declaran las variables que se utilizarán en el componente
        const [showAlert, setShowAlert] = useState(false);
        const [messageAlert, setMessageAlert] = useState('');
        const [employees, setEmployees] = useState([]);
        const [rut, setRut] = useState('');
        const [date, setDate] = useState('');
        const [category, setCategory] = useState('');
    
        //Función para obtener los datos de los empleados
        //Se obtienen los datos de los empleados desde la API
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
    
        //Función para enviar los datos de la hora extra
        //Se envían los datos de la hora extra a la API
        const sendExtraHour = async () => {
            try {
                let url = 'http://localhost:8080/hour';
                let data = {
                    rut: rut,
                    date: date,
                    category: category,
                };

                
                //Cambiar el formato de la fecha
                //Se cambia el formato de la fecha para que sea compatible con la API
                //yyyy-mm-dd a yyyy/mm/dd
                let dateArray = data.date.split('-');
                data.date = dateArray[0] + '/' + dateArray[1] + '/' + dateArray[2];
                
                let response = await axios.post(url, data);
                setMessageAlert(response);
                if (response.status === 200) {
                    setShowAlert(true);
                    setMessageAlert('Hora extra registrada correctamente.');
                }
            } catch (error) {
                setShowAlert(true);
                setMessageAlert('Error al registrar hora extra');
                console.log(error.message);
            }
        };

        //Función para obtener los datos de los empleados
        //Se obtienen los datos de los empleados desde la API
        useEffect(() => {
            getEmployees();
        }, []);
    
        //Retorno del componente
        //Se retorna el componente con el formulario para registrar horas extras
        return (
            <Container style={{marginTop: '70px'}}>
                <Row>
                    <Col>
                        <h1>Registrar hora extra</h1>
                    </Col>
                </Row>
                <Row className="mt-2">
                    <Col lg="3" sm="4">
                        <Button variant="success" onClick={sendExtraHour}>Registrar hora extra</Button>
                    </Col>
                    <Col lg="9" sm="8">
                        <Alert variant="danger" style={{width: "100%", height:"40px"}} show={showAlert} >
                            {messageAlert}
                        </Alert>
                    </Col>
                </Row>
                <Row className="mt-4">
                    <Col>
                        <Table striped>
                            <thead>
                                <tr>
                                    <th>Rut</th>
                                    <th>Fecha</th>
                                    <th>Categoria</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <select className="form-select" aria-label="Default select example" onChange={(e) => setRut(e.target.value)}>
                                            <option value="">Seleccione un empleado</option>
                                            {employees.map((employee, index) => (
                                                <option key={index} value={employee.rut}>{employee.rut}</option>
                                            ))}
                                        </select>
                                    </td>
                                    <td>
                        
                                        <input type="date" className="form-control" onChange={(e) => setDate(e.target.value)} />

                                    </td>
                                    <td>
                                        <select className="form-select" aria-label="Default select example" onChange={(e) => setCategory(e.target.value)}>
                                            <option value="">Seleccione una categoria</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                        </select>
                                    </td>
                                </tr>
                            </tbody>
                        </Table>
                    </Col>
                </Row>
            </Container>
        );
};

//Exportación del componente
export default FormExtraHour;




    
