package com.desafio.msCustomer.address.controller;

import com.desafio.msCustomer.address.dto.AddressDTORequest;
import com.desafio.msCustomer.address.dto.AddressDTOResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/v1/address")
public interface AddressController {

    @PostMapping
    ResponseEntity<AddressDTOResponse> save(@RequestBody AddressDTORequest request, UriComponentsBuilder builder);

    @PutMapping("/{id}")
    ResponseEntity<AddressDTOResponse> update(@RequestBody AddressDTORequest request, UriComponentsBuilder builder,
                              @PathVariable Long id);

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
