package com.zbw.carrental.entities;

import java.math.BigDecimal;

public class Mittelklasse implements IFahrzeugklasse {

    private final BigDecimal dayPrice;
    private final String klasse;

    public Mittelklasse(){
        this.dayPrice = new BigDecimal("125");
        this.klasse = "Mittelklasse";
    }

    public BigDecimal getPricePerDay() {
        return this.dayPrice;
    }

    public String getKlasse(){
        return this.klasse;
    }
}
