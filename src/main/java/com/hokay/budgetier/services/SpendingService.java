package com.hokay.budgetier.services;

import com.hokay.budgetier.models.Spending;
import com.hokay.budgetier.models.User;
import com.hokay.budgetier.repositories.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SpendingService {

    private final SpendingRepository spendingRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public SpendingService(
            SpendingRepository spendingRepository,
            MongoTemplate mongoTemplate) {
        this.spendingRepository = spendingRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Spending removeSpending(String id, String username) {
        Spending spending = spendingRepository.findById(id).orElseThrow();
        spendingRepository.deleteById(id);
        mongoTemplate.update(User.class)
                .matching(Criteria.where("username").is(username))
                .apply(new Update().pull("spendingIds", spending))
                .first();
        return spending;
    }

    public Spending createSpending(
            String date,
            String category,
            String sub_category,
            String description,
            String where,
            String currency,
            double amount,
            String username
    ) {
        Spending spending = new Spending(
                date,
                category,
                sub_category,
                description,
                where,
                currency,
                amount
        );
        spendingRepository.insert(spending);
        mongoTemplate.update(User.class)
                .matching(Criteria.where("username").is(username))
                .apply(new Update().push("spendingIds").value(spending))
                .first();
        return spending;
    }
}
