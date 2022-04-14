package com.test.blog.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@Builder
@Getter
public class SignUpDTO {
    private String email;

    private String name;

    private String givenName;

    private String familyName;

    private String imageUrl;

    private String id;

    private String password;

}
