package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.OrderProduct;
import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.OrderProductRepository;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.OrderProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@AllArgsConstructor
public class TradeService {

    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;

    @Transactional
    public void buyProduct(String username, Long itemId, int count) {
        Product product = productRepository.findById(itemId).get();
        OrderProductDto dto = OrderProductDto.builder()
                .username(username)
                .productId(itemId)
                .count(count)
                .price(product.getPrice().multiply(BigInteger.valueOf(count)))
                .build();

        OrderProduct orderProduct = dto.toEntity();
        orderProductRepository.save(orderProduct);
    }

}
