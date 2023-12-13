package kr.ac.mjc.product.service;

import kr.ac.mjc.product.domain.Product;
import kr.ac.mjc.product.dto.AddProductRequest;
import kr.ac.mjc.product.dto.UpdateProductRequest;
import kr.ac.mjc.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(AddProductRequest request) {
        return productRepository.save(request.toEntity());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return product;
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Product update(long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow();
        product.update(request.getName(), request.getType(), request.getBrand(), request.getPrice(), request.getImagePath());
        return product; // 반환을 추가해 주세요.
    }
}
