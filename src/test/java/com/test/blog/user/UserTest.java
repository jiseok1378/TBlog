package com.test.blog.user;

import com.test.blog.user.entity.User;
import com.test.blog.user.entity.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanUp(){
        userRepository.deleteAll();
    }

    @Test
    public void insertAndSelectUser(){
        final String adminId = "ADMIN";
        final String adminPassword = "ADMIN1234";
        User user = User.builder()
                .id(adminId)
                .password(adminPassword)
                .phoneNumber("000-0000-0000")
                .socialSecurityNumber("123456-1234567")
                .build();

        userRepository.save(user);

        List<User> users = userRepository.findAll();

        User user1 = users.get(0);

        Assertions.assertThat(user1.getId()).isEqualTo(adminId);
        Assertions.assertThat(user1.getPassword()).isEqualTo(adminPassword);
    }
}
