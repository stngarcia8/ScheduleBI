import { BrowserRouter as Router, Route } from 'react-router-dom'
import Header from './components/Header'
import Footer from './components/Footer'
import Home from './containers/Home'

function App() {
  return (
    <div class="container content-space-2 content-space-lg-3">
      <Header />
      <Router>
        <Home />
      </Router>
      <Footer />
    </div>

  )
}

export default App
