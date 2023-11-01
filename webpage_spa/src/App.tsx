import { Routes, Route } from 'react-router-dom'
import FrontPage from './pages/frontpage'
import NavBar from './components/navbar'
import CreateUser from './pages/create_user'

export default function App() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<FrontPage />} />
        <Route path="/create_user" element={<CreateUser />} />
      </Routes>
    </>
  )
}