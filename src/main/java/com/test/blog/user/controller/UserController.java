package com.test.blog.user.controller;

import lombok.RequiredArgsConstructor;
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
public class UserController {


    private final UserService userService;

    @PostMapping("/api/v1/user")
    public String save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PutMapping("/api/v1/user/{id}")
    public String update(@PathVariable String id, @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserDTO findById(@PathVariable String id){
        return userService.findById(id);
    }
}
