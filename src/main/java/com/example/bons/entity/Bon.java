package com.example.bons.entity;

import java.math.BigDecimal;

public class Bon {

    private long id;

    private PetrolStation petrolStation;

    private Payment payment;

    private TaxExtraCharge taxExtraCharge;

    private BigDecimal totalAmount;
    private BigDecimal bruttoPrice;
    private BigDecimal nettoPrice;
    private double petrolAmount;
    private float petrolPrice;

    public Bon() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetrolStation getPetrolStation() {
        return petrolStation;
    }

    public void setPetrolStation(PetrolStation petrolStation) {
        this.petrolStation = petrolStation;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public TaxExtraCharge getTaxExtraCharge() {
        return taxExtraCharge;
    }

    public void setTaxExtraCharge(TaxExtraCharge taxExtraCharge) {
        this.taxExtraCharge = taxExtraCharge;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(BigDecimal bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        this.nettoPrice = nettoPrice;
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
    public String toString() {
        return "Bon{" +
                "id=" + id +
                ", petrolStation=" + petrolStation +
                ", payment=" + payment +
                ", taxExtraCharge=" + taxExtraCharge +
                ", totalAmount=" + totalAmount +
                ", bruttoPrice=" + bruttoPrice +
                ", nettoPrice=" + nettoPrice +
                ", petrolAmount=" + petrolAmount +
                ", petrolPrice=" + petrolPrice +
                '}';
    }
}
