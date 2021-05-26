package com.bandipo.blog_rest_api.services.impl;

import com.bandipo.blog_rest_api.model.User;
import com.bandipo.blog_rest_api.repositories.UserRepository;
import com.bandipo.blog_rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> userbyIdOptional = userRepository.findById(id);
        return userbyIdOptional;
    }
}
