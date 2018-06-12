package com.atos.dao;

import com.atos.model.Customer;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerDaoImpl implements CustomerDao{

    final static private Random RANDOM = new SecureRandom();
    private List<Customer> customerList = new ArrayList<>();
    private Customer customer  = new Customer();
    private Customer customerOne = new Customer();
    private Customer customerTwo = new Customer();
    private Customer customerThree = new Customer();


    public CustomerDaoImpl() {
        if (!checkForCustomer(customer)) {
            customer.setId("ATOS_1");
            customer.setFirstName("John");
            customer.setSurname("Taylor");
            customerList.add(customer);
        }
        if (!checkForCustomer(customerOne)) {
            customerOne.setId("ATOS_2");
            customerOne.setFirstName("Mary");
            customerOne.setSurname("Williams");
            customerList.add(customerOne);
        }

        if (!checkForCustomer(customerTwo)) {
            customerTwo.setId("ATOS_3");
            customerTwo.setFirstName("Fred");
            customerTwo.setSurname("Peterson");
        }
        if (!checkForCustomer(customerThree)) {
            customerThree.setId("ATOS_4");
            customerThree.setFirstName("Peter");
            customerThree.setSurname("Bauer");
            customerList.add(customerThree);
        }
    }


    private boolean checkForCustomer(Customer customer){

        for(Customer customerObject: customerList){
            if(customerObject.getId() == customer.getId()){
                return true;
            }
        }
        return false;
    }
    @Override
    public Customer getCustomer(Customer customer) {
        if(customerList.contains(customer))
            return customer;
        else
            return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId().trim().isEmpty()) {
            customer.setId(generateRandomId());
        }
        customerList.add(customer);
        return customer;
    }


    @Override
    public boolean removeCustomer(Customer customer) {
        for(Customer customerObject: customerList){
            if(customerObject.getId().equalsIgnoreCase(customer.getId())){
                customerList.remove(customer);
                return true;
                }
        }
        return false;
    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerList;
    }

    private static String generateRandomId() {
        return "ATOS-"  + String.format("%04d", RANDOM.nextInt(1234567));
    }
}
