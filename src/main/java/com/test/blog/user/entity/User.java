package com.test.blog.user.entity;


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

    @Id
    private String id;

    @Column(length = 100, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String socialSecurityNumber;

    @Column(length = 100, nullable = false)
    private String password;


    @Builder
    public User(String id, String phoneNumber, String socialSecurityNumber, String password){
        this.id                     = id;
        this.phoneNumber            = phoneNumber;
        this.socialSecurityNumber   = socialSecurityNumber;
        this.password               = password;
    }
}
