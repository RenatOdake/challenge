package com.desafio.msCustomer.address.service;

import com.desafio.msCustomer.address.dto.AddressDTORequest;
import com.desafio.msCustomer.address.dto.AddressDTOResponse;
import org.springframework.web.util.UriComponentsBuilder;

public interface AddressService {

    AddressDTOResponse save(AddressDTORequest request);
    AddressDTOResponse update(AddressDTORequest request, Long id);
    void delete(Long id);
}
