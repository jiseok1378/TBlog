package com.test.blog.user.controller;

import com.test.blog.user.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.test.blog.user.entity.UserRepository;
import com.test.blog.user.dto.UserDTO;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;


    @After
    public void end() throws Exception{
        userRepository.deleteAll();
    }
    @Test
    public void save() throws Exception{
        String id = "user1";
        String password = "1111";
        String imageUrl = "www.google.com";
        String familyName = "j";
        String givenName = "js";
        String name = "jjs";
        String email = imageUrl;
        UserDTO userDTO = UserDTO.builder()
                .id(id)
                .password(password)
                .imageUrl(imageUrl)
                .name(name)
                .familyName(familyName)
                .givenName(givenName)
                .email(email)
                .build();
        String url = "http://localhost:" + port + "/api/v1/user";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, userDTO, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(id);

        Optional<User> user_ = userRepository.findById(id);
        assertThat(user_).isNotEmpty();
        User user = user_.get();
        assertThat(user.getId()).isEqualTo(id);
    }

    @Test
    public void update() throws Exception{
        String id = "user1";
        String password = "1111";
        String imageUrl = "www.google.com";
        String familyName = "j";
        String givenName = "js";
        String name = "jjs";
        String email = imageUrl;
        User saveUser = userRepository.save(User.builder()
                .id(id)
                .password(password)
                .imageUrl(imageUrl)
                .name(name)
                .familyName(familyName)
                .givenName(givenName)
                .email(email)
                .role("ROLE_USER")
                .build());


        String url = "http://localhost:" + port + "/api/v1/user/" + id;
        UserDTO userDTO = new UserDTO(saveUser);
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDTO);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(id);

        Optional<User> user_ = userRepository.findById(id);
        assertThat(user_).isNotEmpty();
        User user = user_.get();
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getGivenName()).isEqualTo(givenName);
    }
}