package de.tk.mastermind.repositories;

import de.tk.mastermind.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends MongoRepository <Game, String> {

}
