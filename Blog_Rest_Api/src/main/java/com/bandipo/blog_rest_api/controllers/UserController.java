package com.bandipo.blog_rest_api.controllers;

import com.bandipo.blog_rest_api.model.User;
import com.bandipo.blog_rest_api.services.UserService;
import com.bandipo.blog_rest_api.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
     @Autowired
     UserServiceImpl userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> registerUser(@Validated @RequestBody User user) {
        User user1 = userService.getUserByEmail(user.getEmail());
        if (user1 == null) {
            userService.addUser(user);
            return new ResponseEntity<>("User has been created", HttpStatus.OK);
        }
        return new ResponseEntity<>("Email Already exists" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(user.get(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }





}
