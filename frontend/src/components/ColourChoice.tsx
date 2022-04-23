import { ColoursForChoice } from '../models/ColoursForChoice'
import "./ColourChoice.css"

export interface ColourChoiceProps{
    clickHandler: (colour: string) => void
}

export const ColourChoice = (props: ColourChoiceProps) => {

    let colourIndex : string[] = ['RED', 'PETROL', 'ORANGE', 'GREEN', 'YELLOW', 'PURPLE']

    return (
        <div className={'colourChoiceButtons'}>
            <button onClick={() => props.clickHandler(colourIndex[0])} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[0]]}} />
            <button onClick={() => props.clickHandler(colourIndex[1])} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[1]]}} />
            <button onClick={() => props.clickHandler(colourIndex[2])} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[2]]}} />
            <button onClick={() => props.clickHandler(colourIndex[3])} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[3]]}} />
            <button onClick={() => props.clickHandler(colourIndex[4])} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[4]]}} />
            <button onClick={() => props.clickHandler(colourIndex[5])} className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[5]]}} />
        </div>
    )
}