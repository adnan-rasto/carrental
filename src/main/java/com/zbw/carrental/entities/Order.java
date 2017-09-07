package com.zbw.carrental.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "caroder")
public class Order {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn
    private Vehicle fahrzeug;

    @OneToOne
    @JoinColumn
    private Customer customer;

    @Column
    private Timestamp pickUpDate;

    @Column
    private Timestamp dropOfDate;

    @Column(precision = 7, scale = 2)
    private BigDecimal rentCost;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Order(){
        super();
    }

    public Order(Vehicle fahrzeug, Customer customer) {
        setFahrzeug(fahrzeug);
        setCustomer(customer);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public int getOrderID() {
        return id;
    }

    public void setOrderID(int orderID) {
        this.id = orderID;
    }

    public Vehicle getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Vehicle fahrzeug)
    {
        if ( fahrzeug == null )
        {
            throw new IllegalArgumentException("Fahrzeug can't be null");
        }
        else
        {
            this.fahrzeug = fahrzeug;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if ( customer == null )
        {
            throw new IllegalArgumentException("Customer can't be null");
        }
        else
        {
            this.customer = customer;
        }
    }

    public Timestamp getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Timestamp pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Timestamp getDropOfDate() {
        return dropOfDate;
    }

    public void setDropOfDate(Timestamp dropOfDate) {
        this.dropOfDate = dropOfDate;
    }

    public BigDecimal getRentCost() {
        return rentCost;
    }

    public void setRentCost(BigDecimal rentCost) {
        this.rentCost = rentCost;
    }
}



