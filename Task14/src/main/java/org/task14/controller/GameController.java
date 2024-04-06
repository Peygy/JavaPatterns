package org.task14.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task14.entity.Game;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("game")
public class GameController
{
    private List<Game> games = new ArrayList<>();

    // Add
    @PostMapping("/add")
    public ResponseEntity AddGame(@RequestBody Game game)
    {
        games.add(game);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteGame(@PathVariable int id)
    {
        games.remove(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    // GetAll
    @GetMapping()
    public List<Game> GetAllGame()
    {
        return games;
    }
}
