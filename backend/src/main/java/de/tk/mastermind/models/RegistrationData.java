package de.tk.mastermind.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationData {

    private String playername;
    private String password;
    private String passwordAgain;
}
