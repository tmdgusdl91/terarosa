package com.intellij.terarosa.service;

import com.fasterxml.jackson.databind.cfg.MapperBuilder;
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
    private final ProductService productService;

    @Transactional
    public ProductDto getProductDetail(Long id) {
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
        productDto.setImgList(productDto.getBase64List());

        return productDto;
    }

}
