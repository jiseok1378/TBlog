package com.test.blog.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class) // SpringRunner class의 생성자 실행
@WebMvcTest(controllers = TestController.class) // Web MVC에 집중할 수 있는어노테이션
public class TestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test1() throws Exception{
        final String test = "test";
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(test));
    }
}