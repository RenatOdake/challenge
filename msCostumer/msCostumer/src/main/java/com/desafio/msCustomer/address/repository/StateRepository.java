package com.desafio.msCustomer.address.repository;

import com.desafio.msCustomer.address.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    Boolean findByName(String name);
}
