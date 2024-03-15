package com.desafio.msCustomer.customer.service;

import com.desafio.msCustomer.customer.dto.CustomerDTORequest;
import com.desafio.msCustomer.customer.dto.CustomerDTOResponse;
import com.desafio.msCustomer.customer.dto.PasswordRequest;

import java.lang.reflect.Array;

public interface CustomerService {
    CustomerDTOResponse find(Long id);
    CustomerDTOResponse create(CustomerDTORequest request);
    CustomerDTOResponse update(Long id, CustomerDTORequest request);
    void updatePassword(Long id, PasswordRequest password);


}
