package de.tk.mastermind;

import de.tk.mastermind.models.Player;
import de.tk.mastermind.repositories.PlayerRepository;
import de.tk.mastermind.service.PlayerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerServiceTest {

    @Test
    void shouldAddNewPlayer() {
        // GIVEN
        Player testPlayer = new Player();
        testPlayer.setId("135");
        testPlayer.setPlayerName("Peter Lustig");
        testPlayer.setPassword("Topsecret");

        PlayerRepository playerRepoMock = Mockito.mock(PlayerRepository.class);
        when(playerRepoMock.save(testPlayer)).thenReturn(testPlayer);

        PlayerService playerService = new PlayerService(playerRepoMock);

        // WHEN
        Player actual = playerService.createPlayer(testPlayer);

        // THEN
        Assertions.assertEquals(testPlayer, actual);
    }

    @Test
    void shouldDeletePlayerById() {
        // GIVEN
        Player testPlayer = new Player();
        testPlayer.setId("135");
        testPlayer.setPlayerName("Peter Lustig");
        testPlayer.setPassword("Topsecret");

        String id = testPlayer.getId();

        PlayerRepository playerRepoMock = Mockito.mock(PlayerRepository.class);

        when(playerRepoMock.findById(id)).thenReturn(Optional.of(testPlayer));
        PlayerService playerService = new PlayerService(playerRepoMock);

        // WHEN
        Player actual = playerService.deletePlayerById(testPlayer.getId());

        // THEN
        verify(playerRepoMock).delete(testPlayer);
        Assertions.assertEquals(testPlayer, actual);
    }
}