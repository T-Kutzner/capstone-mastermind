import { ColoursForChoice } from '../models/ColoursForChoice'
import "./GuessBox.css"
import {getColour, Guess} from "../models/Game";


interface GuessBoxProps {
    guess: Guess
    clickHandler: (changedGuess: Guess) => void
    colour: string
}


export const GuessBox = (props: GuessBoxProps) => {

    const colourChange = (index: number) => {
        let currentArray = props.guess.colours
        currentArray[index] = getColour(props.colour)
        props.clickHandler({colours: currentArray})
    }

    return (
        <div className={'guessColourButtons'}>
            <button onClick={() => colourChange(0)} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[0]]}} />
            <button onClick={() => colourChange(1)} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[1]]}} />
            <button onClick={() => colourChange(2)} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[2]]}} />
            <button onClick={() => colourChange(3)} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.guess.colours[3]]}} />
        </div>
    )
}