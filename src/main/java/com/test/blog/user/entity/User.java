package com.test.blog.user.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

@Getter
@Entity
@NoArgsConstructor
public class User implements UserDetails {

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

    public void update(String phoneNumber, String socialSecurityNumber, String password){
        this.phoneNumber = phoneNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
