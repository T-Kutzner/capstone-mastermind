import { ColoursForHints } from '../models/ColoursForHints'
import "./HintBox.css"


export const HintBox = () => {

    let colourIndex : string[] = ['BLACK', 'WHITE']

    return (
        <div className={'colourHintButtons'}>
            <div className={'colourHintButtonsDirection'}>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[0]]}}></button>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[1]]}}></button>
            </div>
            <div className={'colourHintButtonsDirection'}>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[2]]}}></button>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[colourIndex[2]]}}></button>
            </div>
        </div>
    )
}