import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";


export const Login = () => {

    const[loginPlayername, setLoginPlayername] = useState("")
    const[loginPlayerPassword, setLoginPlayerPassword] = useState("")
    const[errorMessage, setErrorMessage] = useState("")
    const navigate = useNavigate()

    const login = () => {

       fetch(`${process.env.REACT_APP_BASE_URL}/api/login`, {
            method: "POST",
            body: JSON.stringify({
                "playername": loginPlayername,
                "password": loginPlayerPassword
            }),
            headers: {
                "Content-Type": "application/json"
            }
       })
            .then(response => {
                if (response.status === 200) {
                    return response.text()
                }
                throw new Error("Die Anmeldedaten sind nicht korrekt.")
            })
           .then((responseBody: string) => {
               localStorage.setItem('token', responseBody)
               navigate("/game")
           })
            .catch(e => setErrorMessage(e.message));
    }

    useEffect(() => {
            const timeout = setTimeout(() => setErrorMessage(''), 10000)
            return () => clearTimeout(timeout)
        }, [errorMessage]
    )

    const toRegistration = () => {
        navigate("/register")
    }

    return(

        <div className={'login'}>
            <div className={'loginError'}>{errorMessage}</div>
            <div>
            <input type={"text"} placeholder={"Spielername"} value={loginPlayername} onChange={ev => setLoginPlayername(ev.target.value)} /><br />
            <input type={"password"} placeholder={"Passwort"} value={loginPlayerPassword} onChange={ev => setLoginPlayerPassword(ev.target.value)} /><br />
            <button onClick={login}>Anmelden</button>
            </div><br />
            <div>
                <label>Noch nicht registriert? Dann hier entlang ➞ </label>
                <button onClick={toRegistration}>Registrierung</button>
            </div>
        </div>
    )
}