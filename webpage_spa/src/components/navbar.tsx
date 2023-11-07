import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Popover from 'react-bootstrap/Popover'
import Button from 'react-bootstrap/Button';
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Form from 'react-bootstrap/Form';
import Badge from 'react-bootstrap/Badge';


export default function NavBar() {


    return (
        <>
        <div className="jumbotron">
        <div className="container text-center">
          <h1>MTOGO</h1>      
        </div>
      </div>
            <Navbar expand="lg" bg="success" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="/">MTOGO</Navbar.Brand>
                    <Navbar.Toggle aria-controls="menu-navbar" />
                    <Navbar.Collapse id="menu-navbar">
                        <Nav className="me-auto">
                            <Nav.Link href="#">Pizza</Nav.Link>
                            <Nav.Link href="#">Burger</Nav.Link>
                            <Nav.Link href="#">Sushi</Nav.Link>
                        </Nav>

                        <Nav className="me-auto navbar-right">
                            {['bottom'].map((placement) => (
                                <OverlayTrigger
                                    trigger="click"
                                    key={placement}
                                    placement={'bottom'}
                                    overlay={
                                        <Popover id={`popover-positioned-${placement}`}>
                                            <Popover.Header as="h3">{`Login`}</Popover.Header>
                                            <Popover.Body>
                                                <Form>
                                                    <Form.Group className="mb-3" controlId="formBasicEmail">
                                                        <Form.Label>Email address</Form.Label>
                                                        <Form.Control type="email" placeholder="Enter email" />
                                                    </Form.Group>

                                                    <Form.Group className="mb-3" controlId="formBasicPassword">
                                                        <Form.Label>Password</Form.Label>
                                                        <Form.Control type="password" placeholder="Password" />
                                                    </Form.Group>
                                                    <Button variant="primary" type="submit">
                                                        Login
                                                    </Button>
                                                    <Button variant="primary" type="submit" href="/create_user">
                                                        Opret bruger
                                                    </Button>
                                                </Form>
                                            </Popover.Body>
                                        </Popover>
                                    }
                                >
                                    <Button variant="secondary">login</Button>
                                </OverlayTrigger>
                            ))}
                            <Nav.Link href="#">My Account</Nav.Link>
                            <Nav.Link href="#">cart <Badge pill bg="danger">9</Badge></Nav.Link>






                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}

