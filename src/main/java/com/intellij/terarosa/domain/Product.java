package com.intellij.terarosa.domain;


import lombok.*;
import org.apache.commons.io.FileUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Base64;

@Getter
@Setter
@Entity(name = "PRODUCT")
@NoArgsConstructor
public class Product  implements Serializable {

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
