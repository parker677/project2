package kr.ac.mjc.product.service;

import kr.ac.mjc.product.domain.Buy;
import kr.ac.mjc.product.domain.User;
import kr.ac.mjc.product.dto.AddBuyRequest;
import kr.ac.mjc.product.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyService {
    @Autowired
    BuyRepository buyRepository;
    @Autowired
    UserService userService;

    public Buy save(Long productId, AddBuyRequest request,String userEmail) {
        User user=userService.findByEmail(userEmail);
        Buy buy=request.toEntity();
        buy.setUser(user);
        return buyRepository.save(buy);
    }
}
