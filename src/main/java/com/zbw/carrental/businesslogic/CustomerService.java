package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

public class CustomerService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    final static Logger logger = Logger.getLogger(String.valueOf(CustomerService.class));

    // ======================================
    // =            Constructors            =
    // ======================================

    public CustomerService(){
        super();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public EntityManager getEntityManager() {
        logger.info("Entering the method getEntityManager");
        return entityManager;
    }


    public Customer createCustomer(Customer customer){
        logger.info("Entering the method createCustomer");
        entityTransaction.begin();
        entityManager.persist(customer);
        entityTransaction.commit();

        return customer;
    }

    public Customer createCustomer(String firstname, String lastname, String address, int zipcode, String city){
        logger.info("Entering the method createCustomer");
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
        logger.info("Entering the method removeCustomer");
        entityTransaction.begin();
        entityManager.remove(entityManager.merge(customer));
        entityTransaction.commit();
    }

    public Customer findCustomer(int id) {
        logger.info("Entering the method findCustomer");
        return entityManager.
                find(Customer.class, id);
    }

    public Customer updateCustomer(Customer customer){
        logger.info("Entering the method updateCustomer");
        return entityManager.merge(customer);
    }

    public void queryCustomers() {
        logger.info("Entering the method queryCustomers");
        List customers = entityManager.createNamedQuery("testquery")
                .setParameter("testName", "Max")
                .getResultList();

        for (int i = 0; i < customers.size(); i++)
        {
            Customer customer = (Customer) customers.get(i);
            System.out.println(customer.toString());
        }
    }
}
