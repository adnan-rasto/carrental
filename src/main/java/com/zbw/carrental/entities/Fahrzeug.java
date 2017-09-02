package com.zbw.carrental.entities;

import java.math.BigDecimal;

public class Fahrzeug {

    private int fahrzeugID;
    private String marke;
    private String model;
    private IFahrzeugklasse fahrzeugklasse;
    private BigDecimal tagesgebuehr;

    public Fahrzeug(){
        super();
    }

    public Fahrzeug(int fahrzeugID, String marke, String model, IFahrzeugklasse fahrzeugklasse, BigDecimal tagesgebuehr) {
        this.fahrzeugID = fahrzeugID;
        this.marke = marke;
        this.model = model;
        this.fahrzeugklasse = fahrzeugklasse;
        this.tagesgebuehr = tagesgebuehr;
    }

    public int getFahrzeugID() {
        return fahrzeugID;
    }

    public void setFahrzeugID(int fahrzeugID) {
        this.fahrzeugID = fahrzeugID;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public IFahrzeugklasse getFahrzeugklasse() {
        return fahrzeugklasse;
    }

    public void setFahrzeugklasse(IFahrzeugklasse fahrzeugklasse) {
        this.fahrzeugklasse = fahrzeugklasse;
    }

    public BigDecimal getTagesgebuehr() {
        return tagesgebuehr;
    }

    public void setTagesgebuehr(BigDecimal tagesgebuehr) {
        this.tagesgebuehr = tagesgebuehr;
    }
}
