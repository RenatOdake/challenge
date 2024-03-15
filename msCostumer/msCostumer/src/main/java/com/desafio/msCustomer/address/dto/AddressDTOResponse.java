package com.desafio.msCustomer.address.dto;

import com.desafio.msCustomer.address.model.Address;

public record AddressDTOResponse(
        Long id,
        String state,
        String city,
        String district,
        String street,
        Long number,
        String CEP,
        String complement
) {
    public AddressDTOResponse(Address address){
        this(address.getId(), address.getState(), address.getCity(), address.getDistrict(),
                address.getStreet(), address.getNumber(), address.getCep(), address.getComplement());
    }
}
