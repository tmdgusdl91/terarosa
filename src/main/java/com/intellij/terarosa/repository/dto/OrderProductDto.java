package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.domain.OrderProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    public OrderProductDto (Long id, String username, Long productId, int count, BigInteger price) {
        this.id = id;
        this.username = username;
        this.productId = productId;
        this.count = count;
        this.price = price;
    }

}
