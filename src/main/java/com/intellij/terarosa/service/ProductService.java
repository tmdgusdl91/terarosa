package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void itemRegi(ProductDto productDto) throws Exception {
        try{
            Product product = productDto.toEntity();
            product.setImgpath("\\"+product.getName()+"\\");
            productRepository.save(product);
        }catch (Exception e) {
            throw new Exception();
        }
    }
}
