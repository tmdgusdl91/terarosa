package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.domain.Product;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDto {

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
                .imgpath(imgpath)
                .build();
        return product;
    }

    @Builder
    public ProductDto (String name, String category, String price, String info) {
        this.name = name;
        this.category = category;
        this.price = BigInteger.valueOf(Long.parseLong(price));
        this.info = info;
    }
}
