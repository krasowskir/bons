package com.example.bons.entity;

import java.sql.Date;
import java.util.Objects;

public class Payment {

    private long id;

    private PaymentMethod method;
    private Date datum;
    private String termId;
    private String proessNr;
    private String kontoNr;
    private String appId;

    private enum PaymentMethod {
        CREDITCARD, PAYPAL, SOFORTUEBERWEISUNG, INVOICE, DEBIT, RATE
    }

    public Payment() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getProessNr() {
        return proessNr;
    }

    public void setProessNr(String proessNr) {
        this.proessNr = proessNr;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(String kontoNr) {
        this.kontoNr = kontoNr;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) &&
                method == payment.method &&
                Objects.equals(datum, payment.datum) &&
                Objects.equals(termId, payment.termId) &&
                Objects.equals(proessNr, payment.proessNr) &&
                Objects.equals(kontoNr, payment.kontoNr) &&
                Objects.equals(appId, payment.appId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method, datum, termId, proessNr, kontoNr, appId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", method=" + method +
                ", datum=" + datum +
                ", termId='" + termId + '\'' +
                ", proessNr='" + proessNr + '\'' +
                ", kontoNr='" + kontoNr + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
