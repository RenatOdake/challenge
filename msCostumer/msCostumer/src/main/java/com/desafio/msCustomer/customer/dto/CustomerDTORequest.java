package com.desafio.msCustomer.customer.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;

public record CustomerDTORequest(
        @Size(min = 3)
        String firstName,
        @Size(min = 3)
        String lastName,
        String sex,
        @Pattern(regexp="^(.+)@(\\S+)$", message="Email not valid")
        String email,
//        @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}\\.\\d{2}", message = "CPF not valid")
        String cpf,
        @Size(min = 6)
        String password,
        @PastOrPresent(message = "The birth date should be in the past or present")
        LocalDate birthDate,
        boolean active
) {
}
