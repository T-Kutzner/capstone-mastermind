import { ColoursForChoice } from '../models/ColoursForChoice'
import "./SolutionColours.css"

export const SolutionColours = () => {

    let colourIndex : number[] = getFourRandomNumbersOutOfSix()

    function getRandomNumber(max: number) {
        return Math.floor(Math.random() * max);
    }

    function getFourRandomNumbersOutOfSix(){

        let colourIndexTemp : number[] = []
        let random : number;

        while(colourIndexTemp.length < 4) {
            random = getRandomNumber(6)
            if(!colourIndexTemp.includes(random)) {
                colourIndexTemp.push(random)
            }
        }
        return colourIndexTemp
    }

    function tbd(){}

    return (
        <div className={'solutionColourButtons'}>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[0]]}} onClick={tbd}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[1]]}} onClick={tbd}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[2]]}} onClick={tbd}></button>
            <button className={'gameButtons'} style={{ backgroundColor: ColoursForChoice[colourIndex[3]]}} onClick={tbd}></button>
        </div>
    )
}