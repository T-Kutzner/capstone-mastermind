import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";


export const Register = () => {

    const [registerPlayername, setRegisterPlayername] = useState("")
    const [registerPlayerPassword, setRegisterPlayerPassword] = useState("")
    const [registerPlayerPasswordAgain, setRegisterPlayerPasswordAgain] = useState("")
    const [errorMessage, setErrorMessage] = useState("")
    const navigate = useNavigate()

    const register = () => {
        if(!(registerPlayerPassword === registerPlayerPasswordAgain)) {
            setErrorMessage("Die Passwörter stimmen nicht überein.")
        }
        else {
            fetch(`${process.env.REACT_APP_BASE_URL}/api/players`, {
                method: "POST",
                body: JSON.stringify({
                    "playername": registerPlayername,
                    "password": registerPlayerPassword,
                    "passwordAgain": registerPlayerPasswordAgain
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => {
                    if (response.status === 200) {
                        return response.text()
                    }
                    throw new Error("Der Spielername ist bereits vergeben.")
                })
                .then(() => {
                    navigate("/login")
                })
                .catch(e => setErrorMessage(e.message));
        }
    }

    useEffect(() => {
        const timeout = setTimeout(() => setErrorMessage(''), 10000)
        return () => clearTimeout(timeout)
        }, [errorMessage]
    )

    const toLogin = () => {
        navigate("/login")
    }


    return (

        <div className={'register'}>
            <div className={'registerError'}>{errorMessage}</div>
            <div>
            <input type={"text"} placeholder={"Spielername"} value={registerPlayername}
                   onChange={ev => setRegisterPlayername(ev.target.value)}/><br/>
            <input type={"password"} placeholder={"Passwort"} value={registerPlayerPassword}
                   onChange={ev => setRegisterPlayerPassword(ev.target.value)}/><br/>
            <input type={"password"} placeholder={"Passwort wiederholen"} value={registerPlayerPasswordAgain}
                   onChange={ev => setRegisterPlayerPasswordAgain(ev.target.value)}/><br/>
            <button onClick={register}>Registrieren</button>
            </div><br/>
            <div>
                <label>Doch schon registriert? Dann hier wieder zurück ➞ </label>
                <button onClick={toLogin}>Einloggen</button>
            </div>
        </div>
    )
}