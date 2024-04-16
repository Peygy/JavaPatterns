package org.task17.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.task17.entity.Game;

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

    // Filter
    public List<Game> FilterGamesByName(String pattern)
    {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> criteriaQuery = builder.createQuery(Game.class);
        Root<Game> root = criteriaQuery.from(Game.class);

        var pred = builder.like(root.get("name"), "%"+pattern+"%");
        var query = criteriaQuery.select(root).where(pred);
        return session.createQuery(query).getResultList();
    }

    public List<Game> FilterGamesByDate(String pattern)
    {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> criteriaQuery = builder.createQuery(Game.class);
        Root<Game> root = criteriaQuery.from(Game.class);

        var pred = builder.like(root.get("creationDate"), "%"+pattern+"%");
        var query = criteriaQuery.select(root).where(pred);
        return session.createQuery(query).getResultList();
    }
}
