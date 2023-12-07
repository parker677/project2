package kr.ac.mjc.product.repository;

import kr.ac.mjc.product.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyRepository extends JpaRepository<Buy, Long> {
}
