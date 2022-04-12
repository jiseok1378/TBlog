package com.test.blog.user.service;

import com.test.blog.exception.NoSearchDataException;
import com.test.blog.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.test.blog.user.entity.UserRepository;
import com.test.blog.user.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 서비스는 실제 비즈니스 로직을 구현하는 단이다.
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String save(UserDTO userDTO){
        return userRepository.save(userDTO.toEntity()).getId();
    }

    @Transactional
    public String update(String id, UserDTO userDTO){
        User user = userRepository.findById(id).orElseThrow(() -> new NoSearchDataException("error"));
        user.update(userDTO.getPhoneNumber(), userDTO.getSocialSecurityNumber(), userDTO.getPassword());
        return id;
    }

    public UserDTO findById(String id){
       User user = userRepository.findById(id).orElseThrow(() -> new NoSearchDataException("error"));
       return new UserDTO(user);
    }
}
