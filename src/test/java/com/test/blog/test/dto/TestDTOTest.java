package com.test.blog.test.dto;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;



public class TestDTOTest {
    @Test
    public void DTO_X_LombokTest(){
        String value = "test";
        int id = 0;

        TestDTO dto = new TestDTO(value, id);

        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getValue()).isEqualTo(value);
    }
}