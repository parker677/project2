package kr.ac.mjc.product.controller;

import kr.ac.mjc.product.domain.Product;
import kr.ac.mjc.product.dto.AddProductRequest;
import kr.ac.mjc.product.dto.UpdateProductRequest;
import kr.ac.mjc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/api/products")
        public ResponseEntity<Product> saveProduct(@RequestBody AddProductRequest request){
        Product saveRequest=productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRequest);
    }
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> allProduct(){
        List<Product> products =productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable long id) {
        Product product = productService.findOne(id);
        return ResponseEntity.ok().body(product);
    }
    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable long id,
            @RequestBody UpdateProductRequest request){
        Product product =  productService.update(id, request);
        return ResponseEntity.ok().body(product);
    }


}