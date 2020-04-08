package com.sachin.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    //fetchAllUser
    //GET /users
    @GetMapping("/users")
    public List<User> fetchAllUser(){
        return service.findAll();
    }

    //fetchUser
    //GET /users/{id}
    @GetMapping("/users/{id}")
    public User fetchUser(@PathVariable int id) {
        User user = service.findUser(id);
        if(user == null){
            throw new UserNotFoundException("ID="+id);
        }
        return user;
    }

    //addUser
    //POST /users
    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User saveUser = service.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
