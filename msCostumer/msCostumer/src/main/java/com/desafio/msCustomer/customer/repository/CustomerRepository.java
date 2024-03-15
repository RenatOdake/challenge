package com.desafio.msCustomer.customer.repository;

import com.desafio.msCustomer.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsByCpf(String cpf);

    Optional<Customer> findByEmailAndPassword(String username, String password);
}
