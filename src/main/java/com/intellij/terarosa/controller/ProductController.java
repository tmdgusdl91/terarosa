package com.intellij.terarosa.controller;

import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.ProductDto;
import com.intellij.terarosa.service.ProductDetailService;
import com.intellij.terarosa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductDetailService productDetailService;
    private final ProductRepository productRepository;

    @GetMapping("/productdetail/{id}")
    public String productDetailPage(@PathVariable("id") Long id, Model model) throws Exception {

        ProductDto productDto = productDetailService.getProductDetail(id);
        model.addAttribute("post",productDto);

        return "/product/productdetail";
    }
}
