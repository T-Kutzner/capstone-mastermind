package de.tk.mastermind.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Guess {

  private Colour[] colours;
}
