package com.desafio.msPayment.installment.dto;

import com.desafio.msPayment.installment.model.Installment;

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
