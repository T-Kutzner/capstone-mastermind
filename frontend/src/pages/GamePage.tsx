import {useNavigate} from "react-router-dom";
import {ColourChoice} from "../components/ColourChoice";
import {SolutionColours} from "../components/SolutionColours"



export default function GamePage(){

    const navigate = useNavigate()


    return(
        <div className={'gamePage'}>
            <div>
                <ColourChoice />
            </div>
            <div>
                <SolutionColours />
            </div>
            <div>
                <button onClick={() => {localStorage.setItem("token", "");
                                        navigate("/login")}}>Logout</button>
            </div>
        </div>
    )
}