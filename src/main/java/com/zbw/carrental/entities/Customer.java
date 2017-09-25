package com.zbw.carrental.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "testquery", query = "SELECT c FROM Customer c WHERE c.firstname < :testName"),
})
public class Customer implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    
    @Id
    @GeneratedValue
    private int id;

    @Id
    @OneToOne(mappedBy = "customer")
    private Order order;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 25)
    private String address;

    @Column
    private int zipcode;

    @Column
    private String city;
    
    // ======================================
    // =            Constructors            =
    // ======================================

    public Customer() {
        super();
    }

    public Customer(String firstname, String lastname, String address, int zipcode, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (zipcode != customer.zipcode) return false;
        if (order != null ? !order.equals(customer.order) : customer.order != null) return false;
        if (firstname != null ? !firstname.equals(customer.firstname) : customer.firstname != null) return false;
        if (lastname != null ? !lastname.equals(customer.lastname) : customer.lastname != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        return city != null ? city.equals(customer.city) : customer.city == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", order=" + order +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                ", city='" + city + '\'' +
                '}';
    }
}
