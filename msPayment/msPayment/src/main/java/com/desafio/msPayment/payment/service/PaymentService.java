package com.desafio.msPayment.payment.service;

import com.desafio.msPayment.payment.dto.PaymentDTORequest;
import com.desafio.msPayment.payment.dto.PaymentDTOResponse;

import java.util.List;

public interface PaymentService {
    PaymentDTOResponse create(PaymentDTORequest request);
    PaymentDTOResponse update(PaymentDTORequest request, Long id);
    List<PaymentDTOResponse> findAll();
    void delete(Long id);
}
