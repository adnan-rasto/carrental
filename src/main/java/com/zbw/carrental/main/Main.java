package com.zbw.carrental.main;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.generateUser();
        dataGenerator.generateVehicle();
        // dataGenerator.generateCustomer();
        // dataGenerator.generateCustomer();
        // dataGenerator.generateCustomer();

        // UserService userService = new UserService();
        // Customer customer = new Customer("abcdefg", "teaete", "dafaf", 22, "dfadf");
        // customerService.createCustomer(customer);

    }
}
