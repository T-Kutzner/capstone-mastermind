import { ColoursForChoice } from '../models/ColoursForChoice'
import "./ColourChoice.css"

export const ColourChoice = () => {


    let colourIndex : number[] = [0, 1, 2, 3, 4, 5]

    function inProgress(){}

    return (
        <div>
            <fieldset  className={'colourChoiceButtons'}>
                <legend>Farbauswahl</legend>
                <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[0]]}} onClick={inProgress}></button>
                <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[1]]}} onClick={inProgress}></button>
                <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[2]]}} onClick={inProgress}></button>
                <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[3]]}} onClick={inProgress}></button>
                <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[4]]}} onClick={inProgress}></button>
                <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[5]]}} onClick={inProgress}></button>
            </fieldset>
            <div>
                <button>Neues Spiel</button>
            </div>
        </div>
    )
}