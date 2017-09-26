package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.Customer;
import com.zbw.carrental.entities.Order;
import com.zbw.carrental.entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class OrderService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    final static Logger logger = Logger.getLogger(String.valueOf(OrderService.class));

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
        logger.info("Entering the method getEntityManager");
        return this.entityManager;
    }

    public Order createOrde(Order order){
        logger.info("Entering the method createOrder");
        entityTransaction.begin();
        entityManager.persist(order);
        entityTransaction.commit();

        return order;
    }

    public Order createOrder(Vehicle fahrzeug, Customer customer){
        logger.info("Entering the method createOrder");
        Order order = new Order();
        order.setCustomer(customer);
        order.setFahrzeug(fahrzeug);

        entityTransaction.begin();
        entityManager.persist(order);
        entityTransaction.commit();

        return order;
    }

    public void removeOrder(Order order) {
        logger.info("Entering the method removeOrder");
        entityTransaction.begin();
        entityManager.remove(entityManager.merge(order));
        entityTransaction.commit();
    }

    public Order findOrder(int id) {
        logger.info("Entering the method findOrder");
        return entityManager.
                find(Order.class, id);
    }

    public Order updateOrder(Order order){
        logger.info("Entering the method updateOrder");
        return entityManager.
                merge(order);
    }

}
