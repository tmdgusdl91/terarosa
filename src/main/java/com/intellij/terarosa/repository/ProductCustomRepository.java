package com.intellij.terarosa.repository;

import com.intellij.terarosa.domain.Product;

import java.util.List;

public interface ProductCustomRepository {
    List<Product> findListOrderBy(String value);
}
