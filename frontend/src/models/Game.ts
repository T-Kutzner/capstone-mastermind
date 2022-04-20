export default interface Game {
    id: string;
    solution: Guess,
    guesses: Array<Guess>
}

export interface Guess {
    colours: Array<Colour>
}

export enum Colour {
    RED,
    PETROL,
    ORANGE,
    GREEN,
    YELLOW,
    PURPLE,
    GREY,
    MINT
}