package dw.gameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// getter & setter 생략 가능하게 만들어주는 어노테이션 (Lombok) => Entity에서만 사용 가능함
@NoArgsConstructor // 기본생성자
@AllArgsConstructor
@Setter
@Getter


@Entity
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "purchase_time")
    private LocalDateTime purchaseTime;
}
