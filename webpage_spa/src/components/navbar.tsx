import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';

export default function NavBar() {
    return (
        <>
            <Navbar expand="lg" bg="success" data-bs-theme="dark"> 
                <Container>
                    <Navbar.Brand href="/">MTOGO</Navbar.Brand>
                    <Navbar.Toggle aria-controls="menu-navbar" />
                    <Navbar.Collapse id="menu-navbar">
                        <Nav className="me-auto">
                            <Nav.Link href="/">Forside</Nav.Link>
                            <Nav.Link href="/create_user">Opret bruger</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}

