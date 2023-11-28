package kr.ac.mjc.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class send {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name ="phoneNumber", nullable = false)
    private int phoneNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "creditCardType", nullable = false)
    private String creditCardType;
    @Column(name = "creditCardNumber", nullable = false)
    private int creditCardNumber;
}
