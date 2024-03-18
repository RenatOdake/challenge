package com.desafio.msCustomer.address.service;

import com.desafio.msCustomer.address.exception.StateNotExistsException;
import com.desafio.msCustomer.address.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService{
    private final StateRepository stateRepository;
    @Override
    public Boolean findByName(String name) {
        if(stateRepository.findByName(name)){
            return true;
        }
        throw new StateNotExistsException(String.format("Estado com nome: %s não existe", name));
    }
}
