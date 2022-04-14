import { ColoursForChoice } from '../models/ColoursForChoice'
import "./ColourChoice.css"

export const ColourChoice = () => {


    let colourIndex : number[] = [0, 1, 2, 3, 4, 5]

    function inProgress(){}

    return (
        <div>
            <div className={'colourChoiceButtons'}>
                <button style={{ backgroundColor: ColoursForChoice[colourIndex[0]]}} onClick={inProgress}>0</button>
                <button style={{ backgroundColor: ColoursForChoice[colourIndex[1]]}} onClick={inProgress}>1</button>
                <button style={{ backgroundColor: ColoursForChoice[colourIndex[2]]}} onClick={inProgress}>2</button>
                <button style={{ backgroundColor: ColoursForChoice[colourIndex[3]]}} onClick={inProgress}>3</button>
                <button style={{ backgroundColor: ColoursForChoice[colourIndex[4]]}} onClick={inProgress}>4</button>
                <button style={{ backgroundColor: ColoursForChoice[colourIndex[5]]}} onClick={inProgress}>5</button>
            </div>
            <div>
                <button>Neues Spiel</button>
            </div>
        </div>
    )
}