package de.tk.mastermind;

import de.tk.mastermind.models.Player;
import de.tk.mastermind.models.RegistrationData;
import de.tk.mastermind.repositories.PlayerRepository;
import de.tk.mastermind.service.PlayerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerServiceTest {

    @Test
    void shouldAddNewPlayer() {
        // GIVEN
        RegistrationData registrationData = new RegistrationData("Barbara", "strongpassword", "strongpassword");

        Player testPlayer = new Player();
        testPlayer.setPlayername("Barbara");
        testPlayer.setPassword("supersafepw");

        Player savedTestPlayer = new Player();
        savedTestPlayer.setId("42");
        savedTestPlayer.setPlayername("Barbara");
        savedTestPlayer.setPassword("supersafepw");

        PlayerRepository playerRepoMock = Mockito.mock(PlayerRepository.class);
        when(playerRepoMock.save(testPlayer)).thenReturn(savedTestPlayer);

        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        when(passwordEncoder.encode("strongpassword")).thenReturn("supersafepw");

        // WHEN
        PlayerService playerService = new PlayerService(playerRepoMock, passwordEncoder);
        Player actual = playerService.savePlayer(registrationData);

        // THEN
        Assertions.assertEquals(savedTestPlayer, actual);
    }


    @Test
    void shouldDeletePlayerById() {
        // GIVEN
        Player testPlayer = new Player();
        testPlayer.setPlayername("Peter Lustig");
        testPlayer.setPassword("Topsecret");

        String id = testPlayer.getId();

        PlayerRepository playerRepoMock = Mockito.mock(PlayerRepository.class);

        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        when(passwordEncoder.encode("Topsecret")).thenReturn("Verytop");

        when(playerRepoMock.findById(id)).thenReturn(Optional.of(testPlayer));
        PlayerService playerService = new PlayerService(playerRepoMock, passwordEncoder);

        // WHEN
        Player actual = playerService.deletePlayerById(testPlayer.getId());

        // THEN
        verify(playerRepoMock).delete(testPlayer);
        Assertions.assertEquals(testPlayer, actual);
    }
}