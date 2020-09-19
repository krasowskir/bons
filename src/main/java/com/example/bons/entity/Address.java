package com.example.bons.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Address {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String street;
    private String postCode;
    private String city;
    private String telephoneNumber;

    public Address() {
        this.id = UUID.randomUUID();
    }

    public Address(String firstName, String lastName, String street, String postCode, String city, String telephoneNumber) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.telephoneNumber = telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) &&
                firstName.equals(address.firstName) &&
                lastName.equals(address.lastName) &&
                street.equals(address.street) &&
                postCode.equals(address.postCode) &&
                city.equals(address.city) &&
                telephoneNumber.equals(address.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, street, postCode, city, telephoneNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
