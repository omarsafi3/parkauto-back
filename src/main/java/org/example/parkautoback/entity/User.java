package org.example.parkautoback.entity;

import org.example.parkautoback.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String username;
    private String password;
    private String role;

    @Autowired
    private AuthService authService;

    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String authenticate(User user) {
        return authService.authenticate(user.getUsername(), user.getPassword());
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }

    // Getters and setters (if needed)
}
