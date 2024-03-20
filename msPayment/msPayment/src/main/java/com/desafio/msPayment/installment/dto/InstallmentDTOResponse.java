package com.desafio.msPayment.installment.model.dto;

import com.desafio.msPayment.installment.model.Installment;
import jakarta.persistence.Column;

public record InstallmentDTOResponse(
        Long id,
        Double amount,
        String brand,
        Long paymentId
) {
    public InstallmentDTOResponse(Installment installment){
        this(installment.getId(), installment.getAmount(), installment.getBrad(), installment.getPaymentId());
    }
}
