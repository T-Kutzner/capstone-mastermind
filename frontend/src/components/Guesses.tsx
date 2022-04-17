import { ColoursForChoice } from '../models/ColoursForChoice'
import "./Guesses.css"


export const Guesses = () => {

    let colourIndex : number[] = []

    function inProgress(){}

    return (
        <div className={'guessColourButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[0]]}} onClick={inProgress}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[1]]}} onClick={inProgress}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[2]]}} onClick={inProgress}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[3]]}} onClick={inProgress}></button>
        </div>
    )
}