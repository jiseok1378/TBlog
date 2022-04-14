package com.test.blog.user.controller;

import com.test.blog.config.JwtProvider;
import com.test.blog.user.dto.SignInDTO;
import com.test.blog.user.dto.SignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.test.blog.user.dto.UserDTO;
import com.test.blog.user.service.UserService;

/**
 * Bean을 주입 받을 때 방법은 3가지가 있다.
 * @Autowired
 * setter
 * 생성자
 *
 * 이중 가장 권장되는 방법은 생성자로 주입받는것이다.
 * @RequiredArgsConstructor로 final이 선언된 모든 필드에 Bean을 주입받는다.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    private String signup(SignUpDTO signUpDTO){
        return userService.signup(signUpDTO);
    }

    @PostMapping("/login")
    private String login(SignInDTO signInDTO){
        return userService.login(signInDTO);
    }

    @GetMapping("/user/{id}")
    private String findUserName(@PathVariable("id") String id){
        return userService.findUserName(id);

    }

}
