package com.zbw.carrental.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "vehicle")
public class Fahrzeug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fahrzeugID;

    @Column(name = "brand", length = 50)
    private String marke;

    @Column(name = "model", length = 50)
    private String model;

    @Enumerated(EnumType.ORDINAL)
    private Fahrzeugklasse fahrzeugklasse;

    private BigDecimal tagesgebuehr;

    public Fahrzeug(){
        super();
    }

    public Fahrzeug(int fahrzeugID, String marke, String model, Fahrzeugklasse fahrzeugklasse, BigDecimal tagesgebuehr) {
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

    public Fahrzeugklasse getFahrzeugklasse() {
        return fahrzeugklasse;
    }

    public void setFahrzeugklasse(Fahrzeugklasse fahrzeugklasse) {
        this.fahrzeugklasse = fahrzeugklasse;
    }

    public BigDecimal getTagesgebuehr() {
        return tagesgebuehr;
    }

    public void setTagesgebuehr(BigDecimal tagesgebuehr) {
        this.tagesgebuehr = tagesgebuehr;
    }
}
