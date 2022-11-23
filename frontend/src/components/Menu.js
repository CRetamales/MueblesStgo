import { Nav, Navbar, Container, NavDropdown } from 'react-bootstrap';

const Menu = () => {
    return (
        <Navbar bg="dark" variant="dark" expand="lg">
            <Container>
                <Navbar.Brand href="/">MueblesStgo</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/employees">Empleados</Nav.Link>
                        <NavDropdown title="Marcas de Reloj" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/mark">Marcas de Reloj</NavDropdown.Item>
                            <NavDropdown.Item href="/mark/upload">Subir Marcas de Reloj</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Justificativos" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/justification">Justificativos</NavDropdown.Item>
                            <NavDropdown.Item href="/justification/make">Crear Justificativos</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Horas Extra" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/extrahour">Horas Extra</NavDropdown.Item>
                            <NavDropdown.Item href="/extrahour/make">Crear Horas Extra</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Reporte" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/report">Reporte</NavDropdown.Item>
                            <NavDropdown.Item href="/report/make">Crear Reporte</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>

    )
};

export default Menu;