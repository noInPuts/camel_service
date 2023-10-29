import { Routes, Route } from 'react-router-dom'
import FrontPage from './pages/frontpage'
import NavBar from './components/navbar'

export default function App() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<FrontPage />} />
      </Routes>
    </>
  )
}