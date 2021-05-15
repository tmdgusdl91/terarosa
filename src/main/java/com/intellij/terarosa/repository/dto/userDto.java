package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.common.category.SiGunGuCategory;
import com.intellij.terarosa.common.category.SidoCategory;
import com.intellij.terarosa.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class userDto {
    private Long id;
    private String username;
    private String password;
    private String userNameKr;
    private String userPhone;
    private SidoCategory userAddr1;
    private SiGunGuCategory userAddr2;
    private String userAddr3;
    private LocalDateTime createDate;

    public User toEntity() {
        User user = User.builder()
                .id(id)
                .username(username)
                .password(password)
                .userNameKr(userNameKr)
                .userPhone(userPhone)
                .userAddr1(userAddr1)
                .userAddr2(userAddr2)
                .userAddr3(userAddr3)
                .build();
        return user;
    }
}
