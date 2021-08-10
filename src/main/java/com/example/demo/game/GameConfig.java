package com.example.demo.game;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GameConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            GameRepository repository){
        return args -> {
            Game gtaSanAndreas = new Game(
                    "GTA San Andreas",
                    LocalDate.of(2004, Month.OCTOBER, 26),
                    "PS2, XBOX, PC"
            );
            Game godOfWar = new Game(
                    "God of war",
                    LocalDate.of(2005, Month.MARCH, 22),
                    "PS2"
            );

            repository.saveAll(
                    List.of(gtaSanAndreas, godOfWar)
            );
        };
    }
}
