package com.desafio.msPayment.payment;

import com.desafio.msPayment.payment.dto.PaymentDTORequest;
import com.desafio.msPayment.payment.dto.PaymentDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("/v1/payments")
public interface PaymentController {
    @PostMapping
    ResponseEntity<PaymentDTOResponse> create(@RequestBody PaymentDTORequest request, UriComponentsBuilder builder);
    @GetMapping
    List<ResponseEntity<PaymentDTOResponse>> findAll();
    @PutMapping("/{id}")
    ResponseEntity<PaymentDTOResponse> update(@RequestBody PaymentDTORequest request,
                                              UriComponentsBuilder builder,
                                              @PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}

