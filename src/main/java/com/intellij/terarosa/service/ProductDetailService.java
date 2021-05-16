package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@AllArgsConstructor
public class ProductDetailService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductDto getProductDetail(Long id) throws Exception {
        Product product = productRepository.findById(id).get();

        ProductDto productDto = ProductDto.builder()
                .id(id)
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice().toString())
                .info(product.getInfo())
                .imgpath(product.getImgpath())
                .count(product.getCount())
                .createDate(product.getCreateDate())
                .build();

        return productDto;

    }

}
