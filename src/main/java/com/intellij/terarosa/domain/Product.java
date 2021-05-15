package com.intellij.terarosa.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;

    @Column(columnDefinition = "BIGINT", nullable = false)
    private BigInteger price;

    @Column(columnDefinition = "LONGTEXT")
    private String info;

    @Column(length = 100)
    private String imgpath;

    @Column(length = 1000)
    private int count;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Builder
    public Product(Long id, String name, String category, BigInteger price, String info, String imgpath, int count) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.info = info;
        this.imgpath = imgpath;
        this.count = count;
    }

}
