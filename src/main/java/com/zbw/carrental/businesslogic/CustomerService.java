package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    // ======================================
    // =            Constructors            =
    // ======================================

    public CustomerService(){
        super();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public Customer createCustomer(Customer customer){
        entityManager.persist(customer);
        return customer;
    }

    public Customer createCustomer(String firstname, String lastname, String address, int zipcode, String city){
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setZipcode(zipcode);
        customer.setCity(city);

        entityTransaction.begin();
        entityManager.persist(customer);
        entityTransaction.commit();

        return customer;
    }

    public void removeCustomer(Customer customer) {

        entityManager.remove(entityManager.merge(customer));
    }

    public Customer findCustomer(int id) {
        return entityManager.find(Customer.class, id);
    }
}