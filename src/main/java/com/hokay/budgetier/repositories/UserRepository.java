package com.hokay.budgetier.repositories;

import com.hokay.budgetier.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}