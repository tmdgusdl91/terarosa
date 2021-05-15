package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.common.category.SiGunGuCategory;
import com.intellij.terarosa.common.category.SidoCategory;
import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class productDTO {

    private Long id;
    private String name;
    private String category;
    private BigInteger price;
    private String info;
    private String imgpath;
    private int count;
    private LocalDateTime createDate;

    public Product toEntity() {
        Product product = Product.builder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .info(info)
                .count(count)
                .build();

        return product;
    }
}
