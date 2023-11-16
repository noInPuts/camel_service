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
            <Navbar expand="lg" bg="success" data-bs-theme="dark" className="navbar">
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


                            {['bottom'].map((placement) => (
                                <OverlayTrigger
                                    trigger="click"
                                    key={placement}
                                    placement={'bottom'}
                                    overlay={
                                        <Popover id={`popover-positioned-${placement}`}>
                                            <Popover.Header as="h3">{`cart`}</Popover.Header>
                                            <Popover.Body>
                                                <div className="col-md-4">
                                                    <div className="card mb-4">

                                                        <div className="card-body">
                                                            <ul className="list-group list-group-flush">
                                                                <li
                                                                    className="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                                                    Products
                                                                    <span>$53.98</span>
                                                                </li>
                                                                <li className="list-group-item d-flex justify-content-between align-items-center px-0">
                                                                    Shipping
                                                                    <span>Gratis</span>
                                                                </li>
                                                                <li
                                                                    className="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                                                    <div>
                                                                        <strong>Total amount</strong>
                                                                        <strong>
                                                                            <p className="mb-0">(including VAT)</p>
                                                                        </strong>
                                                                    </div>
                                                                    <span><strong>$53.98</strong></span>
                                                                </li>
                                                            </ul>

                                                            <button type="button" className="btn btn-primary btn-lg btn-block">
                                                                Go to checkout
                                                            </button></div></div></div>
                                            </Popover.Body>
                                        </Popover>
                                    }
                                >
                                    <Button variant="secondary">cart <Badge pill bg="danger">9</Badge></Button>
                                </OverlayTrigger>
                            ))}



                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}

