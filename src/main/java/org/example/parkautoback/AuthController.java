package org.example.parkautoback;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Replace with your authentication logic
        System.out.println("Login request received");
        System.out.println("Username: " + loginRequest.getUsername());
        System.out.println("Password: " + loginRequest.getPassword());
        return ResponseEntity.ok(Map.of("message", "Login successful"));
    }
}
