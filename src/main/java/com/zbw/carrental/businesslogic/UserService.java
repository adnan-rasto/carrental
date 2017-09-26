package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

public class UserService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    final static Logger logger = Logger.getLogger(String.valueOf(UserService.class));

    // ======================================
    // =            Constructors            =
    // ======================================

    public UserService(){
        super();
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public EntityManager getEntityManager() {
        logger.info("Entering the method getEntityManager");
        return this.entityManager;
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public User createUser(String username, String password){
        logger.info("Entering the method createUser");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();

        return user;
    }

    public User createUser(User user){
        logger.info("Entering the method createUser");
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();

        return user;
    }

    public void removeUser(User user) {
        logger.info("Entering the method removeUser");
        entityTransaction.begin();
        entityManager.remove(entityManager.merge(user));
        entityTransaction.commit();
    }

    public User findUser(int id) {
        logger.info("Entering the method findUser");
        return entityManager.find(User.class, id);
    }

    public User updateUser(User user){
        logger.info("Entering the method updateUser");
        return entityManager.merge(user);
    }

    public void queryUser() {
        logger.info("Entering the method queryUser");

        List user = entityManager.createNamedQuery("testquery")
                .setParameter("testName", "Max")
                .getResultList();

        for (int i = 0; i < user.size(); i++)
        {
            User customer = (User) user.get(i);
            System.out.println(customer.toString());
        }
    }

}
