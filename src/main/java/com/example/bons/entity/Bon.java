package com.example.bons.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Objects;


public class Bon {

    private PetrolStation petrolStation;
    private BigDecimal totalAmount;
    private TaxExtraCharge taxExtraCharge;
    private double petrolAmount;
    private float petrolPrice;

    public Bon() {
    }

    public PetrolStation getPetrolStation() {
        return petrolStation;
    }

    public void setPetrolStation(PetrolStation petrolStation) {
        this.petrolStation = petrolStation;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TaxExtraCharge getTaxExtraCharge() {
        return taxExtraCharge;
    }

    public void setTaxExtraCharge(TaxExtraCharge taxExtraCharge) {
        this.taxExtraCharge = taxExtraCharge;
    }

    public double getPetrolAmount() {
        return petrolAmount;
    }

    public void setPetrolAmount(double petrolAmount) {
        this.petrolAmount = petrolAmount;
    }

    public float getPetrolPrice() {
        return petrolPrice;
    }

    public void setPetrolPrice(float petrolPrice) {
        this.petrolPrice = petrolPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bon bon = (Bon) o;
        return Double.compare(bon.petrolAmount, petrolAmount) == 0 &&
                Float.compare(bon.petrolPrice, petrolPrice) == 0 &&
                petrolStation.equals(bon.petrolStation) &&
                totalAmount.equals(bon.totalAmount) &&
                taxExtraCharge == bon.taxExtraCharge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(petrolStation, totalAmount, taxExtraCharge, petrolAmount, petrolPrice);
    }

    @Override
    public String toString() {
        return "Bon{" +
                "petrolStation=" + petrolStation +
                ", totalAmount=" + totalAmount +
                ", taxExtraCharge=" + taxExtraCharge +
                ", petrolAmount=" + petrolAmount +
                ", petrolPrice=" + petrolPrice +
                '}';
    }
}
