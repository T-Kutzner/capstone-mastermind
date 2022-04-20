import { ColoursForChoice } from '../models/ColoursForChoice'
import "./Solution.css"
import Game, {Guess} from "../models/Game"

interface SolutionBoxProps{
    solution: Guess;
}

export const Solution = (props: SolutionBoxProps) => {


    return (
        <div className={'solutionColourButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[0]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[1]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[2]]}}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[3]]}}></button>
        </div>
    )

    /*
    const solutionButtons = colourIndex.map(index =>
        <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[index]]}}></button>
    )

    return (
        <div className={'solutionColourButtons'}>
            {solutionButtons}
        </div>

        //colourIndex.forEach
        //<button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[props.solution.colours[i]]}}></button>
        //setSolutionColour(i)
    )
     */

}