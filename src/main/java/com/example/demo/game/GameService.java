package com.example.demo.game;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class GameService {
    public List<Game> getGames(){
        return List.of(
                new Game(
                        1L,
                        "GTA San Andreas",
                        LocalDate.of(2004, Month.OCTOBER, 26),
                        "PS2, XBOX, PC"
                )
        );
    }
}
