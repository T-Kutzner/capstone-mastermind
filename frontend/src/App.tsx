import React from 'react';
import "./App.css"
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import  LoginPage from './pages/LoginPage';
import  RegisterPage from './pages/RegisterPage';
import GamePage from "./pages/GamePage";

function App() {


    return (
        <div className="App">
            <h1 id={'master'}>Mastermind</h1>
            <BrowserRouter>
                <Routes>
                    <Route path='/login' element={<LoginPage />} />
                    <Route path="/register" element={<RegisterPage />} />
                    <Route path="/game" element={<GamePage />} />
                    <Route path="/logout" />
                    <Route path="/*" element={<App />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
