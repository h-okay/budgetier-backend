package com.hokay.budgetier.repositories;

import com.hokay.budgetier.models.Spending;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends MongoRepository<Spending, String> {

}
