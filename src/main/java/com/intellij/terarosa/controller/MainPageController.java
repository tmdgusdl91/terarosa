package com.intellij.terarosa.controller;

import com.intellij.terarosa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class MainPageController implements WebMvcConfigurer {

    private final ProductService productService;

    @GetMapping("/")
    public String main(Model model) throws IOException {
        model.addAttribute("bestList",productService.getList("count"));
        model.addAttribute("newList", productService.getList("create_date"));
        return "/main/main.html";
    }

    @GetMapping("/image/{img}")
    public String main1(@PathVariable("img") String img) {
        return null;
    }
}
