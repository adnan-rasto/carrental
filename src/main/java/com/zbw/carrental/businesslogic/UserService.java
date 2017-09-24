package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UserService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    // ======================================
    // =            Constructors            =
    // ======================================

    public UserService(){
        super();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public EntityManager getEntityManager() {
        return entityManager;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public User createUser(User user){
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();

        return user;
    }

    public void removeUser(User user) {
        entityTransaction.begin();
        entityManager.remove(entityManager.merge(user));
        entityTransaction.commit();
    }

    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }

    public User updateUser(User user){
        return entityManager.merge(user);
    }

    public void queryUser() {

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
