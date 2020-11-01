package com.brunopique.assignment14.repository;

import com.brunopique.assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private Long id = 1L;
    private List<User> users = new ArrayList<>();

    public User saveUser(String name) {
        var user = new User();
        user.setName(name);
        user.setId(id++);
        users.add(user);
        return user;
    }
}
