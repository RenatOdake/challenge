package com.desafio.msCustomer.customer.dto;

import jakarta.validation.constraints.Size;

public record PasswordRequest(
        @Size(min = 5)
        String newPassword
) {
}
