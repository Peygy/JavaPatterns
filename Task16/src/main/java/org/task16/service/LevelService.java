package org.task16.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task16.entity.Game;
import org.task16.entity.Level;
import org.task16.repository.GameRepository;
import org.task16.repository.LevelRepository;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class LevelService
{
    private LevelRepository gameRepository;

    public void AddLevel(Level level, Long gameId)
    {
        gameRepository.AddLevel(level, gameId);
    }

    public void DeleteLevel(Long id)
    {
        gameRepository.DeleteLevel(id);
    }

    public List<Level> GetAllLevel()
    {
        return gameRepository.GetAllLevel();
    }

    public Level GetLevelById(Long id)
    {
        return gameRepository.GetLevelById(id);
    }
}