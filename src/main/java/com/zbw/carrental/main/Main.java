package com.zbw.carrental.main;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.entities.Customer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.generateCustomer();

        CustomerService customerService = new CustomerService();

        Customer customer = new Customer("Test", "teaete", "dafaf", 22, "dfadf");
        customerService.createCustomer(customer);

        Thread.sleep(3000);

        Customer customerDelete = customerService.findCustomer(1);

        customerService.removeCustomer(customerDelete);

    }
}
