import './App.css';
import { Routes, Route } from "react-router-dom";
import Layout from './Layout';
import { Container } from 'react-bootstrap';

import Home from './pages/Home';
import Employees from './pages/Employees';
import UploadClockData from './pages/UploadClockData';
import ViewClockData from './pages/ViewClockData';


function App() {
  return (
    <Layout>
      <Container>
        <Routes>
          
          <Route path='/' element={<Home/>} />
          <Route path='/employees' element={<Employees/>} exact/>
          <Route path='/mark/upload' element={<UploadClockData/>} exact />
          <Route path='/mark' element={<ViewClockData/>} exact />


        </Routes>
      </Container>
    </Layout>
  );
}

export default App;