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
    GREEN,
    ORANGE,
    PURPLE,
    YELLOW
}