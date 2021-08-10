package com.example.demo.game;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public void addNewGame(Game game) {
        Optional<Game> gameOptional = gameRepository
                .findGameByName(game.getName());
        if(gameOptional.isPresent()) {
            throw new IllegalStateException("Game name already exists");
        }
        gameRepository.save(game);
    }

    public void deleteGame(Long gameId) {
        boolean exists = gameRepository.existsById(gameId);
        if(!exists){
            throw new IllegalStateException(
                    "game with id " + gameId + " does not exists!"
            );
        }
        gameRepository.deleteById(gameId);
    }

    @Transactional
    public void updateGame(
                            Long gameId,
                            String name,
                            LocalDate releaseDate,
                            String platforms) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalStateException(
                        "game with id " + gameId + " does not exists!"));
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(game.getName(), name)){
            Optional<Game> gameOptional = gameRepository.findGameByName(name);
            if(gameOptional.isPresent()){
                throw new IllegalStateException("Name already exists!");
            }
            game.setName(name);
        }
        if(releaseDate != null){
            game.setName(name);
        }
        if(platforms != null){
            game.setPlatforms(platforms);
        }
    }
}
