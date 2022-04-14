package com.test.blog.user.dto;


import com.test.blog.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
public class UserDTO {

    private String email;

    private String name;

    private String givenName;

    private String familyName;

    private String imageUrl;

    private String id;

    private String password;

    @Builder
    public UserDTO(String email, String name, String givenName, String familyName, String imageUrl, String id, String password){
        this.email = email;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.imageUrl = imageUrl;
        this.id = id;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .givenName(givenName)
                .familyName(familyName)
                .imageUrl(imageUrl)
                .id(id)
                .password(password)
                .role("ROLE_USER")
                .build();
    }

    public UserDTO(User user){
        this.email = user.getEmail();
        this.name = user.getName();
        this.givenName = user.getGivenName();
        this.familyName = user.getFamilyName();
        this.imageUrl = user.getImageUrl();
        this.id = user.getId();
        this.password = user.getPassword();
    }

}
