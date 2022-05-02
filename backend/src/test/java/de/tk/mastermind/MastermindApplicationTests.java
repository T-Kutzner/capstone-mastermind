package de.tk.mastermind;

import de.tk.mastermind.models.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MastermindApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {

		// register a user
		RegistrationData registration = new RegistrationData();
		registration.setPlayername("BigPlayer");
		registration.setPassword("big");
		registration.setPasswordAgain("big");

		ResponseEntity<String> responseRegisterPlayerOne = restTemplate.postForEntity("/api/players", registration, String.class);
		assertThat(responseRegisterPlayerOne.getStatusCode()).isEqualTo(HttpStatus.OK);


		// not login a user
		LoginData loginFail = new LoginData();
		loginFail.setPlayername(registration.getPlayername());
		loginFail.setPassword("bigFail");

		ResponseEntity<String> responseLoginPlayerOneFail = restTemplate.postForEntity("/api/login", loginFail, String.class);
		assertThat(responseLoginPlayerOneFail.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);


		// login a user
		LoginData login = new LoginData();
		login.setPlayername(registration.getPlayername());
		login.setPassword("big");

		ResponseEntity<String> responseLoginPlayerOne = restTemplate.postForEntity("/api/login", login, String.class);
		assertThat(responseLoginPlayerOne.getStatusCode()).isEqualTo(HttpStatus.OK);


		// create new game
		HttpHeaders headerForPlayer = new HttpHeaders();
		String token = responseLoginPlayerOne.getBody();
		headerForPlayer.setBearerAuth(token);
		HttpEntity<Void> httpEntityPlayerOne = new HttpEntity<>(headerForPlayer);

		ResponseEntity<Game> responseCreateGame = restTemplate.postForEntity("/api/game", httpEntityPlayerOne, Game.class);
		assertThat(responseCreateGame.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGame.getBody().getId()).isNotNull();
		assertThat(responseCreateGame.getBody().getSolution()).isNotNull();


		// create guess
		String id = responseCreateGame.getBody().getId();
		String url = "/api/game/" + id + "/guesses";

		Guess guess = new Guess();
		Colour[] colourGuess = new Colour[4];
		colourGuess[0] = Colour.GREEN;
		colourGuess[1] = Colour.ORANGE;
		colourGuess[2] = Colour.GREEN;
		colourGuess[3] = Colour.PETROL;
		guess.setColours(colourGuess);


		HttpEntity<Guess> httpEntityGuess = new HttpEntity<>(guess, headerForPlayer);
		ResponseEntity<Game> responseCreateGuess = restTemplate.postForEntity(url, httpEntityGuess, Game.class);
		assertThat(responseCreateGuess.getStatusCode()).isEqualTo(HttpStatus.OK);


		// win game
		Guess solution = responseCreateGuess.getBody().getSolution();
		HttpEntity<Guess> httpEntitySolution = new HttpEntity<>(solution, headerForPlayer);
		ResponseEntity<Game> responseGameWon = restTemplate.postForEntity(url, httpEntitySolution, Game.class);
		assertThat(responseGameWon.getBody().isGameWon()).isTrue();
		assertThat(responseGameWon.getBody().isGameOver()).isFalse();


		// lose game if not every colour in solution is green
		ResponseEntity<Game> responseCreateGameLoseGame = restTemplate.postForEntity("/api/game", httpEntityPlayerOne, Game.class);
		assertThat(responseCreateGameLoseGame.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGameLoseGame.getBody().getId()).isNotNull();
		assertThat(responseCreateGameLoseGame.getBody().getSolution()).isNotNull();


			// create six same guesses to lose
		String idLose = responseCreateGameLoseGame.getBody().getId();
		String urlLose = "/api/game/" + idLose + "/guesses";

		Guess guessLose = new Guess();
		Colour[] colourGuessLose = new Colour[4];
		colourGuessLose[0] = Colour.GREEN;
		colourGuessLose[1] = Colour.GREEN;
		colourGuessLose[2] = Colour.GREEN;
		colourGuessLose[3] = Colour.GREEN;
		guessLose.setColours(colourGuessLose);


		HttpEntity<Guess> httpEntityGuessLoseOne = new HttpEntity<>(guessLose, headerForPlayer);
		ResponseEntity<Game> responseCreateGuessLoseGameOne = restTemplate.postForEntity(urlLose, httpEntityGuessLoseOne, Game.class);

		assertThat(responseCreateGuessLoseGameOne.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGuessLoseGameOne.getBody().isGameWon()).isFalse();
		assertThat(responseCreateGuessLoseGameOne.getBody().isGameOver()).isFalse();


		HttpEntity<Guess> httpEntityGuessLoseTwo = new HttpEntity<>(guessLose, headerForPlayer);
		ResponseEntity<Game> responseCreateGuessLoseGameTwo = restTemplate.postForEntity(urlLose, httpEntityGuessLoseTwo, Game.class);

		assertThat(responseCreateGuessLoseGameTwo.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGuessLoseGameTwo.getBody().isGameWon()).isFalse();
		assertThat(responseCreateGuessLoseGameTwo.getBody().isGameOver()).isFalse();


		HttpEntity<Guess> httpEntityGuessLoseThree = new HttpEntity<>(guessLose, headerForPlayer);
		ResponseEntity<Game> responseCreateGuessLoseGameThree = restTemplate.postForEntity(urlLose, httpEntityGuessLoseThree, Game.class);

		assertThat(responseCreateGuessLoseGameThree.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGuessLoseGameThree.getBody().isGameWon()).isFalse();
		assertThat(responseCreateGuessLoseGameThree.getBody().isGameOver()).isFalse();


		HttpEntity<Guess> httpEntityGuessLoseFour = new HttpEntity<>(guessLose, headerForPlayer);
		ResponseEntity<Game> responseCreateGuessLoseGameFour = restTemplate.postForEntity(urlLose, httpEntityGuessLoseFour, Game.class);

		assertThat(responseCreateGuessLoseGameFour.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGuessLoseGameFour.getBody().isGameWon()).isFalse();
		assertThat(responseCreateGuessLoseGameFour.getBody().isGameOver()).isFalse();


		HttpEntity<Guess> httpEntityGuessLoseFive = new HttpEntity<>(guessLose, headerForPlayer);
		ResponseEntity<Game> responseCreateGuessLoseGameFive = restTemplate.postForEntity(urlLose, httpEntityGuessLoseFive, Game.class);

		assertThat(responseCreateGuessLoseGameFive.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGuessLoseGameFive.getBody().isGameWon()).isFalse();
		assertThat(responseCreateGuessLoseGameFive.getBody().isGameOver()).isFalse();


		HttpEntity<Guess> httpEntityGuessLoseGameSix = new HttpEntity<>(guessLose, headerForPlayer);
		ResponseEntity<Game> responseCreateGuessLoseGameSix = restTemplate.postForEntity(urlLose, httpEntityGuessLoseGameSix, Game.class);

		assertThat(responseCreateGuessLoseGameSix.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseCreateGuessLoseGameSix.getBody().isGameWon()).isFalse();
		assertThat(responseCreateGuessLoseGameSix.getBody().isGameOver()).isTrue();
	}
}