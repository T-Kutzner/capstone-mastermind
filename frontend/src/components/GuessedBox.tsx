import { ColoursForChoice } from '../models/ColoursForChoice'
import "./GuessBox.css"
import {Guess} from "../models/Game";


export interface GuessedBoxProps {
    guess: Guess
}


export const GuessedBox = (props: GuessedBoxProps) => {

    return (
        <div className={'guessColourButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[0]]}} />
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[1]]}} />
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[2]]}} />
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[3]]}} />
        </div>
    )
}