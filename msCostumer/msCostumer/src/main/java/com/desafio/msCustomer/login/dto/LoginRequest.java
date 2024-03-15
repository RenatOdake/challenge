package com.desafio.msCustomer.login.dto;

import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Size(min=5)
        String username,
        @Size(min = 5)
        String password
) {

}
