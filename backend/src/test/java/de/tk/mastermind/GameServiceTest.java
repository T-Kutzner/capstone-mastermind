package de.tk.mastermind;

import de.tk.mastermind.models.*;
import de.tk.mastermind.repositories.GameRepository;
import de.tk.mastermind.service.GameService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GameServiceTest {

    @Test
    void shouldAddNewGame() {

        // GIVEN
        Game testgame = new Game();
        testgame.setId("testID");
        testgame.setGuesses(null);

        Guess solution = new Guess();
        Colour[] colour = new Colour[4];
        colour[0] = Colour.GREEN;
        colour[1] = Colour.ORANGE;
        colour[2] = Colour.ORANGE;
        colour[3] = Colour.PETROL;
        solution.setColours(colour);

        testgame.setSolution(solution);
        testgame.setHints(null);
        testgame.setGameWon(false);
        testgame.setGameOver(false);

        //WHEN
        GameRepository gameRepoMock = Mockito.mock(GameRepository.class);
        when(gameRepoMock.save(any(Game.class))).thenReturn(testgame);
        GameService gameService = new GameService(gameRepoMock);

        Game actual = gameService.createGame();

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual, testgame);
    }

    @Test
    void shouldNotSaveNewGuess() {

        String id = "testID";

        Guess guess = new Guess();
        Colour[] colourGuess = new Colour[4];
        colourGuess[0] = Colour.GREEN;
        colourGuess[1] = Colour.ORANGE;
        colourGuess[2] = Colour.ORANGE;
        colourGuess[3] = Colour.PETROL;
        guess.setColours(colourGuess);

        GameRepository gameRepoMock = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(gameRepoMock);

        // WHEN
        when(gameRepoMock.findById(id)).thenReturn(Optional.empty());

        Optional<Game> actual = gameService.createGuess(id, guess);

        // THEN
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    void shouldSaveNewGuessHintAllBlack() {
        Game testgame = new Game();
        testgame.setId("testID");

        Guess solution = new Guess();
        Guess guess = new Guess();
        Hint hint = new Hint();

        Colour[] colourSolution = new Colour[4];
        colourSolution[0] = Colour.GREEN;
        colourSolution[1] = Colour.ORANGE;
        colourSolution[2] = Colour.ORANGE;
        colourSolution[3] = Colour.PETROL;

        Colour[] colourGuess = new Colour[4];
        colourGuess[0] = Colour.GREEN;
        colourGuess[1] = Colour.ORANGE;
        colourGuess[2] = Colour.ORANGE;
        colourGuess[3] = Colour.PETROL;

        ColourBW[] colourBWHint = new ColourBW[4];
        colourBWHint[0] = ColourBW.BLACK;
        colourBWHint[1] = ColourBW.BLACK;
        colourBWHint[2] = ColourBW.BLACK;
        colourBWHint[3] = ColourBW.BLACK;

        solution.setColours(colourSolution);
        guess.setColours(colourGuess);
        hint.setColoursBW(colourBWHint);

        testgame.setSolution(solution);

        GameRepository gameRepoMock = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(gameRepoMock);

        // WHEN
        when(gameRepoMock.findById(testgame.getId())).thenReturn(Optional.of(testgame));
        when(gameRepoMock.save(any(Game.class))).thenReturn(testgame);

        Optional<Game> actual = gameService.createGuess(testgame.getId(), guess);

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.get().getHints().get(0), hint);
    }

    @Test
    void shouldSaveNewGuessHintBlackWhiteWhiteNull() {
        Game testgame = new Game();
        testgame.setId("testID");

        Guess solution = new Guess();
        Guess guess = new Guess();
        Hint hint = new Hint();

        Colour[] colourSolution = new Colour[4];
        colourSolution[0] = Colour.GREEN;
        colourSolution[1] = Colour.GREEN;
        colourSolution[2] = Colour.ORANGE;
        colourSolution[3] = Colour.YELLOW;

        Colour[] colourGuess = new Colour[4];
        colourGuess[0] = Colour.GREEN;
        colourGuess[1] = Colour.ORANGE;
        colourGuess[2] = Colour.GREEN;
        colourGuess[3] = Colour.PETROL;

        ColourBW[] colourBWHint = new ColourBW[4];
        colourBWHint[0] = ColourBW.BLACK;
        colourBWHint[1] = ColourBW.WHITE;
        colourBWHint[2] = ColourBW.WHITE;
        colourBWHint[3] = null;

        solution.setColours(colourSolution);
        guess.setColours(colourGuess);
        hint.setColoursBW(colourBWHint);

        testgame.setSolution(solution);

        GameRepository gameRepoMock = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(gameRepoMock);

        // WHEN
        when(gameRepoMock.findById(testgame.getId())).thenReturn(Optional.of(testgame));
        when(gameRepoMock.save(any(Game.class))).thenReturn(testgame);

        Optional<Game> actual = gameService.createGuess(testgame.getId(), guess);

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.get().getHints().get(0), hint);
    }

    @Test
    void shouldBeGameOver() {
        Game testgame = new Game();
        testgame.setId("testID");;

        Guess solution = new Guess();
        Guess guess = new Guess();
        Hint hint = new Hint();
        List<Guess> guesses = new ArrayList<>();

        Colour[] colourSolution = new Colour[4];
        colourSolution[0] = Colour.GREEN;
        colourSolution[1] = Colour.GREEN;
        colourSolution[2] = Colour.ORANGE;
        colourSolution[3] = Colour.YELLOW;

        Colour[] colourGuess = new Colour[4];
        colourGuess[0] = Colour.GREEN;
        colourGuess[1] = Colour.ORANGE;
        colourGuess[2] = Colour.GREEN;
        colourGuess[3] = Colour.PETROL;

        ColourBW[] colourBWHint = new ColourBW[4];
        colourBWHint[0] = ColourBW.BLACK;
        colourBWHint[1] = ColourBW.WHITE;
        colourBWHint[2] = ColourBW.WHITE;
        colourBWHint[3] = null;

        solution.setColours(colourSolution);
        guess.setColours(colourGuess);
        hint.setColoursBW(colourBWHint);

        guesses.add(guess);
        guesses.add(guess);
        guesses.add(guess);
        guesses.add(guess);
        guesses.add(guess);

        testgame.setSolution(solution);
        testgame.setGuesses(guesses);

        GameRepository gameRepoMock = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(gameRepoMock);

        // WHEN
        when(gameRepoMock.findById(testgame.getId())).thenReturn(Optional.of(testgame));
        when(gameRepoMock.save(any(Game.class))).thenReturn(testgame);

        Optional<Game> actual = gameService.createGuess(testgame.getId(), guess);

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.get().isGameOver(), testgame.isGameOver());
    }
}