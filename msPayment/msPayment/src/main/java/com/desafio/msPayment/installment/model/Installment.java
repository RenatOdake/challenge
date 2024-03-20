package com.desafio.msPayment.installment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="installment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Installment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String brad;
    @Column(name="paymentId")
    private Long paymentId;
}
