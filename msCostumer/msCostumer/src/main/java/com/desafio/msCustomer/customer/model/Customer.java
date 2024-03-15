package com.desafio.msCustomer.customer.model;

import com.desafio.msCustomer.address.model.Address;
import com.desafio.msCustomer.customer.dto.CustomerDTORequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @Column(name="firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    private String sex;
    @Column(name="birthDate")
    private LocalDate birthDate;
    private String email;
    private String password;
    private boolean active;


    public Customer(CustomerDTORequest request){
        this.cpf = request.cpf();
        this.firstName = request.firstName();
        this.lastName = request.lastName();
        this.sex = request.sex();
        this.birthDate = request.birthDate();
        this.email = request.email();
        this.password = request.password();
        this.active = request.active();
    }
}
