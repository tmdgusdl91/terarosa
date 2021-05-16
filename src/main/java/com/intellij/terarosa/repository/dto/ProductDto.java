package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.domain.Product;
import lombok.*;
import org.springframework.stereotype.Service;

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
    private String[] imgList;

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
    public ProductDto (Long id, String name, String category, String price, String info,
                        String imgpath, int count, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = BigInteger.valueOf(Long.parseLong(price));
        this.info = info;
        this.imgpath = imgpath;
        this.count = count;
        this.createDate = createDate;
    }
}
