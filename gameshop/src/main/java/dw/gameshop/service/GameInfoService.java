package dw.gameshop.service;

import dw.gameshop.exception.ResourceNotFoundException;
import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.repository.GameInfoRepository;
import dw.gameshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameInfoService {
//    @Autowired
    GameInfoRepository gameInfoRepository;
    UserRepository userRepository;

    public GameInfoService(GameInfoRepository gameInfoRepository, UserRepository userRepository) {
        this.gameInfoRepository = gameInfoRepository;
        this.userRepository = userRepository;
    }

    public List<Game> getAllGames() {
        return gameInfoRepository.findAll();
    }

    public Game getGameById(long id) {
        Optional<Game> game = gameInfoRepository.findById(id);
        if (game.isEmpty()) {
            throw new ResourceNotFoundException("Game", "ID", id);
        } else {
            return game.get();
        }
    }

    public Game updateGameById(long id, Game game) {
        Optional<Game> game1 = gameInfoRepository.findById(id);
        if (game1.isPresent()) {
            game1.get().setImage(game.getImage());
            game1.get().setGenre(game.getGenre());
            game1.get().setPrice(game.getPrice());
            game1.get().setText(game.getText());
            game1.get().setTitle(game.getTitle());
            gameInfoRepository.save(game1.get());
            return game1.get();
        } else {
            throw new ResourceNotFoundException("Game", "ID", id);
        }
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
