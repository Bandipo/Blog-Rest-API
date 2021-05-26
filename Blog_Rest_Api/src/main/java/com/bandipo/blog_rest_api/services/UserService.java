package com.bandipo.blog_rest_api.services;

import com.bandipo.blog_rest_api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public User addUser(User user);

    User getUserByEmail(String email);

    List<User> findAll();


    Optional<User> getUserById(Long id);
}
