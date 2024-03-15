package com.desafio.msCustomer.customer.dto;

import com.desafio.msCustomer.customer.model.Customer;

import java.time.LocalDate;
import java.util.Date;

public record CustomerDTOResponse(Long id, String cpf, String firstName, String lastName, String email, LocalDate birthDate, String sex, Boolean active) {
    public CustomerDTOResponse(Customer costumer){
        this(costumer.getId(), costumer.getCpf(), costumer.getFirstName(),
                costumer.getLastName(), costumer.getEmail(),
                costumer.getBirthDate(), costumer.getSex(), costumer.isActive());
    }
}
