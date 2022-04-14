import {Link, useNavigate} from "react-router-dom";

import "./NotFoundPage.css";


export default function NotFoundPage() {

    const navigate = useNavigate()

    const toLogin = () => {
        navigate("/login")
    }


    return (
        <div className={'notfound'}>
            <label className={'page404'}>404</label>
            <label>Verlaufen? Diese Seite existiert nicht.</label>
            <Link to="/login" className="button404">
                <h1 className="press_start">Zur Anmeldung</h1>
            </Link>
        </div>
    )
}