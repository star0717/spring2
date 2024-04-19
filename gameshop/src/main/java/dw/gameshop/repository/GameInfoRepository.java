package dw.gameshop.repository;

import dw.gameshop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface GameInfoRepository extends JpaRepository<Game, String> {
    Optional<Game> findById(long id);
}
