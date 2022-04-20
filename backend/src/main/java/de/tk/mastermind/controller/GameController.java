package de.tk.mastermind.controller;

import de.tk.mastermind.models.Game;
import de.tk.mastermind.models.Guess;
import de.tk.mastermind.service.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public Game createGame()
    {
        return gameService.createGame();
    }

/*
    @PostMapping("/{id}/guesses")
    public Game createGuess(@PathVariable String id, @RequestBody Guess guess){
        return gameService.createGuess(id, guess);
    }

   // @GetMapping("/{id}")



 */


/*
    @PostMapping
    public Player createPlayer(@RequestBody RegistrationData registrationData) {

        if(!registrationData.getPassword().equals(registrationData.getPasswordAgain())) {
            throw new IllegalArgumentException("Die Passwörter stimmen nicht überein.");
        }
        return playerService.savePlayer(registrationData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable String id) {
        return ResponseEntity.of(playerService.findPlayerById(id));
    }

    @DeleteMapping("/{id}")
    public Player deletePlayerById(@PathVariable String id) {
        return playerService.deletePlayerById(id);
    }

    @GetMapping
    public String greet(Principal principal) {
        return "Hallo " + principal.getName() + "!";
    }

 */
}