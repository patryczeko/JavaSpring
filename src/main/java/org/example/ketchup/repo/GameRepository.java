package org.example.ketchup.repo;

import org.example.ketchup.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game,String> {
}
