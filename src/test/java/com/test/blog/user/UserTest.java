package com.test.blog.user;

import com.test.blog.user.dto.UserDTO;
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
        String id = "user1";
        String password = "1111";
        String imageUrl = "www.google.com";
        String familyName = "j";
        String givenName = "js";
        String name = "jjs";
        String email = imageUrl;
        User user = User.builder()
                .id(id)
                .name(name)
                .password(password)
                .imageUrl(imageUrl)
                .familyName(familyName)
                .givenName(givenName)
                .email(email)
                .build();

        userRepository.save(user);

        List<User> users = userRepository.findAll();

        User user1 = users.get(0);

        Assertions.assertThat(user1.getId()).isEqualTo(id);
        Assertions.assertThat(user1.getPassword()).isEqualTo(password);
    }
}
