package com.intellij.terarosa.domain;

import com.intellij.terarosa.common.category.RoleCategory;
import com.intellij.terarosa.common.category.SiGunGuCategory;
import com.intellij.terarosa.common.category.SidoCategory;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "USER")
@ToString
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String username;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String password;

    @Column(length = 8, nullable = false)
    private String userNameKr;

    @Column(length = 11, nullable = false)
    private String userPhone;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private SidoCategory userAddr1;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private SiGunGuCategory userAddr2;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String userAddr3;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleCategory roleCategory;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Column
    private Boolean enabled;

    @Builder
    public User(Long id, String username, String password, String userNameKr, String userPhone,
                SidoCategory userAddr1, SiGunGuCategory userAddr2, String userAddr3, RoleCategory roleCategory) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userNameKr = userNameKr;
        this.userPhone = userPhone;
        this.userAddr1 = userAddr1;
        this.userAddr2 = userAddr2;
        this.userAddr3 = userAddr3;
        this.roleCategory = roleCategory;
    }
}