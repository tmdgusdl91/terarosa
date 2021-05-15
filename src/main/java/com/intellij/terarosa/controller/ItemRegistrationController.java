package com.intellij.terarosa.controller;

import com.intellij.terarosa.common.ResponseEntity;
import com.intellij.terarosa.common.category.SidoCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemRegistrationController {

    @GetMapping("/account/item")
    public String itemRegister() { return "/account/item"; }



}
