package com.zbw.carrental.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {

    private int orderID;
    private Fahrzeug fahrzeug;
    private Kunde kunde;
    private Timestamp pickUpDate;
    private Timestamp dropOfDate;
    private BigDecimal rentCost;

    public Order(){
        super();
    }

    public Order(Fahrzeug fahrzeug, Kunde kunde) {
        setFahrzeug(fahrzeug);
        setKunde(kunde);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug)
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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        if ( kunde == null )
        {
            throw new IllegalArgumentException("Kunde can't be null");
        }
        else
        {
            this.kunde = kunde;
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



