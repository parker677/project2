package kr.ac.mjc.product.repository;

import kr.ac.mjc.product.domain.Buy;
import kr.ac.mjc.product.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buy, Long> {

    List<Buy> findByUserId(long id);

}
