package com.hokay.budgetier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BudgetierApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetierApplication.class, args);
    }

}



