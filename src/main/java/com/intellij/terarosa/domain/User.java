package com.intellij.terarosa.domain;

import com.intellij.terarosa.common.SiGunGuCategory;
import com.intellij.terarosa.common.SidoCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String userId;

    @Column(length = 16, nullable = false)
    private String userPw;

    @Column(length = 8, nullable = false)
    private String userName;

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

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Builder
    public User(Long id, String userId, String userPw, String userName, String userPhone,
                SidoCategory userAddr1, SiGunGuCategory userAddr2, String userAddr3) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddr1 = userAddr1;
        this.userAddr2 = userAddr2;
        this.userAddr3 = userAddr3;
    }
}