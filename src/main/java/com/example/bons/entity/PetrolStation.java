package com.example.bons.entity;

import java.util.Objects;

public class PetrolStation {

    private long id;
    private String name;

    private Address address;

    private String telephone;
    private String taxIdentificationNumberOfStation;
    private String taxIdentificationNumberOfCompany;
    private String bonNumber;
    private String stNr;
    private String uSTIdentNr;

    public PetrolStation(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public String getStNr() {
        return stNr;
    }

    public void setStNr(String stNr) {
        this.stNr = stNr;
    }

    public String getuSTIdentNr() {
        return uSTIdentNr;
    }

    public void setuSTIdentNr(String uSTIdentNr) {
        this.uSTIdentNr = uSTIdentNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetrolStation that = (PetrolStation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(taxIdentificationNumberOfStation, that.taxIdentificationNumberOfStation) &&
                Objects.equals(taxIdentificationNumberOfCompany, that.taxIdentificationNumberOfCompany) &&
                Objects.equals(bonNumber, that.bonNumber) &&
                Objects.equals(stNr, that.stNr) &&
                Objects.equals(uSTIdentNr, that.uSTIdentNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, telephone, taxIdentificationNumberOfStation, taxIdentificationNumberOfCompany, bonNumber, stNr, uSTIdentNr);
    }

    @Override
    public String toString() {
        return "PetrolStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", telephone='" + telephone + '\'' +
                ", taxIdentificationNumberOfStation='" + taxIdentificationNumberOfStation + '\'' +
                ", taxIdentificationNumberOfCompany='" + taxIdentificationNumberOfCompany + '\'' +
                ", bonNumber='" + bonNumber + '\'' +
                ", StNr='" + stNr + '\'' +
                ", USTIdentNr='" + uSTIdentNr + '\'' +
                '}';
    }
}
