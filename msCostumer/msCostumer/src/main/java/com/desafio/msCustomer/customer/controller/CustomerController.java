package com.desafio.msCustomer.customer.controller;

import com.desafio.msCustomer.customer.dto.CustomerDTORequest;
import com.desafio.msCustomer.customer.dto.CustomerDTOResponse;
import com.desafio.msCustomer.customer.dto.PasswordRequest;
import org.apache.coyote.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.List;

@RequestMapping("v1/customers")
public interface CustomerController {
    @GetMapping("/{id}")
    ResponseEntity<CustomerDTOResponse> find(@PathVariable Long id);
    @PostMapping
    ResponseEntity<CustomerDTOResponse> create(@Validated @RequestBody CustomerDTORequest request, UriComponentsBuilder builder);
    @PutMapping("/{id}")
    ResponseEntity<CustomerDTOResponse> update(@PathVariable Long id ,@Validated @RequestBody CustomerDTORequest request, UriComponentsBuilder builder);
    @PatchMapping("{id}/password")
    ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody PasswordRequest newPassword);
}
