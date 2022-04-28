import {useNavigate} from "react-router-dom";
import {ColourChoice} from "../components/ColourChoice";
import {Solution} from "../components/Solution"
import {GuessBox} from "../components/GuessBox";
import "./GamePage.css"
import {HintBox} from "../components/HintBox";
import {AboutGame} from "../components/AboutGame";
import {useState} from "react";
import Game, {Colour} from "../models/Game";
import {GuessedBox} from "../components/GuessedBox";
import welcomePage from "../images/welcomePage.png";

export default function GamePage() {

    const standardColour = {colours: [Colour.STANDARD, Colour.STANDARD, Colour.STANDARD, Colour.STANDARD]}
    const navigate = useNavigate()

    const [game, setGame] = useState({} as Game);
    const [guess, setGuess] = useState(standardColour);
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
                .then((responseBody: Game) => {
                    setGame(responseBody);
                })
                .then(() => {
                    setGuess(standardColour)
                })

        }
    };


    return (

        <div className={'gamePage'}>
            <div className={'picture'} >
                <img src={welcomePage} alt={'WelcomePageImage'} width="250" />
            </div>

            <div>
                <fieldset className={'choiceBox'}>
                    <legend>Farbauswahl</legend>
                    <ColourChoice clickHandler={setColour}/>
                </fieldset>
            </div>

        
            {game.id &&
                <div>
                    {game.gameWon && <div> - ∞ &#129395; - - - Gewonnen - - - &#129395; ∞ - </div>}
                    {game.gameOver && <div>- &#128542; Verloren, gleich nochmal &#129299; -</div>}

                    {
                        (game.gameWon || game.gameOver)
                            ?
                            <fieldset className={'boxes'}>
                                <legend>Lösung</legend>
                                <Solution solution={game.solution}/>
                            </fieldset>
                            :
                            <fieldset className={'boxes'}>
                                <legend>Lösung</legend>
                                <Solution solution={standardColour}/>
                            </fieldset>

                    }

                    <hr />

                    {!(game.gameWon || game.gameOver) &&
                        <div className={'answer'}>
                            <fieldset className={"guessBox"}>
                                <legend>aktueller Versuch</legend>
                                <GuessBox colour={colour} guess={guess} clickHandler={setGuess}/>
                            </fieldset>

                            <button className={'checkButton'} onClick={checkGuess}>prüfen</button>
                        </div>
                    }
                    <div className='guess-hint-wrapper'>
                        <div className='passedGuesses-wrapper'>
                    {
                        game.guesses
                            .map((currentGuess, index) =>

                                <div className={'answer'} key={'guess' + index}>
                                    <fieldset className={"guessBox"}>
                                        <legend>{index+1}. Versuch</legend>
                                        <GuessedBox guess={currentGuess}/>
                                    </fieldset>
                                </div>
                            )
                    }
                        </div>
                        <div className='hints-wrapper'>
                    {
                        game.hints
                            .map((currentHint, index) =>
                                <div className={'answer'} key={'hint' + index}>
                                    <fieldset className={"hintBox"}>
                                        <HintBox hint={currentHint}/>
                                    </fieldset>
                                </div>
                            )
                    }
                        </div>
                    </div>
                </div>
            }


            <div className={'navigationBar'}>
                <button onClick={() => {
                    localStorage.setItem("token", "");
                    navigate("/login")
                }}>Abmelden
                </button>


                <button>Konto löschen</button>
                <button onClick={AboutGame}>Spielregeln</button>
                <button onClick={() => startGame()}>Neues Spiel</button>
            </div>

        </div>
    )
}