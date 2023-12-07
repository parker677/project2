package kr.ac.mjc.product.service;

import kr.ac.mjc.product.domain.Buy;
import kr.ac.mjc.product.domain.Product;
import kr.ac.mjc.product.domain.User;
import kr.ac.mjc.product.dto.AddBuyRequest;
import kr.ac.mjc.product.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyService {
    @Autowired
    BuyRepository buyRepository;
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public Buy save(Long productId, AddBuyRequest request,String userEmail) {
        User user=userService.findByEmail(userEmail);
        Product product = productService.findOne(productId);
        Buy buy=request.toEntity();
        buy.setUser(user);
        buy.getProducts().add(product);
        return buyRepository.save(buy);
    }


    public List<Buy> getUserOrders(long userId) {
        return buyRepository.findByUserId(userId);
    }
}
