package dw.gameshop.service;

import dw.gameshop.exception.ResourceNotFoundException;
import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.repository.GameInfoRepository;
import dw.gameshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // 제일 비싼 게임의 정보
    public Game getGameWithMaxPrice(){
        List<Game> games = gameInfoRepository.findAll();
        // 일반 자바코드
//        Game max = games.get(0);
//        for (int i = 0; i < games.size()-1 ; i++) {
//            if (max.getPrice() < games.get(i + 1).getPrice()) {
//                max = games.get(i+1);
//            }
//        }
//        return max;
        // 람다식을 활용한 예
 //       games.sort(Comparator.comparingInt((Game g) -> g.getPrice()).reversed());
//        return games.stream().sorted(Comparator.comparingInt((Game game) -> game.getPrice())
//                .reversed()).findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException("Max Price", " , "," "));
        // jpql 사용 예
        return gameInfoRepository.getGameWithMaxPrice();
    }

    // 제일 비싼 게임 Top3
    public List<Game> getGameWithMaxPriceTop3() {
//        List<Game> games = gameInfoRepository.findAll();
//        games.sort(Comparator.comparingInt((Game game) -> game.getPrice()).reversed());
//        List<Game> newGames = new ArrayList<>();
//        newGames.add(games.get(0));
//        newGames.add(games.get(1));
//        newGames.add(games.get(2));
//        return newGames;
        return gameInfoRepository.getGameWithMaxPriceTop3()
                .stream().limit(3).collect(Collectors.toList());
    }
}
