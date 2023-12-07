package kr.ac.mjc.product.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.product.dto.UserRequest;
import kr.ac.mjc.product.dto.UserResponse;
import kr.ac.mjc.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/join")
    public ResponseEntity<UserResponse> join(@RequestBody UserRequest request){
        UserResponse response=userService.join(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request,
                                              HttpServletRequest httpServletRequest){
        HttpSession session= httpServletRequest.getSession(true);
        UserResponse response=userService.login(request);

        if(!response.isSuccess()) {  //로그인에 실패한경우
            return ResponseEntity.ok().body(response);
        }
        //로그인에 성공한경우
        session.setAttribute("userId",response.getUser().getEmail());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/checkLoginStatus")
    public ResponseEntity<UserResponse> checkLoginStatus(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);

        if (session != null && session.getAttribute("userId") != null) {
            // 세션이 있고, userId가 설정되어 있으면 로그인된 상태
            return ResponseEntity.ok().body(new UserResponse(true, "User is logged in."));
        } else {
            // 로그인되어 있지 않은 상태
            return ResponseEntity.ok().body(new UserResponse(false, "User is not logged in."));
        }
    }

    @PostMapping("/api/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
    }


}
