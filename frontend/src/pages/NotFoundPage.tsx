import {useNavigate} from "react-router-dom";

import "./NotFoundPage.css";


export default function NotFoundPage() {

    const navigate = useNavigate()

    const toLogin = () => {
        navigate("/login")
    }


    return (
        <div className={'notfound'}>
            <label>404</label>
            <label>Verlaufen? Diese Seite existiert nicht.</label>
            <button onClick={toLogin}>Zur Anmeldung</button>
        </div>
    )
}