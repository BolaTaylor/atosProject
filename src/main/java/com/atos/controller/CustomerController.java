package com.atos.controller;

import com.atos.model.Customer;
import com.atos.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final CustomerAccountService customerAccountService ;

    public CustomerController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomer(){
        return Response.ok(customerAccountService.listAllCustomers()).build();
      }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserAccount(@Valid Customer customer){
        customerAccountService.addAccounts(customer);
        return Response.ok("Customer has been successfully added").build();
    }


    @RequestMapping(path = "/remove", method = RequestMethod.DELETE)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCustomerAccount(@Valid Customer customer){
        customerAccountService.removeCustomer(customer);
        return Response.ok("account has been successfully deleted").build();
    }

}