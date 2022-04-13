package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.domain.OrderProduct;
import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.math.BigInteger;

@Getter
@Setter
@ToString
public class OrderProductDto {

    private Long id;
    private String username;
    private Long productId;
    private int count;
    private BigInteger price;
    private ProductDto productDto;
    private User user;

    public OrderProduct toEntity() {
        return OrderProduct.builder()
                .id(id)
                .username(username)
                .productId(productId)
                .count(count)
                .price(price)
                .build();
    }

    @Builder
    public OrderProductDto (Long id, String username, Long productId, int count, BigInteger price, Product product, User user) {
        this.id = id;
        this.username = username;
        this.productId = productId;
        this.count = count;
        this.price = price;

        if (product != null) {
            this.productDto = ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .category(product.getCategory())
                    .price(String.valueOf(product.getPrice()))
                    .info(product.getInfo())
                    .imgpath(product.getImgpath())
                    .count(product.getCount())
                    .createDate(product.getCreateDate())
                    .build();
            productDto.setImgList(productDto.getBase64List());
            this.user = user;
        }
    }
}
