package kr.ac.mjc.product.controller;

import kr.ac.mjc.product.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BuyViewController {
    @Autowired
    BuyService buyService;


}
