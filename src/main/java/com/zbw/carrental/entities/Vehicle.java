package com.zbw.carrental.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Entity
@XmlRootElement
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

    public Vehicle(String brand, String model, String carClassification, BigDecimal dailycharge) {
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", order=" + order +
                ", carClassification='" + carClassification + '\'' +
                ", dailycharge=" + dailycharge +
                '}';
    }
}
