package com.zbw.carrental.businesslogic;

import com.zbw.carrental.entities.User;
import com.zbw.carrental.entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

public class VehicleService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carrental");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    final static Logger logger = Logger.getLogger(String.valueOf(VehicleService.class));

    // ======================================
    // =            Constructors            =
    // ======================================

    public VehicleService(){
        super();
        logger.info("Entering the default constructor");
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

    public Vehicle createVehicle(java.lang.String brand, java.lang.String model, String carClassification, BigDecimal dailycharge){
        logger.info("Entering the method createVehicle");
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setFahrzeugklasse(carClassification);
        vehicle.setDailycharge(dailycharge);

        entityTransaction.begin();
        entityManager.persist(vehicle);
        entityTransaction.commit();

        return vehicle;
    }

    public Vehicle createVehicle(Vehicle vehicle){
        logger.info("Entering the method createVehicle");
        entityTransaction.begin();
        entityManager.persist(vehicle);
        entityTransaction.commit();

        return vehicle;
    }

    public void removeVehicle(Vehicle vehicle) {
        logger.info("Entering the method removeVehicle");
        entityTransaction.begin();
        entityManager.remove(entityManager.merge(vehicle));
        entityTransaction.commit();
    }

    public Vehicle findVehicle(int id) {
        logger.info("Entering the method findVehicle");
        return entityManager.find(Vehicle.class, id);
    }

    public Vehicle updateVehicle(Vehicle vehicle){
        logger.info("Entering the method updateVehicle");
        return entityManager.merge(vehicle);
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
