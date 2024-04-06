package org.task16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task16.entity.Game;
import org.task16.entity.Level;
import org.task16.service.LevelService;

import java.util.List;

@RestController
@RequestMapping("api/levels")
public class LevelController
{
    @Autowired
    private LevelService levelService;

    @PostMapping("/{gameId}")
    public ResponseEntity AddLevel(@RequestBody Level level,@PathVariable Long gameId)
    {
        levelService.AddLevel(level, gameId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteLevel(@PathVariable Long id)
    {
        levelService.DeleteLevel(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<Level> GetAllLevel()
    {
        return levelService.GetAllLevel();
    }

    @GetMapping("/{id}")
    public Level GetLevelById(@PathVariable Long id)
    {
        return levelService.GetLevelById(id);
    }
}
