package de.tk.mastermind.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "games")
@Data
public class Game {

    @Id
    private String id;
    private List<Guess> guesses = new ArrayList<>();
    private Guess solution;
    private List<Guess> hints = new ArrayList<>();

    public boolean isRunning() {
        return guesses.size() < 12;
    }

    public boolean isWon() {
        return !guesses.isEmpty() && guesses.get(guesses.size() - 1).equals(solution);
    }
}