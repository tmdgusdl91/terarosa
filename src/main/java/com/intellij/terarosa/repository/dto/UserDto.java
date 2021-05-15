package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.common.category.RoleCategory;
import com.intellij.terarosa.common.category.SiGunGuCategory;
import com.intellij.terarosa.common.category.SidoCategory;
import com.intellij.terarosa.domain.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String userNameKr;
    private String userPhone;
    private SidoCategory userAddr1;
    private SiGunGuCategory userAddr2;
    private String userAddr3;
    private LocalDateTime createDate;
    private RoleCategory role;

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
                .roleCategory(role)
                .build();
        return user;
    }

    @Builder
    public UserDto(String username, String password, String userNameKr, String userPhone, String userAddr1, String userAddr2, String userAddr3, String role) {
        this.username = username;
        this.password = password;
        this.userNameKr = userNameKr;
        this.userPhone = userPhone;
        this.userAddr1 = SidoCategory.valueOf(userAddr1);
        this.userAddr2 = SiGunGuCategory.valueOf(userAddr2);
        this.userAddr3 = userAddr3;
        this.role = RoleCategory.valueOf(role);
    }
}
