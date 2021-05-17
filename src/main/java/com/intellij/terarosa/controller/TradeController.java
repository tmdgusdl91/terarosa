package com.intellij.terarosa.controller;

import com.intellij.terarosa.service.TradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/trade")
@AllArgsConstructor
public class TradeController {

    private final TradeService tradeService;

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable("id") Long id, Principal user, int count) {
        tradeService.buyProduct( user.getName(), id, count);
        return "redirect:/";
    }
}
