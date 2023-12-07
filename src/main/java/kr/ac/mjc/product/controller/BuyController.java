package kr.ac.mjc.product.controller;

import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.product.domain.Buy;
import kr.ac.mjc.product.dto.AddBuyRequest;
import kr.ac.mjc.product.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuyController {

    @Autowired
    BuyService buyService;
    @PostMapping("/api/buy/{productId}")
    public ResponseEntity<Buy> placeOrder(@PathVariable long productId, @RequestBody AddBuyRequest request, HttpSession session) {
        // productId를 서비스 로직에서 사용
        String userEmail=(String)session.getAttribute("userId");
        System.out.println(userEmail);
        Buy savedOrder = buyService.save(productId, request,userEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

}
