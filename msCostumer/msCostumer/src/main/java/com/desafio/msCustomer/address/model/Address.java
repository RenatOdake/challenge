package com.desafio.msCustomer.address.model;

import com.desafio.msCustomer.address.dto.AddressDTORequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String state;
    private String city;
    private String district;
    private String street;
    private Long number;
    private String cep;
    private String complement;
    @Column(name = "customerId")
    private Long customerId;

    public Address(AddressDTORequest request) {
        this.state = request.state();
        this.city = request.city();
        this.district = request.district();
        this.street = request.street();
        this.number = request.number();
        this.cep = request.cep();
        this.complement = request.complement();
    }


}
