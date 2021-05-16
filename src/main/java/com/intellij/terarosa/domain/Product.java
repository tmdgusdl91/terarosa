package com.intellij.terarosa.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
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

    @Column
    private String imgpath;

    @Column(columnDefinition = "integer default 0")
    private int count;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Builder
    public Product(Long id, String name, String category, BigInteger price, String info, String imgpath) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.info = info;
        this.imgpath = imgpath;
    }

}
