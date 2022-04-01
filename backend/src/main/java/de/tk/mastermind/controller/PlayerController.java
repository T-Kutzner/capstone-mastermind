package de.tk.mastermind.controller;

import de.tk.mastermind.models.Player;
import de.tk.mastermind.service.PlayerService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable String id) {
        return playerService.findPlayerById(id);
    }

    @DeleteMapping("/{id}")
    public Player deletePlayerById(@PathVariable String id) {
        return playerService.deletePlayerById(id);
    }
}