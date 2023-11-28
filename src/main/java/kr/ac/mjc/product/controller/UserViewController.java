package kr.ac.mjc.product.controller;

import kr.ac.mjc.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @Autowired
    UserService userService;

    private long id;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html이 있는 경로를 반환
    }

    @GetMapping("/join")
    public String showJoinPage() {
        return "join";
    }


}
