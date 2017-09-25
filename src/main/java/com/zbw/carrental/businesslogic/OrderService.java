package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.Customer;
import com.zbw.carrental.entities.Order;
import com.zbw.carrental.entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    // ======================================
    // =            Constructors            =
    // ======================================

    public OrderService(){
        super();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Order createOrde(Order order){
        entityTransaction.begin();
        entityManager.persist(order);
        entityTransaction.commit();

        return order;
    }

    public Order createOrder(Vehicle fahrzeug, Customer customer){
        Order order = new Order();
        order.setCustomer(customer);
        order.setFahrzeug(fahrzeug);

        entityTransaction.begin();
        entityManager.persist(order);
        entityTransaction.commit();

        return order;
    }

    public void removeOrder(Order order) {
        entityTransaction.begin();
        entityManager.remove(entityManager.merge(order));
        entityTransaction.commit();
    }

    public Order findOrder(int id) {
        return entityManager.
                find(Order.class, id);
    }

    public Order updateOrder(Order order){
        return entityManager.
                merge(order);
    }

}
