package com.desafio.msCustomer.customer.controller;

import com.desafio.msCustomer.customer.dto.CustomerDTORequest;
import com.desafio.msCustomer.customer.dto.CustomerDTOResponse;
import com.desafio.msCustomer.customer.dto.PasswordRequest;
import com.desafio.msCustomer.customer.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.List;
@Controller
@RequiredArgsConstructor
@Slf4j
public class CustomerControllerImpl implements CustomerController{
    private final CustomerServiceImpl customerService;
    @Override
    public ResponseEntity<CustomerDTOResponse> find(Long id) {
        return ResponseEntity.ok(customerService.find(id));
    }

    @Override
    public ResponseEntity<CustomerDTOResponse> create(CustomerDTORequest request, UriComponentsBuilder builder) {
        var response = customerService.create(request);
        var uri = builder.path("v1/customers").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<CustomerDTOResponse> update(Long id, CustomerDTORequest request, UriComponentsBuilder builder) {
        var response = customerService.update(id, request);
        var uri = builder.path("v1/customers/{id}").buildAndExpand(response).toUri();
        return ResponseEntity.ok().location(uri).body(response);
    }

    @Override
    public ResponseEntity<Void> updatePassword(Long id, PasswordRequest newPassword) {
        customerService.updatePassword(id, newPassword);
        return ResponseEntity.noContent().build();
    }


}
