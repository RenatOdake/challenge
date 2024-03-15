package com.desafio.msCustomer.address.dto;

import jakarta.validation.constraints.NotNull;

public record AddressDTORequest(
        @NotNull
        String state,
        @NotNull
        String city,
        @NotNull
        String district,
        @NotNull
        String street,
        @NotNull
        Long number,
        @NotNull
        String cep,
        String complement,
        @NotNull
        Long customerId
) {
}
