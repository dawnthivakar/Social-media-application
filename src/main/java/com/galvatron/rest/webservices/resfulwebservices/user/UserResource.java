package com.galvatron.rest.webservices.resfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = service.findUserById(id);
        if (user == null)
            throw new UserNotFoundException("id" + id);
        return user;
    }

    @GetMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return service.findUserByName(name);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User createdUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable int id) {
        service.removeUserById(id);
    }

    @DeleteMapping("/deleteUserByName/{name}")
    public void deleteUserByName(@PathVariable String name) {
        service.removeUserByName(name);
    }

}
