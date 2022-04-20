package de.tk.mastermind.service;

import de.tk.mastermind.models.Colour;
import de.tk.mastermind.models.Game;
import de.tk.mastermind.models.Guess;
import de.tk.mastermind.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

            List<Guess> guessList = game.getGuesses();
            guessList.add(guess);

            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }
}
