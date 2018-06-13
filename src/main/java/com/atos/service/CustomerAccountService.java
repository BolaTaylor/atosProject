package com.atos.service;

import com.atos.dao.CustomerDao;
import com.atos.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAccountService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerAccountService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer getCustomer(Customer customer){
        return customerDao.getCustomer(customer);
    }
    public Customer addAccounts(Customer customer){
       return customerDao.addCustomer(customer);
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
