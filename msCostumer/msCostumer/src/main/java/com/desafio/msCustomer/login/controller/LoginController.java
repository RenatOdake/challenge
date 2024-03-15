package com.desafio.msCustomer.login.controller;

import com.desafio.msCustomer.login.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public interface LoginController {
    @PostMapping
    void login(@RequestBody LoginRequest login);
}
