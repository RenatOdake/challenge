package com.desafio.msPayment.payment.controller;

import com.desafio.msPayment.payment.dto.PaymentDTORequest;
import com.desafio.msPayment.payment.dto.PaymentDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("/v1/payments")
public interface PaymentController {
    @PostMapping
    ResponseEntity<PaymentDTOResponse> create(@RequestBody @Validated PaymentDTORequest request, UriComponentsBuilder builder);
    @GetMapping
    List<ResponseEntity<PaymentDTOResponse>> findAll();
    @PutMapping("/{id}")
    ResponseEntity<PaymentDTOResponse> update(@RequestBody @Validated PaymentDTORequest request,
                                              UriComponentsBuilder builder,
                                              @PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}

