import Container from "react-bootstrap/Container"
import Button from "react-bootstrap/Button"
import Badge from "react-bootstrap/Badge"
import Form from 'react-bootstrap/Form';
export default function AdminLoginPage() {
    return (
        <>
            <form>
  <div className="form-outline mb-4">
    <input type="email" id="form2Example1" className="form-control" />
    <label className="form-label" >Email address</label>
  </div>

  <div className="form-outline mb-4">
    <input type="password" id="form2Example2" className="form-control" />
    <label className="form-label">Password</label>
  </div>

  <div className="row mb-4">


  <button type="button" className="btn btn-primary btn-block mb-4">Sign in</button>

  </div>
</form>
            
        </>
    );
}