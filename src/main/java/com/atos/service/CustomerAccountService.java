package com.atos.service;

import com.atos.model.Customer;
import com.atos.dao.CustomerDao;

import java.util.List;

public class CustomerAccountService {

    private CustomerDao customerDao;

    public Customer getCustomer(Customer customer){
        return customerDao.getCustomer(customer);
    }
    public void addAccounts(Customer customer){
        customerDao.addCustomer(customer);
    }

    public void removeCustomer(Customer customer){
        customerDao.removeCustomer(customer);

    }

    public List<Customer> listAllCustomers(){
        return customerDao.listAllCustomers();
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
