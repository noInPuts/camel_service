import { useState } from "react";
import { Form, Button } from "react-bootstrap"
import Container from "react-bootstrap/Container"

export default function CreateUser() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    
    const createAccount = (e:any) => {    
        e.preventDefault();
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username: username, password: password })
        };
        
        fetch('http://localhost:8080/account/create', requestOptions)
            .then(response => console.log(response.json()));

        // TODO: Check for username and password is not empty
    }

    return (
        <>
            <Container>
                <h1>Create user</h1>
                <Form onSubmit={createAccount}>
                    <Form.Group>
                        <Form.Label>Username:</Form.Label>
                        <Form.Control required type="text" onChange={(e) => setUsername(e.target.value)} placeholder="Enter desired username" />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Password:</Form.Label>
                        <Form.Control required type="password"  onChange={(e) => setPassword(e.target.value)} placeholder="Enter desired password" />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Create Account
                    </Button>
                </Form>      
            </Container>
        </>
    )
}