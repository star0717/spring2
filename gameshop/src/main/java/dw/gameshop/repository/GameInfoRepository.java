package dw.gameshop.repository;

import dw.gameshop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameInfoRepository extends JpaRepository<Game, String> {
    Optional<Game> findById(long id);
}
