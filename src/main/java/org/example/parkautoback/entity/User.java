package org.example.parkautoback.entity;

import org.example.parkautoback.LoginRequest;
import org.example.parkautoback.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String username;
    private String password;

    @Autowired
    private DatabaseService databaseService;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(LoginRequest loginRequest) {
        return databaseService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
    }

    public String printAllUsers() {
        return databaseService.printAllUsers();
    }

    // Getters and setters (if needed)
}
