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

    public Product toEntity(){
        Product product = new Product(this.name,this.type,this.brand,this.price);
        return product;
    }

}
