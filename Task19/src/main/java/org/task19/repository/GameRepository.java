package org.task19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task19.entity.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>
{
    List<Game> findAllByNameContains(String name);
    List<Game> findAllByCreationDateContains(String date);
}
