import Container from "react-bootstrap/Container"
import Button from "react-bootstrap/Button"
import Badge from "react-bootstrap/Badge"
export default function RestaurantMenu() {
    return (
        <>
            <Container>
                <h1>Restaurants</h1>

                <div className="col-sm-8 text-left">
                    <h1>Nr. 1 pepperoni</h1>
                    <div className="row">
                        <div className="col-sm-8">
                            <p>tomat, ost pepperoni</p>
                        
                            </div>
                        <div className="col-sm-2">
                            <Button>Add to cart </Button>

                        </div>
                        </div>
                    <hr></hr>

                </div>                <div className="col-sm-8 text-left">
                    <h1>Nr. 1 pepperoni</h1>
                    <div className="row">
                        <div className="col-sm-8">
                            <p>tomat, ost pepperoni</p>
                        
                            </div>
                        <div className="col-sm-2">
                            <Button>Add to cart </Button>

                        </div>
                        </div>
                    <hr></hr>

                </div>
            </Container>
        </>
    );
}