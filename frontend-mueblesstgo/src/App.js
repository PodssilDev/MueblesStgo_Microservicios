import logo from './logo.svg';
import './App.module.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import FileUploadComponent from './components/FileUploadComponent';
import FileInformationComponent from './components/FileInformationComponent';
import EmployeeComponent from './components/EmployeeComponent';
import JustificativoComponent from './components/JustificativoComponent';
function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path= "/subir-archivo" element={<FileUploadComponent />} />
        <Route path= "/informacion-archivo" element={<FileInformationComponent />} />
        <Route path= "/lista-empleados" element={<EmployeeComponent />} />
        <Route path= "/justificativo" element={<JustificativoComponent />} />
      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
