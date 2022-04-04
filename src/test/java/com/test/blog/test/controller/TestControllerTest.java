package com.test.blog.test.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) // SpringRunner class의 생성자 실행
@WebMvcTest(controllers = TestController.class) // Web MVC에 집중할 수 있는어노테이션
public class TestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test1() throws Exception{
        final String test = "test";
        mvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().string(test));
    }

    @Test
    public void testDTO() throws Exception {
        final String value = "TEST";
        final int id = 0;
        mvc.perform(get("/api/test").param("value", value).param("id", String.valueOf(id)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value", CoreMatchers.is(value))) // $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.id", CoreMatchers.is(id)));
    }
}