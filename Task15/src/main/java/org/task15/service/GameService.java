package org.task15.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task15.entity.Game;
import org.task15.repository.GameRepository;

import java.sql.SQLException;
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

    public List<Game> GetGames()
    {
        return gameRepository.GetAllGame();
    }

    public Game GetGameById(Long id)
    {
        return gameRepository.GetGameById(id);
    }
}