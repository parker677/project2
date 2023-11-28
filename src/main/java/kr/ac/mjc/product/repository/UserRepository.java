package kr.ac.mjc.product.repository;

import kr.ac.mjc.product.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public User findByEmailAndPassword(String email,String password);
}
