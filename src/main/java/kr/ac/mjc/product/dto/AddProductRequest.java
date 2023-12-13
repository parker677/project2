package kr.ac.mjc.product.dto;

import kr.ac.mjc.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddProductRequest {

    private String name;

    private String type;

    private String brand;

    private int price;
    private String imagePath;  // 이미지 경로 필드 추가

    public Product toEntity(){
        Product product = new Product(this.name, this.type, this.brand, this.price, this.imagePath);  // 이미지 경로 추가
        return product;
    }

}
