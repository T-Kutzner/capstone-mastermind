package de.tk.mastermind.controller;

import de.tk.mastermind.models.Game;
import de.tk.mastermind.models.Guess;
import de.tk.mastermind.service.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public Game createGame() {
        return gameService.createGame();
    }

    @PostMapping("/{id}/guesses")
    public ResponseEntity<Game> createGuess(@PathVariable String id, @RequestBody Guess guess){
        return ResponseEntity.of(gameService.createGuess(id, guess));
    }
}