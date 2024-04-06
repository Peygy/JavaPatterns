package org.task16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task16.entity.Game;
import org.task16.service.GameService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameController
{
    @Autowired
    private GameService gameService;

    @PostMapping()
    public ResponseEntity AddGame(@RequestBody Game game) throws SQLException
    {
        gameService.AddGame(game);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteGame(@PathVariable Long id) throws SQLException
    {
        gameService.DeleteGame(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<Game> GetAllGame() throws SQLException
    {
        return gameService.GetGames();
    }

    @GetMapping("/{id}")
    public Game GetGameById(@PathVariable Long id) throws SQLException
    {
        return gameService.GetGameById(id);
    }
}
