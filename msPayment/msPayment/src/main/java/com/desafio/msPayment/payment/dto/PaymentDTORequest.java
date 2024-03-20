package com.desafio.msPayment.payment.dto;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentDTORequest(
        @NotNull(message = "Type can't be null")
        @NotBlank(message = "Type can't be blank")
        String type,
        @AssertTrue(message = "Active must be true")
        @NotNull(message = "Installment can't be null")

        Boolean installments,
        @NotNull(message = "Active can't be null")
        Boolean active
) {
}
