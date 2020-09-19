package com.example.bons.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "petrolstation")
@Builder
@AllArgsConstructor
public class PetrolStation {

    @Id
    private UUID id;
    private String name;

    @OneToOne
    private Address address;

    private String telephone;
    private String taxIdentificationNumberOfStation;
    private String taxIdentificationNumberOfCompany;
    private String bonNumber;
    private String StNr;
    private String USTIdentNr;

    public PetrolStation(){
        this.id = UUID.randomUUID();
    }
}
