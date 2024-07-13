package org.example.parkautoback.entity;

import org.example.parkautoback.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String username;
    private String password;

    @Autowired
    private AuthService authService;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String authenticate(User user) {
        return authService.authenticate(user.getUsername(), user.getPassword());
    }

    public String printAllUsers() {
        return authService.printAllUsers();
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    // Getters and setters (if needed)
}
