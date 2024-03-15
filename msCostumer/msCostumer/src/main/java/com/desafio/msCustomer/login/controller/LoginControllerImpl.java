package com.desafio.msCustomer.login.controller;

import com.desafio.msCustomer.login.dto.LoginRequest;
import com.desafio.msCustomer.login.service.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController{
    private final LoginServiceImpl service;
    @Override
    public void login(LoginRequest login) {
        service.login(login);
    }
}
