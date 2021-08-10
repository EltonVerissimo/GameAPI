package com.example.demo.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames(){
        return gameService.getGames();
    }

    @PostMapping
    public void registerNewGame(@RequestBody Game game){
        gameService.addNewGame(game);
    }

    @DeleteMapping(path = "{gameId}")
    public void deleteGame(
            @PathVariable("gameId") Long gameId){
        gameService.deleteGame(gameId);
    }

    @PutMapping(path = "{gameId}")
    public void updateGame(
            @PathVariable("gameId") Long gameId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false ) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime releaseDate,
            @RequestParam(required = false) String platforms){

        gameService.updateGame(gameId, name, releaseDate, platforms);
    }
}