import {Link} from "react-router-dom";
import "./NotFoundPage.css";
import page404 from "../images/page404.png";


export default function NotFoundPage() {

    return (
        <div className={'notfound'}>
            <div>
                <img src={page404} alt={'Notfoundimage'} width="400" />
            </div>
            <div className={'text'}>
                <label className={'page404'}>404</label>
                <label className={'verlaufen'}>Verlaufen? Diese Seite existiert nicht.</label>
                <Link to="/login" className="button404">
                <h2 className="pressStart">Zur Anmeldung</h2>
                </Link>
            </div>
        </div>
    )
}