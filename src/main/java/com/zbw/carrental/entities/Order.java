package com.zbw.carrental.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "carorder")
@XmlRootElement
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (fahrzeug != null ? !fahrzeug.equals(order.fahrzeug) : order.fahrzeug != null) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (pickUpDate != null ? !pickUpDate.equals(order.pickUpDate) : order.pickUpDate != null) return false;
        if (dropOfDate != null ? !dropOfDate.equals(order.dropOfDate) : order.dropOfDate != null) return false;
        return rentCost != null ? rentCost.equals(order.rentCost) : order.rentCost == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fahrzeug != null ? fahrzeug.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (pickUpDate != null ? pickUpDate.hashCode() : 0);
        result = 31 * result + (dropOfDate != null ? dropOfDate.hashCode() : 0);
        result = 31 * result + (rentCost != null ? rentCost.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fahrzeug=" + fahrzeug +
                ", customer=" + customer +
                ", pickUpDate=" + pickUpDate +
                ", dropOfDate=" + dropOfDate +
                ", rentCost=" + rentCost +
                '}';
    }
}



