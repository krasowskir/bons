package com.example.bons.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDTO {

    private String firstName;
    private String lastName;
    private String street;
    private String postCode;
    private String city;
    private String telephoneNumber;

    public AddressDTO(String firstName, String lastName, String street, String postCode, String city, String telephoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.telephoneNumber = telephoneNumber;
    }

    public AddressDTO() { }
}
