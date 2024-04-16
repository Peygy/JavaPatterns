package org.task18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task18.entity.Game;
import org.task18.service.GameService;

import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameController
{
    @Autowired
    private GameService gameService;

    @PostMapping()
    public ResponseEntity AddGame(@RequestBody Game game)
    {
        gameService.AddGame(game);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteGame(@PathVariable Long id)
    {
        gameService.DeleteGame(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<Game> GetAllGame()
    {
        return gameService.GetAllGame();
    }

    @GetMapping("/{id}")
    public Game GetGameById(@PathVariable Long id)
    {
        return gameService.GetGameById(id);
    }

    // Filter by name
    @GetMapping("/name/{pattern}")
    public List<Game> FilterGamesByName(@PathVariable String pattern)
    {
        return gameService.FilterGamesByName(pattern);
    }

    // Filter by creationDate
    @GetMapping("/date/{pattern}")
    public List<Game> FilterGamesByDate(@PathVariable String pattern)
    {
        return gameService.FilterGamesByDate(pattern);
    }
}
