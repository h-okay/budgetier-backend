package com.hokay.budgetier.services;

import com.hokay.budgetier.models.Spending;
import com.hokay.budgetier.repositories.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendingService {

    private final SpendingRepository spendingRepository;

    @Autowired
    public SpendingService(SpendingRepository spendingRepository) {
        this.spendingRepository = spendingRepository;
    }

    public List<Spending> allSpendings() {
        return spendingRepository.findAll();
    }
}
