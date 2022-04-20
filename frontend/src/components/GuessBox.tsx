import { ColoursForChoice } from '../models/ColoursForChoice'
import "./GuessBox.css"
import {Guess} from "../models/Game";


interface GuessBoxProps {
    guess: Guess
}


export const GuessBox = (props: GuessBoxProps) => {

    return (
        <div className={'guessColourButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[0]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[1]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[2]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[3]]}}></button>
        </div>
    )
}