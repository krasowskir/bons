package com.example.bons.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@Data
//@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private PaymentMethod method;
    private Date datum;
    private String termId;
    private String proessNr;
    private String kontoNr;
    private String appId;

    private enum PaymentMethod {
        CREDITCARD, PAYPAL, SOFORTUEBERWEISUNG, INVOICE, DEBIT, RATE
    }

}
