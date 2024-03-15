package com.desafio.msCustomer.login.service;

import com.desafio.msCustomer.customer.model.Customer;
import com.desafio.msCustomer.customer.repository.CustomerRepository;
import com.desafio.msCustomer.login.dto.LoginRequest;
import com.desafio.msCustomer.login.exception.LoginIncorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final CustomerRepository repository;
    @Override
    public void login(LoginRequest request) {
        Customer existsCustomer = repository.findByEmailAndPassword(request.username(), request.password()).orElseThrow(
                () -> new LoginIncorrectException("Email or Password incorrect.")
        );
    }
}
