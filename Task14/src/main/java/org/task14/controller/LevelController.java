package org.task14.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task14.entity.Game;
import org.task14.entity.Level;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("level")
public class LevelController
{
    private List<Level> levels = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity AddGame(@RequestBody Level level)
    {
        levels.add(level);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteGame(@PathVariable int id)
    {
        levels.remove(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    // GetAll
    @GetMapping()
    public List<Level> GetAllGame()
    {
        return levels;
    }
}
