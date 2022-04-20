import { ColoursForChoice } from '../models/ColoursForChoice'
import "./ColourChoice.css"


export const ColourChoice = () => {

    let colourIndex : string[] = ['RED', 'PETROL', 'ORANGE', 'GREEN', 'YELLOW', 'PURPLE']

    return (
        <div className={'colourChoiceButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[0]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[1]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[2]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[3]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[4]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[5]]}}></button>
        </div>
    )
}