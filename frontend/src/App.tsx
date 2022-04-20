import React from 'react';
import "./App.css"
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import  LoginPage from './pages/LoginPage';
import  RegisterPage from './pages/RegisterPage';
import GamePage from './pages/GamePage';
import NotFoundPage from './pages/NotFoundPage';


function App() {

    return (
        <div className="App">
            <h1 id={'master'}>Mastermind</h1>
            <BrowserRouter>
                <Routes>
                    <Route path="/*" element={<NotFoundPage />} />
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/register" element={<RegisterPage />} />
                    <Route path="/game" element={<GamePage />} />
                    <Route path="/logout" />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;