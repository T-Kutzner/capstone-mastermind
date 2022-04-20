import { ColoursForHints } from '../models/ColoursForHints'
import "./HintBox.css"

export const HintBox = () => {


    let colourIndex : number[] = [0, 1]

    function inProgress(){}

    return (
        <div className={'colourHintButtons'}>
            <div className={'colourHintButtonsDirection'}>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[0]]}} onClick={inProgress}></button>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[1]]}} onClick={inProgress}></button>
            </div>
            <div className={'colourHintButtonsDirection'}>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[2]]}} onClick={inProgress}></button>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[2]]}} onClick={inProgress}></button>
            </div>
        </div>
    )
}