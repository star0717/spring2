package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameInfoController {
    GameInfoService gameInfoService;

    @Autowired
    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }

    @GetMapping("api/game")
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<>(gameInfoService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("api/game/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        return new ResponseEntity<>(gameInfoService.getGameById(id), HttpStatus.OK);
    }

    @PutMapping("api/game/{id}")
    public ResponseEntity<Game> updateGameById(@PathVariable long id,
                                               @RequestBody Game game) {
        return new ResponseEntity<>(gameInfoService.updateGameById(id, game), HttpStatus.OK);
    }

    @PostMapping("products/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(gameInfoService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/products/maxprice")
    public ResponseEntity<Game> getGameWithMaxPrice(){
        return new ResponseEntity<>(gameInfoService.getGameWithMaxPrice(), HttpStatus.OK);
    }

    @GetMapping("/products/maxpricetop3")
    public ResponseEntity<List<Game>> getGameWithMaxPriceTop3(){
        return new ResponseEntity<>(gameInfoService.getGameWithMaxPriceTop3(), HttpStatus.OK);
    }
}