package com.intellij.terarosa.repository;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {

    Product findTop1ByOrderByIdDesc();
}
