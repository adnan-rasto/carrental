package com.zbw.carrental.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Vehicle {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50)
    private java.lang.String brand;

    @Column(length = 50)
    private java.lang.String model;

    @Id
    @OneToOne(mappedBy = "fahrzeug")
    private Order order;

    @Column
    private String carClassification;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal dailycharge;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Vehicle(){
        super();
    }

    public Vehicle(java.lang.String brand, java.lang.String model, String carClassification, BigDecimal dailycharge) {
        this.brand = brand;
        this.model = model;
        this.carClassification = carClassification;
        this.dailycharge = dailycharge;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public int getId() {
        return id;
    }

    public void setId(int fahrzeugID) {
        this.id = fahrzeugID;
    }

    public java.lang.String getBrand() {
        return brand;
    }

    public void setBrand(java.lang.String marke) {
        this.brand = marke;
    }

    public java.lang.String getModel() {
        return model;
    }

    public void setModel(java.lang.String model) {
        this.model = model;
    }

    public String getFahrzeugklasse() {
        return carClassification;
    }

    public void setFahrzeugklasse(String fahrzeugklasse) {
        this.carClassification = fahrzeugklasse;
    }

    public BigDecimal getDailycharge() {
        return dailycharge;
    }

    public void setDailycharge(BigDecimal tagesgebuehr) {
        this.dailycharge = tagesgebuehr;
    }
}
