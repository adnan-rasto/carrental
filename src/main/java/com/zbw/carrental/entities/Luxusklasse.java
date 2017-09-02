package com.zbw.carrental.entities;

import java.math.BigDecimal;

public class Luxusklasse implements IFahrzeugklasse {

    private final BigDecimal dayPrice;
    private final String klasse;

    public Luxusklasse(){
        this.dayPrice = new BigDecimal("150");
        this.klasse = "Luxusklasse";
    }

    public BigDecimal getPricePerDay() {
        return this.dayPrice;
    }

    public String getKlasse(){
        return this.klasse;
    }
}
