package com.galvatron.rest.webservices.resfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserResource {
    private UserDao service;

    public UserResource(UserDao service) {
        this.service = service;
    }
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return service.getAllUsers();
    }
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return service.findUserById(id);
    }

    @GetMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return service.findUserByName(name);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }
}
