package com.zbw.carrental.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CarClassification {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    private int id;

    @Id
    @OneToOne(mappedBy = "carClassification")
    private Vehicle vehicle;

    @Column
    private String carClass;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CarClassification(){
        super();
    }

    public CarClassification(String carClass, BigDecimal price) {
        this.carClass = carClass;
        this.price = price;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
