package com.desafio.msCustomer.address.controller;

import com.desafio.msCustomer.address.controller.AddressController;
import com.desafio.msCustomer.address.dto.AddressDTORequest;
import com.desafio.msCustomer.address.dto.AddressDTOResponse;
import com.desafio.msCustomer.address.service.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Controller
public class AddressControllerImpl implements AddressController {
    private final AddressServiceImpl addressService;


    @Override
    public ResponseEntity<AddressDTOResponse> save(AddressDTORequest request, UriComponentsBuilder builder) {
        var response = addressService.save(request);
        var uri = builder.path("/v1/address").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<AddressDTOResponse> update(AddressDTORequest request, UriComponentsBuilder builder, Long id) {
        var response = addressService.update(request, id);
        var uri = builder.path("/v1/address/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.ok().location(uri).body(response);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
