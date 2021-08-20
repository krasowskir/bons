package com.example.bons.entity;

public enum TaxExtraCharge {

    VALUE_ADDED_TAX(19.00), KONSUM_TAX(7.00);

    private double percentage;

    private TaxExtraCharge(double percentage) {
        this.percentage = percentage;
    }
}
