package org.example.parkautoback;

import org.example.parkautoback.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private User user;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Login request received");
        return user.authenticate(loginRequest) ? "Login successful" : "Login failed";
    }
}
