package com.intellij.terarosa.controller;

import com.intellij.terarosa.common.Response;
import com.intellij.terarosa.common.category.SidoCategory;
import com.intellij.terarosa.repository.dto.UserDto;
import com.intellij.terarosa.service.AddressService;
import com.intellij.terarosa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
public class UserController {

    private final AddressService addressService;
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "account/signup";
    }

    @PostMapping("/signup")
    public String regit(UserDto userDto) {
        try {
            userService.signup(userDto);
        } catch (Exception e) {

        }
        return "redirect:/";
    }

    @GetMapping("/addr/main")
    @ResponseBody
    public Response address() {
        try {
            return Response.builder()
                    .success(true)
                    .message("")
                    .data(addressService.getMainAddress())
                    .build();
        } catch (Exception e) {
            return Response.builder()
                    .success(false)
                    .message(e.toString())
                    .data(null)
                    .build();
        }
    }

    @GetMapping("/addr/sub")
    @ResponseBody
    public Response address2(@RequestParam String addr1) {
        try {
            return Response.builder()
                    .success(true)
                    .message("")
                    .data(addressService.getSubAddress(addr1))
                    .build();
        } catch (Exception e) {
            return Response.builder()
                    .success(false)
                    .message(e.toString())
                    .data(null)
                    .build();
        }
    }
}
