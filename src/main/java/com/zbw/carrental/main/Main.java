package com.zbw.carrental.main;

import com.zbw.carrental.businesslogic.CustomerService;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        // DataGenerator dataGenerator = new DataGenerator();
        // dataGenerator.generateCustomer();

        CustomerService customerService = new CustomerService();

        // Customer customer = new Customer("abcdefg", "teaete", "dafaf", 22, "dfadf");
        // customerService.createCustomer(customer);

        Thread.sleep(3000);

        customerService.queryCustomers();

    }
}
