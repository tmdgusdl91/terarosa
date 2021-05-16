package com.intellij.terarosa.repository;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findTop1ByOrderByIdDesc();

}
