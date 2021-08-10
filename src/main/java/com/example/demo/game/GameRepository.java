package com.example.demo.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository
        extends JpaRepository<Game, Long> {

    // SELECT * FROM game WHERE name = ?
    @Query("SELECT s FROM Game s WHERE s.name = ?1")
    Optional<Game> findGameByName(String name);
}
