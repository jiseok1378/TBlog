package com.test.blog.user.entity;


import com.test.blog.user.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class User {

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String givenName;

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private String imageUrl;

    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String id, String email, String name, String givenName, String familyName, String imageUrl, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public void update(UserDTO userDTO){
        this.name = userDTO.getName();
        this.givenName = userDTO.getGivenName();
        this.familyName = userDTO.getFamilyName();
        this.imageUrl = userDTO.getImageUrl();
        this.password = userDTO.getPassword();
    }
}
