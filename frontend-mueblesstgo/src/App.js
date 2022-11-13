import logo from './logo.svg';
import './App.module.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import FileUploadComponent from './components/FileUploadComponent';
import NavbarComponent from './components/NavbarComponent';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path= "/fileUpload" element={<FileUploadComponent />} />
      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
