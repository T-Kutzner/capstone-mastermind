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

            Game game = matchOfGuessSolution(guess, newGame.get());
            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }


    public Game matchOfGuessSolution(Guess guess, Game game) {

        ColourBW[] hint = new ColourBW[4];
        int countHits = 0;
        int maxTries = 6;
        Colour[] temp = new Colour[]{game.getSolution().getColours()[0], game.getSolution().getColours()[1], game.getSolution().getColours()[2], game.getSolution().getColours()[3]};

        for(int i = 0; i < hint.length; i++) {

            if (temp[i].equals(guess.getColours()[i])) {
                hint[i] = ColourBW.BLACK;
                countHits++;
            }
        }

        for(int i = 0; i < hint.length; i++) {

            if ((Arrays.asList(temp).contains(guess.getColours()[i])) && (hint[i] != ColourBW.BLACK)) {

                for (int j = 0; j < hint.length; j++) {

                    if (temp[j].equals(guess.getColours()[i])) {
                        temp[j] = Colour.STANDARD;
                        hint[i] = ColourBW.WHITE;
                    }
                }
            }
        }


        if(countHits == 4) {
            game.setGameWon(true);
        }

        if((game.getGuesses().size() + 1 == maxTries) && !game.isGameWon()){
            game.setGameOver(true);
        }


        List<Hint> hintList = game.getHints();
        hintList.add(new Hint(hint));
        List<Guess> guessList = game.getGuesses();
        guessList.add(guess);

        return game;
    }
}