package de.tk.mastermind.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "players")
@Data
public class Player {

    @Id
    private String id;
    private String playername;
    private String password;
}