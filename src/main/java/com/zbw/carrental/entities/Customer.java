package com.zbw.carrental.entities;

import javax.persistence.*;

@Entity
public class Customer {

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

    public int getId() {
        return id;
    }

    public void setId(int kundenID) {
        this.id = kundenID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String vorname) {
        this.firstname = vorname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String nachname) {
        this.lastname = nachname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adresse) {
        this.address = adresse;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int postleitzahl) {
        this.zipcode = postleitzahl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String wohnort) {
        this.city = wohnort;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Customer{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", firstname=").append(firstname).append('\'');
        stringBuilder.append(", lastname=").append(lastname).append('\'');
        stringBuilder.append(", address=").append(address).append('\'');
        stringBuilder.append(", zipcode=").append(zipcode).append('\'');
        stringBuilder.append(", city=").append(city);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
