package com.test.blog.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
RestController 컨트롤러에서 반횐되는 값을 JSON 형식으로 변경해준다.
 */
@RestController
public class TestController {
    @GetMapping("/")
    public String test(){
        return "test";
    }
}
