import {useNavigate} from "react-router-dom";
import {ColourChoice} from "../components/ColourChoice";
import {Solution} from "../components/Solution"
import {GuessBox} from "../components/GuessBox";
import "./GamePage.css"
import {HintBox} from "../components/HintBox";
import {AboutGame} from "../components/AboutGame";
import {useState} from "react";
import Game from "../models/Game";


export default function GamePage(){

    const navigate = useNavigate()

    const [game, setGame] = useState({} as Game);


    const startGame = () => {
        fetch(`${process.env.REACT_APP_BASE_URL}/api/game`, {
            method: 'POST',
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token') ?? 'no-token'}`
            }
        })
            .then(response => response.json())
            .then((game: Game) => setGame(game));
    };

    const checkGuess = () => {
        fetch(`${process.env.REACT_APP_BASE_URL}/api/game/${game.id}/guesses`, {
            method: 'POST',
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token') ?? 'no-token'}`
            },
            body:
        })
            .then(response => response.json())







            .then(guess: Guess) => setGuess(guess));
    };
// hier Arrays testen und Hints in Reihenfolge setzen
        //for(let i = 0; i < 4; i++){
        //if(solutionArray.includes(guessArray[i]){
        //  if(guessArray[i]) == solutionArray[i]{
        //      set hintArray[i] == ColoursForHints[0]
        //      }
        //  else set hintArray[i] == ColoursForHints[1]
        //}}



    // dann noch prüfen ob alle guesses schwarz sind
    // wenn ja, gewonnen (Solution einblenden und yay, gewonnen)
    // wenn nein, Zähler für Versuch überprüfen ob schon auf max Versuche
    // wenn max dann verloren und Solution einblenden
    // wenn noch nicht max Versuche dann nächsten Versuch freigeben, Zähler für Versuch hochzählen(?)

    //Spielregelbox: collapse? textbox



    return(
        <div className={'gamePage'}>



            <div>
                <fieldset className={'choiceBox'}>
                    <legend>Farbauswahl</legend>
                    <ColourChoice />
                </fieldset>
            </div>





            {game.id &&
                <div>
                    <fieldset className={'boxes'}>
                        <legend>Lösung</legend>
                        <Solution solution={game.solution} />
                    </fieldset>

                    <div className={'answer'}>
                        <fieldset className={"guessBox"}>
                            <legend>aktueller Versuch</legend>
                            <GuessBox guess={guess} />
                        </fieldset>
                        <button onClick={checkGuess}>prüfen</button>
                    </div>

                    {game.guesses.map(guess =>
                        <div className={'answer'}>
                            <fieldset className={"guessBox"}>
                                <legend>06. Versuch</legend>
                                <GuessBox guess={guess} />
                            </fieldset>
                            <div className={'hintBox'}>
                                <HintBox />
                            </div>
                        </div>
                    )}
                </div>
            }






            <div className={'navigationBar'}>
                <button onClick={() => {localStorage.setItem("token", "");
                    navigate("/login")}}>Abmelden</button>


                <button>Konto löschen</button>
                <button onClick={AboutGame}>Spielregeln</button>
                <button onClick={() => startGame()}>Neues Spiel</button>

            </div>
        </div>
    )
}