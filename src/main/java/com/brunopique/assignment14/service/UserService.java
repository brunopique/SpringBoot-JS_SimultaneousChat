package com.brunopique.assignment14.service;

import com.brunopique.assignment14.domain.User;
import com.brunopique.assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(String name) {
        return userRepository.saveUser(name);
    }

}
