package com.example.bons.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
//@Entity
public class Bon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private PetrolStation petrolStation;

    @ManyToOne
    private Payment payment;

    private TaxExtraCharge taxExtraCharge;

    private BigDecimal totalAmount;
    private BigDecimal bruttoPrice;
    private BigDecimal nettoPrice;
    private double petrolAmount;
    private float petrolPrice;

}
