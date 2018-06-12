package com.atos.dao;

import com.atos.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomer(Customer customer);

    Customer addCustomer(Customer custimer );

    boolean removeCustomer(Customer customer);

    List<Customer> listAllCustomers();

}


