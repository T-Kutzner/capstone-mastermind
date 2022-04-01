package de.tk.mastermind.service;

import de.tk.mastermind.models.Player;
import de.tk.mastermind.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player findPlayerById(String id) {
        return playerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Keine passende ID gefunden."));
    }

    public Player deletePlayerById(String idToDelete) {
        Optional<Player> optPlayer = playerRepository.findById(idToDelete);
        Player player = optPlayer.orElseThrow(() -> new IllegalArgumentException("Kein Spieler mit dieser ID gefunden"));
        playerRepository.delete(player);
        return player;
    }
}
