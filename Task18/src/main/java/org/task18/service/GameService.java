package org.task18.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task18.entity.Game;
import org.task18.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService
{
    private GameRepository gameRepository;

    public void AddGame(Game game)
    {
        gameRepository.save(game);
    }

    public void DeleteGame(Long id)
    {
        gameRepository.deleteById(id);
    }

    public List<Game> GetAllGame()
    {
        return gameRepository.findAll();
    }

    public Game GetGameById(Long id)
    {
        return gameRepository.findById(id).get();
    }

    // Filter
    public List<Game> FilterGamesByName(String pattern)
    {
        return gameRepository.findAllByNameContains(pattern);
    }
    public List<Game> FilterGamesByDate(String pattern)
    {
        return gameRepository.findAllByCreationDateContains(pattern);
    }
}