package com.test.blog.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.blog.test.dto.TestDTO;
/*
RestController 컨트롤러에서 반횐되는 값을 JSON 형식으로 변경해준다.
 */
@RestController
public class TestController {
    @GetMapping("/api")
    public String test(){
        return "test";
    }
    @GetMapping("/api/test")
    public TestDTO setTestDTO(@RequestParam("value") String value,
                             @RequestParam("id") int id ){
        return new TestDTO(value, id);
    }
}
