package com.test.blog.user.dto;


import com.test.blog.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String phoneNumber;
    private String socialSecurityNumber;
    private String password;

    @Builder
    public UserDTO(String id, String phoneNumber, String socialSecurityNumber, String password){
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.socialSecurityNumber =socialSecurityNumber;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .phoneNumber(phoneNumber)
                .socialSecurityNumber(socialSecurityNumber)
                .password(password)
                .build();
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.password = user.getPassword();
        this.socialSecurityNumber = user.getSocialSecurityNumber();
        this.phoneNumber = user.getPhoneNumber();
    }

}
