package org.example.parkautoback.controller;

import org.example.parkautoback.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.parkautoback.DTO.LoginRequestDTO;


import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private User user;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequestDTO loginRequest) {
        User tempUser = new User(loginRequest.getUsername(), loginRequest.getPassword());
        if (user.authenticate(tempUser)) {
            return true;
        } else {
            return false;
        }
    }
}
