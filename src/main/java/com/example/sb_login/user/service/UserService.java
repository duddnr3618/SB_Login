package com.example.sb_login.user.service;

import com.example.sb_login.user.dto.UserDto;
import com.example.sb_login.user.entity.UserEntity;
import com.example.sb_login.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(UserDto userDto) {
        String email = userDto.getEmail();
        boolean isExists = userRepository.existsByEmail(email);
        if (!isExists) {

            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userDto.getUsername());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPhone(userDto.getPhone());
            userEntity.setAddress(userDto.getAddress());
            userEntity.setCreatedAt(LocalDateTime.now());
            userRepository.save(userEntity);
       }else {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
    }
}
