package de.tk.mastermind.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Colour {
    RED("#741B47"),
    PETROL("#134F5C"),
    ORANGE("#E69138"),
    GREEN("#4da63c"),
    YELLOW("#FFD966"),
    PURPLE("#9900FF"),
    GREY("#777777"),
    MINT("#76A5AF");

    String colourCode;
}