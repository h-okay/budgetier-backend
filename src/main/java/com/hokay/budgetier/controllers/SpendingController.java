package com.hokay.budgetier.controllers;

import com.hokay.budgetier.models.Spending;
import com.hokay.budgetier.services.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/spendings")
public class SpendingController {

    private final SpendingService spendingService;

    @Autowired
    public SpendingController(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @PostMapping
    public ResponseEntity<Spending> createSpending(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Spending>(spendingService.createSpending(
                payload.get("date"),
                payload.get("category"),
                payload.get("sub_category"),
                payload.get("description"),
                payload.get("where"),
                payload.get("currency"),
                Double.parseDouble(payload.get("amount")),
                payload.get("username")), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Spending> deleteSpending(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Spending>(spendingService.removeSpending(
                payload.get("id"),
                payload.get("username")), HttpStatus.ACCEPTED);
    }

}
