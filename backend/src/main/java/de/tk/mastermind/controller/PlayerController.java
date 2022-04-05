package de.tk.mastermind.controller;

import de.tk.mastermind.models.RegistrationData;
import de.tk.mastermind.models.Player;
import de.tk.mastermind.service.PlayerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

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
}