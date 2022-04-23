package de.tk.mastermind.service;

import de.tk.mastermind.models.*;
import de.tk.mastermind.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    // size of level for kids
    private int colourChoiceSize = 6;

    public Game createGame() {
        Game game = new Game();
        game.setSolution(getFourRandomColours(colourChoiceSize));

        return gameRepository.save(game);
    }


    private int getRandomNumber(int max) {
        return (int)(Math.random() * max);
    }

    // version with possibility of same colour
    private Guess getFourRandomColours(int colourChoiceSize){

        Colour[] colour = new Colour[4];

        for(int i = 0; i < colour.length; i++) {

            int random = getRandomNumber(colourChoiceSize);
            colour[i]= Colour.values()[random];
        }
        return new Guess(colour);
    }


    public Optional <Game> createGuess(String id, Guess guess) {

        Optional<Game> newGame = gameRepository.findById(id);
        if (newGame.isPresent()) {
            Game game = newGame.get();
            Hint hint = matchOfGuessSolution(guess, game);
            List<Hint> hintList = game.getHints();
            hintList.add(hint);
            List<Guess> guessList = game.getGuesses();
            guessList.add(guess);
            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }


    public Hint matchOfGuessSolution(Guess guess, Game game) {

        ColourBW[] hint = new ColourBW[4];

        for(int i = 0; i < 4; i++) {

            if(Arrays.asList(game.getSolution().getColours()).contains(guess.getColours()[i])) {

                if(game.getSolution().getColours()[i] == guess.getColours()[i]){

                    hint[i] = ColourBW.BLACK;
                }
                else hint[i] = ColourBW.WHITE;
            }
        }
        return new Hint(hint);
    }




// dann noch prüfen ob alle guesses schwarz sind
// wenn ja, gewonnen (Solution einblenden und yay, gewonnen)
// wenn nein, Zähler für Versuch überprüfen ob schon auf max Versuche
// wenn max dann verloren und Solution einblenden
// wenn noch nicht max Versuche dann nächsten Versuch freigeben, Zähler für Versuch hochzählen(?)

}