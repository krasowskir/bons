package com.example.bons.entity;

import javax.persistence.Entity;
import java.util.Objects;


public class PetrolStation {

    public Address address;
    public String id;
    public String telephone;
    public String taxIdentificationNumberOfStation;
    public String taxIdentificationNumberOfCompany;
    public String bonNumber;

    public PetrolStation() { }

    public PetrolStation(Address address, String id, String telephone, String taxIdentificationNumberOfStation, String taxIdentificationNumberOfCompany, String bonNumber) {
        this.address = address;
        this.id = id;
        this.telephone = telephone;
        this.taxIdentificationNumberOfStation = taxIdentificationNumberOfStation;
        this.taxIdentificationNumberOfCompany = taxIdentificationNumberOfCompany;
        this.bonNumber = bonNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTaxIdentificationNumberOfStation() {
        return taxIdentificationNumberOfStation;
    }

    public void setTaxIdentificationNumberOfStation(String taxIdentificationNumberOfStation) {
        this.taxIdentificationNumberOfStation = taxIdentificationNumberOfStation;
    }

    public String getTaxIdentificationNumberOfCompany() {
        return taxIdentificationNumberOfCompany;
    }

    public void setTaxIdentificationNumberOfCompany(String taxIdentificationNumberOfCompany) {
        this.taxIdentificationNumberOfCompany = taxIdentificationNumberOfCompany;
    }

    public String getBonNumber() {
        return bonNumber;
    }

    public void setBonNumber(String bonNumber) {
        this.bonNumber = bonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetrolStation that = (PetrolStation) o;
        return address.equals(that.address) &&
                id.equals(that.id) &&
                telephone.equals(that.telephone) &&
                taxIdentificationNumberOfStation.equals(that.taxIdentificationNumberOfStation) &&
                taxIdentificationNumberOfCompany.equals(that.taxIdentificationNumberOfCompany) &&
                bonNumber.equals(that.bonNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, id, telephone, taxIdentificationNumberOfStation, taxIdentificationNumberOfCompany, bonNumber);
    }

    @Override
    public String toString() {
        return "PetrolStation{" +
                "address=" + address +
                ", id='" + id + '\'' +
                ", telephone='" + telephone + '\'' +
                ", taxIdentificationNumberOfStation='" + taxIdentificationNumberOfStation + '\'' +
                ", taxIdentificationNumberOfCompany='" + taxIdentificationNumberOfCompany + '\'' +
                ", bonNumber='" + bonNumber + '\'' +
                '}';
    }
}
