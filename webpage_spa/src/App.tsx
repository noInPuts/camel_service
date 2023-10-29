import { Routes, Route } from 'react-router-dom'
import FrontPage from './pages/frontpage'
export default function App() {
  return (
    <Routes>
      <Route path="/" element={<FrontPage />} />
    </Routes>
  )
}