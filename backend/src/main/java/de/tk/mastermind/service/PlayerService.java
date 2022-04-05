package de.tk.mastermind.service;

import de.tk.mastermind.models.RegistrationData;
import de.tk.mastermind.models.Player;
import de.tk.mastermind.repositories.PlayerRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player savePlayer(RegistrationData registrationData) {

        if(findByPlayerName(registrationData.getPlayername()).isPresent()) {
            throw new IllegalArgumentException("Der Nutzername ist schon vergeben.");
        }

        Player player = new Player();
        player.setPlayername(registrationData.getPlayername());
        player.setPassword(registrationData.getPassword());

        return playerRepository.save(player);
    }

    public Optional<Player> findByPlayerName(String playername) {
        return playerRepository.findByPlayername(playername);
    }

    public Optional<Player> findPlayerById(String id) {
        return playerRepository.findById(id);
    }

    public Player deletePlayerById(String idToDelete) {
        Optional<Player> optPlayer = playerRepository.findById(idToDelete);
        Player player = optPlayer.orElseThrow(() -> new IllegalArgumentException("Kein Spieler mit dieser ID gefunden"));
        playerRepository.delete(player);
        return player;
    }
}