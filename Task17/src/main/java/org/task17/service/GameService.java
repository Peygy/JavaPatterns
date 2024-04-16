package org.task17.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task17.entity.Game;
import org.task17.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService
{
    private GameRepository gameRepository;

    public void AddGame(Game game)
    {
        gameRepository.AddGame(game);
    }

    public void DeleteGame(Long id)
    {
        gameRepository.DeleteGame(id);
    }

    public List<Game> GetAllGame()
    {
        return gameRepository.GetAllGame();
    }

    public Game GetGameById(Long id)
    {
        return gameRepository.GetGameById(id);
    }

    // Filter
    public List<Game> FilterGamesByName(String pattern)
    {
        return gameRepository.FilterGamesByName(pattern);
    }
    public List<Game> FilterGamesByDate(String pattern)
    {
        return gameRepository.FilterGamesByDate(pattern);
    }
}