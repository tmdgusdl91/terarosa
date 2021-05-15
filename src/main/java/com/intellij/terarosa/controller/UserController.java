package com.intellij.terarosa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.terarosa.common.ResponseEntity;
import com.intellij.terarosa.common.category.SidoCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/account")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "account/signup";
    }

    @GetMapping("/address")
    public ResponseEntity address() {
        System.out.println("옴");
        try {
            return ResponseEntity.builder()
                    .success(true)
                    .message(null)
                    .data(SidoCategory.getSidoCategory())
                    .build();
        } catch (Exception e) {
            return ResponseEntity.builder()
                    .success(false)
                    .message(e.toString())
                    .data(null)
                    .build();
        }
    }
}
