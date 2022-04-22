import {useNavigate} from "react-router-dom";
import {ColourChoice} from "../components/ColourChoice";
import {Solution} from "../components/Solution"
import {GuessBox} from "../components/GuessBox";
import "./GamePage.css"
import {HintBox} from "../components/HintBox";
import {AboutGame} from "../components/AboutGame";
import {useState} from "react";
import Game, {Colour, Guess} from "../models/Game";
import {GuessedBox} from "../components/GuessedBox";


export default function GamePage(){

    const standardColour = {colours: [Colour.STANDARD, Colour.STANDARD, Colour.STANDARD, Colour.STANDARD]}
    const navigate = useNavigate()

    const [game, setGame] = useState({} as Game);
    const [guess, setGuess] = useState(standardColour);
    const [passedGuesses, setPassedGuesses] = useState([] as Array<Guess>);
    const [colour, setColour] = useState("");


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
        if (!guess.colours.includes(Colour.STANDARD)) {
        fetch(`${process.env.REACT_APP_BASE_URL}/api/game/${game.id}/guesses`, {
            method: 'POST',
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token') ?? 'no-token'}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(guess)
        })
            .then(response => response.json())
            .then((responseBody: Game) => setPassedGuesses(responseBody.guesses.reverse()))
            .then(() => setGuess(standardColour))
    }};



    return(
        <div className={'gamePage'}>

            <div>
                <fieldset className={'choiceBox'}>
                    <legend>Farbauswahl</legend>
                    <ColourChoice clickHandler={setColour}/>
                </fieldset>
            </div>



/*Lösung im Standard hide, erst nach letztem Versuch oder gewonnen anzeigen */
            {game.id &&
                <div>
                    <fieldset className={'boxes'}>
                        <legend>Lösung</legend>
                        <Solution solution={game.solution} />
                    </fieldset>

                    <div className={'answer'}>
                        <fieldset className={"guessBox"}>
                            <legend>aktueller Versuch</legend>
                            <GuessBox colour={colour} guess={guess} clickHandler={setGuess} />
                        </fieldset>
                        <fieldset className={"hintBox"}>
                            <HintBox />
                        </fieldset>
                        <button className={'checkButton'} onClick={checkGuess}>prüfen</button>
                    </div>

                    {
                        passedGuesses
                            .map((elem, index)=> <div className={'answer'}>
                                <fieldset className={"guessBox"}>
                                    <legend>{passedGuesses.length - index}. Versuch</legend>
                                    <GuessedBox guess={elem}/>
                                </fieldset>
                                <fieldset className={"hintBox"}>
                                    <HintBox />
                                </fieldset>
                            </div>)
                    }


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