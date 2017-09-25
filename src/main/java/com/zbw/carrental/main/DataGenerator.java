package com.zbw.carrental.main;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.businesslogic.OrderService;
import com.zbw.carrental.businesslogic.UserService;
import com.zbw.carrental.businesslogic.VehicleService;
import com.zbw.carrental.entities.Customer;
import com.zbw.carrental.entities.Order;
import com.zbw.carrental.entities.User;
import com.zbw.carrental.entities.Vehicle;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class DataGenerator {

    private CustomerService customerService = new CustomerService();
    private UserService userService = new UserService();
    private VehicleService vehicleService = new VehicleService();
    private OrderService orderService = new OrderService();
    final static Logger logger = Logger.getLogger(String.valueOf(DataGenerator.class));

    public DataGenerator(){
        super();
        logger.info("Entering the constructor of DataGenerator method");
        logger.warning("Test warning");
    }

    public void generateData(){
        generateUser();
        generateCustomer();
        generateVehicle();
        generateOrder();
    }

    public void generateCustomer(){

        Customer customer = customerService.createCustomer
                ("Hans", "Muster", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer1 = customerService.createCustomer
                ("Max", "Schirm", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer2 = customerService.createCustomer
                ("John", "Hertz", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer3 = customerService.createCustomer
                ("Peter", "Parker", "Teststrasse 10", 9500,"Wil");
        Customer customer4 = customerService.createCustomer
                ("John", "Wayne", "Teststrasse 10", 9200,"Gossau");
        Customer customer5 = customerService.createCustomer
                ("Max", "Pain", "Teststrasse 10", 9200,"Gossau");
    }

    public void generateUser(){
        User user = userService.createUser("admin", "12345");
        User user1 = userService.createUser("sachbearbeiter1", "11111");
        User user2 = userService.createUser("sachbearbeiter2", "222222");
    }

    public void generateVehicle() {

        Vehicle vehicle = vehicleService.CreateVehicle("VW", "Golf", "Luxus", new BigDecimal(150));
        Vehicle vehicle1 = vehicleService.CreateVehicle("Ferrari", "F-50", "Luxus", new BigDecimal(150));
        Vehicle vehicle2 = vehicleService.CreateVehicle("Ferrari", "F-40", "Luxus", new BigDecimal(150));
    }

    public void generateOrder(){

        Customer customer = customerService.findCustomer(101);
        Vehicle vehicle = vehicleService.findVehicle(4);

        Order order = new Order(vehicle, customer);

        orderService.createOrde(order);


    }
}
