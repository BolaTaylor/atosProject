package com.atos.main;

import com.atos.dao.CustomerDao;
import com.atos.dao.CustomerDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CustomerAccountApplication {


    @Bean
    protected CustomerDao customerDao() {
        return new CustomerDaoImpl();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CustomerAccountApplication.class, args);
    }


}