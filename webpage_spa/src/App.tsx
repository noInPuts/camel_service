import { Routes, Route } from 'react-router-dom'
import FrontPage from './pages/frontpage'
import NavBar from './components/navbar'
import CreateUser from './pages/create_user'
import RestaurantMenu from './pages/Resturant_menu'
import CartPage from './pages/cart'
import AdminLoginPage from './pages/Admin_login'
import ResturantLoginPage from './pages/Resturant_login'
import AccountPage from './pages/Account'

export default function App() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<FrontPage />} />
        <Route path="/create_user" element={<CreateUser />} />
        <Route path="/Resturant_menu" element={<RestaurantMenu/>} />
        <Route path="/cart" element={<CartPage/>} />
        <Route path="/account" element={<AccountPage/>} />
        <Route path="/Admin_login" element={<AdminLoginPage/>} />

        <Route path='/Resurant_login' element={<ResturantLoginPage/>} />
      </Routes>
    </>
  )
}