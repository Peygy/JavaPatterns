package org.task22.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.task22.entity.Game;
import org.task22.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
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