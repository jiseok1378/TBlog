package com.test.blog.user.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.blog.user.dto.SignUpDTO;
import com.test.blog.user.dto.UserDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;


    private String role;


    public User(SignUpDTO signUpDTO){
        this.id = signUpDTO.getId();
        this.password = signUpDTO.getPassword();
        this.email = signUpDTO.getEmail();
        this.familyName = signUpDTO.getFamilyName();
        this.givenName = signUpDTO.getGivenName();
        this.name = signUpDTO.getName();
        this.imageUrl = signUpDTO.getImageUrl();
        this.role = "ROLE_USER";
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.role));
    }

    @Override
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getUsername() {
        return this.email;
    }

    @Override
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isEnabled() {
        return true;
    }
}
