package com.atos.resource;

import com.atos.dao.CustomerDao;
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

    private final CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomer(){
        CustomerAccountService customerAccountService = new CustomerAccountService();
        return Response.ok(customerAccountService.listAllCustomers()).build();
      }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserAccount(@Valid Customer customer){
        CustomerAccountService customerAccountService = new CustomerAccountService();
        customerAccountService.addAccounts(customer);
        return Response.ok("Customer has been successfully added").build();
    }


    @RequestMapping(path = "/remove", method = RequestMethod.DELETE)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCustomerAccount(@Valid Customer customer){
        CustomerAccountService customerAccountService = new CustomerAccountService();
        customerAccountService.removeCustomer(customer);
        return Response.ok("account has been successfully deleted").build();
    }

}