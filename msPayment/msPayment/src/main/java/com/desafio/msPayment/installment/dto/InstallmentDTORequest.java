package com.desafio.msPayment.installment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstallmentDTORequest(
        @NotNull(message = "Amount can't be null")
        Double amount,
        @NotNull(message = "Brand can't be null")
        @NotBlank(message = "Brand can't be blank")
        String brand,
        @NotNull(message = "Payment Id can't be null")
        Long paymentId

) {
}
