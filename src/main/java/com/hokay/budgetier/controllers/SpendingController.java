package com.hokay.budgetier.controllers;

import com.hokay.budgetier.models.Spending;
import com.hokay.budgetier.services.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spendings")
public class SpendingController {

    private final SpendingService spendingService;

    @Autowired
    public SpendingController(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @GetMapping
    public ResponseEntity<List<Spending>> allSpendings() {
        return new ResponseEntity<List<Spending>>(spendingService.allSpendings(), HttpStatus.OK);
    }

}
