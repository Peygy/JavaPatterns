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
public class LevelRepository
{
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init()
    {
        session = sessionFactory.openSession();
    }

    public void AddLevel(Level level, Long gameId)
    {
        var t = session.beginTransaction();
        var game = session.get(Game.class, gameId);
        level.setGame(game);
        session.persist(level);
        t.commit();
    }

    public void DeleteLevel(Long id)
    {
        var t = session.beginTransaction();
        session.remove(session.find(Level.class, id));
        t.commit();
    }

    public List<Level> GetAllLevel()
    {
        var t = session.beginTransaction();
        var levels = session.createQuery("select g from Level g", Level.class).getResultList();
        t.commit();
        return levels;
    }

    public Level GetLevelById(Long id)
    {
        var t = session.beginTransaction();
        var game = session.find(Level.class, id);
        t.commit();
        return game;
    }
}
