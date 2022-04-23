import { ColoursForChoice } from '../models/ColoursForChoice'
import "./Solution.css"
import {Guess} from "../models/Game"


interface SolutionBoxProps{
    solution: Guess;
}

export const Solution = (props: SolutionBoxProps) => {

    return (
        <div className={'solutionColourButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[0]]}} />
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[1]]}} />
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[2]]}} />
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[3]]}} />
        </div>
    )
}