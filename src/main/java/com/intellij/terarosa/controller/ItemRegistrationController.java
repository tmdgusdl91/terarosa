package com.intellij.terarosa.controller;

import com.intellij.terarosa.common.category.SidoCategory;
import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.ProductDto;
import com.intellij.terarosa.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Slf4j
@RequestMapping("/product")
@AllArgsConstructor
public class ItemRegistrationController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/item")
    public String itemRegiPage() { return "/product/item"; }

    @PostMapping("/item")
    public String itemRegi(ProductDto productDto, @RequestPart MultipartFile[] sourceFile) {

        try {
            productService.itemRegi(productDto);
            productService.uploadAttachment(sourceFile);
        } catch (Exception e) {
        }
        return "redirect:/";
    }





}
