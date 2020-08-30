package com.example.bons.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class PetrolStation {

    @Id
    private String id;
    private String name;

    @OneToOne
    private Address address;

    private String telephone;
    private String taxIdentificationNumberOfStation;
    private String taxIdentificationNumberOfCompany;
    private String bonNumber;
    private String StNr;
    private String USTIdentNr;

}
