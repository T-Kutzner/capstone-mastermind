import { ColoursForHints } from '../models/ColoursForHints'
import "./HintBox.css"
import {Hint} from "../models/Game";

interface HintBoxProps {
    hint: Hint
}

export const HintBox = (props: HintBoxProps) => {

    return (
        <div className={'colourHintButtons'}>
            <div className={'colourHintButtonsDirection'}>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[props.hint.coloursBW[0]]}} />
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[props.hint.coloursBW[1]]}} />
            </div>
            <div className={'colourHintButtonsDirection'}>
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[props.hint.coloursBW[2]]}} />
                <button className={'gameHintButtons'} style={{ backgroundColor: ColoursForHints[props.hint.coloursBW[3]]}} />
            </div>
        </div>
    )
}