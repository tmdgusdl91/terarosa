package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.OrderProduct;
import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.OrderProductRepository;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.OrderProductDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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

    @Transactional
    public List<OrderProductDto> getOrderList(String username) {
        List<OrderProduct> list = orderProductRepository.findAllByUsername(username);
        List<OrderProductDto> dtoList = new ArrayList<>();
        for (OrderProduct dto : list) {
            log.trace("OrderProduct DTO :::::" + dto.toString());
            OrderProductDto orderDto = OrderProductDto.builder()
                    .id(dto.getId())
                    .username(dto.getUsername())
                    .productId(dto.getProductId())
                    .count(dto.getCount())
                    .price(dto.getPrice())
                    .product(dto.getProduct())
                    .user(dto.getUser())
                    .build();
            dtoList.add(orderDto);
        }
        return dtoList;
    }
}
