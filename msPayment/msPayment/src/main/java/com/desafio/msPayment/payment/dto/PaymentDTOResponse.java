package com.desafio.msPayment.payment.dto;

import com.desafio.msPayment.installment.model.Installment;
import com.desafio.msPayment.payment.model.Payment;

public record PaymentDTOResponse(
        Long id,
        String type,
        boolean installments,
        boolean active,
        Installment installment

) {
    public PaymentDTOResponse(Payment payment){
        this(payment.getId(), payment.getType(),payment.getInstallments()
                ,payment.getActive(), payment.getInstallment());
    }
}
