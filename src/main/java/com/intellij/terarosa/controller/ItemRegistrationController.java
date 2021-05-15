package com.intellij.terarosa.controller;

import com.intellij.terarosa.common.category.SidoCategory;
import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.dto.ProductDto;
import com.intellij.terarosa.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/product")
@AllArgsConstructor
public class ItemRegistrationController {

    private final ProductService productService;

    @GetMapping("/item")
    public String itemRegiPage() { return "/product/item"; }

    @PostMapping("/item")
    public String itemRegi(ProductDto productDto) {

        try {
           productService.itemRegi(productDto);
        } catch (Exception e) {

        }

        return "redirect:/";
    }





}
