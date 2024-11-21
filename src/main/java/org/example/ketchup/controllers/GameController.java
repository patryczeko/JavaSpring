package org.example.ketchup.controllers;

import org.example.ketchup.models.Game;
import org.example.ketchup.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGameById(@PathVariable String id) {
        return gameRepository.findById(id);
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable String id, @RequestBody Game game) {
        game.setId(id);
        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameRepository.deleteById(id);
    }

    @PatchMapping("/{id}/disable")
    public Game disableGame(@PathVariable String id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            Game game2 = game.get();
            game2.setAvailable(false);
            return gameRepository.save(game2);
        }
        return null;
    }
}
