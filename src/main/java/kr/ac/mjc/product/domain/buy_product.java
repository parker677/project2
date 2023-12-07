package kr.ac.mjc.product.domain;

import jakarta.persistence.*;

@Entity

public class buy_product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "count", updatable = false)
    private Long count;

}
