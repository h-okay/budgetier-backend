package com.hokay.budgetier.services;

import com.hokay.budgetier.models.User;
import com.hokay.budgetier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public Optional<User> singleUser(String username) {
        return userRepository.findUserByUsername(username);
    }
}
