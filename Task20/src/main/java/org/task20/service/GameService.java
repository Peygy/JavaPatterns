package org.task20.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.task20.entity.Game;
import org.task20.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GameService
{
    private GameRepository gameRepository;

    public void AddGame(Game game)
    {
        log.info("Игра сохранена");
        gameRepository.save(game);
    }

    public void DeleteGame(Long id)
    {
        gameRepository.deleteById(id);
    }

    public List<Game> GetAllGame()
    {
        log.info("Получили все игры");
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