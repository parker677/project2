package kr.ac.mjc.product.repository;

import kr.ac.mjc.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
