package com.desafio.msCustomer.customer.service;

import com.desafio.msCustomer.customer.dto.CustomerDTORequest;
import com.desafio.msCustomer.customer.dto.CustomerDTOResponse;
import com.desafio.msCustomer.customer.dto.PasswordRequest;
import com.desafio.msCustomer.customer.exceptions.CustomerAlreadyExistsByCPFException;
import com.desafio.msCustomer.customer.exceptions.CustomerNotFindException;
import com.desafio.msCustomer.customer.model.Customer;
import com.desafio.msCustomer.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements  CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public CustomerDTOResponse find(Long id) {
        log.info("SERVICE - FINDING");
        return new CustomerDTOResponse(customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFindException(String.format("Customer not found by id %s." , id))));
    }

    @Override
    public CustomerDTOResponse create(CustomerDTORequest request) {
        log.info("SERVICE - CREATING");
        if(customerRepository.existsByCpf(request.cpf())){
            throw new CustomerAlreadyExistsByCPFException(String.format("CPF already exists %s. ", request.cpf()));
        }
        Customer saved = customerRepository.save(new Customer(request));
        return new CustomerDTOResponse(saved);
    }

    @Override
    public CustomerDTOResponse update(Long id, CustomerDTORequest request) {
        log.info("SERVICE - UPDATING");
        Customer customer =
                customerRepository.findById(id)
                .map(customerTemporary -> new Customer(
                        customerTemporary.getId(), request.cpf(), request.firstName(),
                        request.lastName(), request.sex(), request.birthDate(),
                        request.email(), customerTemporary.getPassword(), request.active()))
                .orElseThrow(()->new CustomerNotFindException(String.format("Customer with id %s do not exist", id)));

        return new CustomerDTOResponse(customerRepository.save(customer));
    }

    @Override
    public void updatePassword(Long id, PasswordRequest password) {
        log.info("SERVICE - UPDATING PASSWORD");

        Customer customer = customerRepository.findById(id).map(customerTemporary -> new Customer(customerTemporary.getId(),
                customerTemporary.getCpf(), customerTemporary.getFirstName(), customerTemporary.getLastName(),
                customerTemporary.getSex(), customerTemporary.getBirthDate(),
                customerTemporary.getEmail(), password.newPassword(),
                customerTemporary.isActive())).orElseThrow(()-> new CustomerNotFindException(String.format("Customer with id %s do not exist", id)));

        customerRepository.save(customer);
    }
}
