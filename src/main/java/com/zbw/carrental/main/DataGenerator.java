package com.zbw.carrental.main;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.entities.Customer;

public class DataGenerator {

    CustomerService customerService = new CustomerService();

    public DataGenerator(){
        super();
    }

    public void generateCustomer(){
        Customer customer = customerService.createCustomer("Hans", "Muster", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer1 = customerService.createCustomer("Max", "Schirm", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer2 = customerService.createCustomer("John", "Hertz", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer3 = customerService.createCustomer("Peter", "Parker", "Teststrasse 10", 9500,"Wil");
        Customer customer4 = customerService.createCustomer("John", "Wayne", "Teststrasse 10", 9200,"Gossau");
        Customer customer5 = customerService.createCustomer("Max", "Pain", "Teststrasse 10", 9200,"Gossau");

        /*
        System.out.println("Customer persisted: " + customer);
        System.out.println("Customer persisted: " + customer1);
        System.out.println("Customer persisted: " + customer2);
        System.out.println("Customer persisted: " + customer3);
        System.out.println("Customer persisted: " + customer4);
        System.out.println("Customer persisted: " + customer5);
        */
    }
}
