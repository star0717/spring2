package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.List;

@RestController
public class GameInfoController {
    GameInfoService gameInfoService;
    @Autowired
    public GameInfoController(GameInfoService gameInfoService){this.gameInfoService = gameInfoService;}
    @GetMapping("api/game")
    public List<Game> getAllGames(){
        return gameInfoService.getAllGames();
    }

    @GetMapping("api/game/{id}")
    public Game getGameById(@PathVariable long id){
        return gameInfoService.getGameById(id);
    }

    @PutMapping("api/game/{id}")
    public Game updateGameById(@PathVariable long id,
                                       @RequestBody Game game){
        return gameInfoService.updateGameById(id, game);
    }
}
