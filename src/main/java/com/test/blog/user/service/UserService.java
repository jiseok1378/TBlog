package com.test.blog.user.service;

import com.test.blog.config.JwtProvider;
import com.test.blog.exception.NoSearchDataException;
import com.test.blog.user.dto.SignInDTO;
import com.test.blog.user.dto.SignUpDTO;
import com.test.blog.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.blog.user.entity.UserRepository;
import com.test.blog.user.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

/**
 * 서비스는 실제 비즈니스 로직을 구현하는 단이다.
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    private SignUpDTO passwordEncode(SignUpDTO signUpDTO){
        return SignUpDTO.builder()
                .id(signUpDTO.getId())
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .email(signUpDTO.getEmail())
                .familyName(signUpDTO.getFamilyName())
                .imageUrl(signUpDTO.getImageUrl())
                .givenName(signUpDTO.getGivenName())
                .name(signUpDTO.getName())
                .build();
    }

    @Transactional
    public String signup(SignUpDTO signUpDTO) {
        if(userRepository.findById(signUpDTO.getId()).orElse(null) != null){
            throw new IllegalArgumentException("이미 존재하는 ID 입니다.");
        }
        User user = new User(passwordEncode(signUpDTO));
        userRepository.save(user);
        return user.getUsername();
    }

    public String login(SignInDTO signInDTO) {
        User user = userRepository.findById(signInDTO.getId()).orElse(null);
        if(user == null || passwordEncoder.matches(user.getPassword(), signInDTO.getPassword())){
            throw new IllegalArgumentException("아이디와 비밀번호를 다시 한번 확인해주세요");
        }
        return jwtProvider.createToken(user.getId(), Arrays.asList(user.getRole()));
    }

    public String findUserName(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("일치하는 아이디가 없습니다."));
        return user.getUsername();
    }
}
