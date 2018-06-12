package com.atos;

import com.atos.model.Customer;
import com.atos.service.CustomerAccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class CustomerServiceTest {

    @Mock
    private CustomerAccountService customerAccountService;
    @Mock
    private List<Customer> customerList = new ArrayList<>();
    @Mock
    private Customer customer;

    @Mock
    private Customer customerOne;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(customerAccountService.getCustomer(Mockito.any())).thenReturn(customer);
        Mockito.when(customerAccountService.listAllCustomers()).thenReturn(customerList);
    }

    @Test

    public void testNullGetUserAccount() {
        customer = customerAccountService.getCustomer(customerOne);
        assertNotEquals(customerList, null);
    }

    @Test

    public void testInvalidGetUserAccount() {
        customer = customerAccountService.getCustomer(customerOne);
        assertNotEquals(customerList, new String("Test String"));
    }


    @Test

    public void testAddUserAccount() {
        customerAccountService.removeCustomer(customer);
        assertNotEquals(customerList, null);
    }

    @Test
    public void testDeleteUserAccount() {
        customerAccountService.removeCustomer(customer);
        assertNotEquals(customer, null);
    }




}
