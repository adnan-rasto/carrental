package com.zbw.carrental.Main;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.entities.Customer;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        //creates and persists a customer
        Customer customer = customerService.createCustomer("Hans", "Muster", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer1 = customerService.createCustomer("Max", "Schirm", "Teststrasse 10", 9000,"St. Gallen");
        Customer customer2 = customerService.createCustomer("John", "Hertz", "Teststrasse 10", 9000,"St. Gallen");


        System.out.println("Customer persisted: " + customer);
        System.out.println("Customer persisted: " + customer1);
        System.out.println("Customer persisted: " + customer2);


    }
}
