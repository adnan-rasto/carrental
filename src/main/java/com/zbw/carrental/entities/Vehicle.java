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
    private String brand;

    @Column(length = 50)
    private String model;

    @Id
    @OneToOne(mappedBy = "fahrzeug")
    private Order order;

    @OneToOne
    @JoinColumn
    private CarClassification carClassification;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal dailycharge;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Vehicle(){
        super();
    }

    public Vehicle(int id, String brand, String model, CarClassification carClassification, BigDecimal dailycharge) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String marke) {
        this.brand = marke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarClassification getFahrzeugklasse() {
        return carClassification;
    }

    public void setFahrzeugklasse(CarClassification fahrzeugklasse) {
        this.carClassification = fahrzeugklasse;
    }

    public BigDecimal getDailycharge() {
        return dailycharge;
    }

    public void setDailycharge(BigDecimal tagesgebuehr) {
        this.dailycharge = tagesgebuehr;
    }
}
