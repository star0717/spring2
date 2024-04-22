package dw.wholesale_company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


@Entity
@Table(name="제품")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="제품번호")
    private long productId;

    @Column(name = "제품명")
    private String productName;

    @Column(name = "포장단위")
    private String pkgUnit;

    @ManyToOne
    @JoinColumn(name = "단가")
    private OrderDetail unitPrice;

    @Column(name = "재고")
    private long inventory;
}
