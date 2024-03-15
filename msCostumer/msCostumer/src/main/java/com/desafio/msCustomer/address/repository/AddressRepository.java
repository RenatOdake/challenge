package com.desafio.msCustomer.address.repository;

import com.desafio.msCustomer.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
