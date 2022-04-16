import {useNavigate} from "react-router-dom";
import {ColourChoice} from "../components/ColourChoice";
import {SolutionColours} from "../components/SolutionColours"
import {Guesses} from "../components/Guesses";
import "./GamePage.css"


export default function GamePage(){

    const navigate = useNavigate()


    return(
        <div className={'gamePage'}>





            <div>
                <fieldset className={'choiceBox'}>
                    <legend>Farbauswahl</legend>
                    <ColourChoice />
                </fieldset>
            </div>

            <div>
                <fieldset className={'boxes'}>
                    <legend>Lösung</legend>
                    <SolutionColours />
                </fieldset>


                <fieldset className={'guessBox'}>
                    <legend>12. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>11. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>10. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>09. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>08. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>07. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>06. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>05. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>04. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>03. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>02. Versuch</legend>
                    <Guesses />
                </fieldset>

                <fieldset className={"guessBox"}>
                    <legend>01. Versuch</legend>
                    <Guesses />
                </fieldset>
            </div>

            <div className={'navigationBar'}>
                <button onClick={() => {localStorage.setItem("token", "");
                    navigate("/login")}}>Abmelden</button>

                <button>Neues Spiel</button>
                <button>Konto löschen</button>
                <button>Spielregeln</button>
            </div>

        </div>
    )
}