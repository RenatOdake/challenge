package com.desafio.msCustomer.address.service;

import com.desafio.msCustomer.address.dto.AddressDTORequest;
import com.desafio.msCustomer.address.dto.AddressDTOResponse;
import com.desafio.msCustomer.address.exception.AddressNotFoundException;
import com.desafio.msCustomer.address.model.Address;

import com.desafio.msCustomer.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final StateServiceImpl stateService;
    @Override
    public AddressDTOResponse save(AddressDTORequest request) {
        stateService.findByName(request.state());
        Address addressSaved = addressRepository.save(new Address(request));
        return new AddressDTOResponse(addressSaved);
    }

    @Override
    public AddressDTOResponse update(AddressDTORequest request, Long id) {
        Address addressUpdated = addressRepository.findById(id).map
                (addressTemporary -> new Address(
                addressTemporary.getId(), request.state(),
                request.city(), request.district(),
                request.street(), request.number(),
                request.cep(), request.complement(), request.customerId())).orElseThrow(()->
        new AddressNotFoundException(String.format("Address with id: %s was not found", id)));
        return new AddressDTOResponse(addressRepository.save(addressUpdated));
    }

    @Override
    public void delete(Long id) {
        addressRepository.findById(id).orElseThrow(
                ()-> new AddressNotFoundException(String.format("Address with id was not found %s", id)));

        addressRepository.deleteById(id);
    }
}
