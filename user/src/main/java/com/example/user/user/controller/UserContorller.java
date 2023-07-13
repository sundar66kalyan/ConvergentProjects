package com.example.user.user.controller;

import com.example.user.user.dto.DepartmentDto;
import com.example.user.user.entity.User;
import com.example.user.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserContorller {
    @Autowired
    UserService userService;



    @PostMapping(value = "/adduser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping(value = "/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getallUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PutMapping(value = "/updatebyid/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping(value = "deletebyid/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }










}
