package com.zbw.carrental.entities;

import java.math.BigDecimal;

public class Einfachklasse implements IFahrzeugklasse {

    private final BigDecimal dayPrice;
    private final String klasse;

    public Einfachklasse(){
        this.dayPrice = new BigDecimal("100");
        this.klasse = "Einfachklasse";
    }

    public BigDecimal getPricePerDay() {
        return this.dayPrice;
    }

    public String getKlasse(){
        return this.klasse;
    }
}
