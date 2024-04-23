package dw.wholesale_company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "주문세부")

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="주문세부번호")
    private long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "주문번호")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "제품번호")
    private Product product;

    @Column(name = "단가")
    private long unitPrice;

    @Column(name = "주문수량")
    private long orderQuantity;

    @Column(name = "할인율")
    private float discountRate;
}
