import Container from "react-bootstrap/Container"
import Button from "react-bootstrap/Button"
import Badge from "react-bootstrap/Badge"
export default function RestaurantMenu() {
    return (
        <>
            <Container>
                <div className="container-fluid">
                    <div className="row content">
                        <div className="col-sm-2 sidenav text-left">
                            <div className="card-header py-3">
                                <h5 className="mb-0">Menu</h5>
                                <p><a href="#">Almindelig pizza</a></p>
                                <p><a href="#">salat pizza</a></p>
                                <p><a href="#">Inbagt pizza</a></p>
                            </div>
                        </div>
                        <div className="col-sm-8 text-left">
                            <h1>nr 1. pepperoni</h1>
                            <div className="row">
                                <div className="col-sm-8">
                                    <p>Tomato, chese, pepperoni</p>
                                </div>
                                <div className="col-sm-2">
                                    <Button>add to cart</Button>

                                </div>
                            </div><hr></hr>

                            <h1>nr 1. pepperoni</h1>
                            <div className="row">
                                <div className="col-sm-8">
                                    <p>Tomato, chese, pepperoni</p>
                                </div>
                                <div className="col-sm-2">
                                    <Button>add to cart</Button>

                                </div>
                                <hr></hr>
                            </div>
                        </div>
                    </div>
</div>
            </Container >
        </>
    );
}