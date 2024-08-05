package com.example.sb_login.user.dto;

import com.example.sb_login.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class UserDto {
    private String username;
    private String email;
    private String password;
    private String password2;
    private String phone;
    private String address;

    public UserEntity toEntity(UserDto userDto){
        return UserEntity.builder()
                .username(username)
                .password(password)
                .phone(phone)
                .email(email)
                .address(address)
                .build();
    }

}

