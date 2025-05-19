import Navigation from './component/navigation/Navigation'
import Footer from './component/Footer'

import { Outlet } from 'react-router'


function App() {

  return (
    <>
      <Navigation />
      <Outlet/>
      <Footer />
    </>
  )
}

export default App
