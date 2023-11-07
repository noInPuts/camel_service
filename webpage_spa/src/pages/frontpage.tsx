import Container from "react-bootstrap/Container"
import Button from "react-bootstrap/Button"
import Badge from "react-bootstrap/Badge"
export default function FrontPage() {
    return (
        <>
            <Container>
                <h1>Restaurants</h1>

                <div className="col-sm-8 text-left">
                    <h1>Tony's Pizza</h1>
                    <div className="row">
                        <div className="col-sm-8">
                            <p>Adress</p>
                            <br></br>
                            <p>rating</p>
                            </div>
                        <div className="col-sm-2">
                            <h2><Badge pill bg="success">open</Badge></h2> <br></br>
                            <p>opening hours</p>

                        </div>
                        </div>
                    <hr></hr>

                </div>
            </Container>
        </>
    );
}