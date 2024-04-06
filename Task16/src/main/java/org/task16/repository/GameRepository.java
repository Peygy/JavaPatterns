package org.task16.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.task16.entity.Game;
import org.task16.entity.Level;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameRepository
{
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init()
    {
        session = sessionFactory.openSession();
    }

    public void AddGame(Game game)
    {
        var t = session.beginTransaction();
        session.persist(game);
        t.commit();
    }

    public void DeleteGame(Long id)
    {
        var t = session.beginTransaction();
        session.remove(session.find(Game.class, id));
        t.commit();
    }

    public List<Game> GetAllGame()
    {
        var t = session.beginTransaction();
        var games = session.createQuery("select g from Game g", Game.class).getResultList();

        for (Game g : games)
        {
            var levels = session.createQuery("select l from Level l where l.gameId=%s".formatted(g.getId()), Level.class).getResultList();
            g.setLevels(levels);
        }

        t.commit();
        return games;
    }

    public Game GetGameById(Long id)
    {
        var t = session.beginTransaction();
        var game = session.find(Game.class, id);
        t.commit();
        return game;
    }
}
