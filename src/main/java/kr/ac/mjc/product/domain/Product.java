package kr.ac.mjc.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany
    @JoinTable(
            name = "buy_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "buy_id")
    )
    private List<Buy> buys = new ArrayList<>();

    public Product(String name, String type, String brand, int price, String imagePath) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.imagePath = imagePath;
    }

    // 이미지 경로를 업데이트하는 메서드 추가
    public void update(String name, String type, String brand, int price, String imagePath) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getImagePath() {
        return imagePath;
    }       //이미지 추가

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }      //이미지 추가
}
