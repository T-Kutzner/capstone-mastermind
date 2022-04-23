export default interface Game {
    id: string;
    solution: Guess,
    guesses: Array<Guess>,
    hints: Array<Guess>
}

export interface Guess {
    colours: Array<Colour>
}

export enum Colour {
    RED = "RED",
    PETROL = "PETROL",
    ORANGE = "ORANGE",
    GREEN = "GREEN",
    YELLOW = "YELLOW",
    PURPLE = "PURPLE",
    GREY = "GREY",
    MINT = "MINT",
    STANDARD = "STANDARD"
}

export function getColour(colour: string){
    switch (colour){
        case 'RED': return Colour.RED
        case 'PETROL': return Colour.PETROL
        case 'ORANGE': return Colour.ORANGE
        case 'GREEN': return Colour.GREEN
        case 'YELLOW': return Colour.YELLOW
        case 'PURPLE': return Colour.PURPLE
        case 'GREY': return Colour.GREY
        case 'MINT': return Colour.MINT
        default: return Colour.STANDARD
    }
}