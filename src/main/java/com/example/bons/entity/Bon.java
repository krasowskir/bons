package com.example.bons.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Bon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private PetrolStation petrolStation;

    private BigDecimal totalAmount;
    private BigDecimal bruttoPrice;
    private BigDecimal nettoPrice;

    private TaxExtraCharge taxExtraCharge;
    private double petrolAmount;
    private float petrolPrice;

    @OneToOne
    private Payment payment;

}
