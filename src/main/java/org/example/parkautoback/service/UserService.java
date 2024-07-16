package org.example.parkautoback.service;

import org.example.parkautoback.entity.User;
import org.example.parkautoback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(String username, User user) {
        return userRepository.findById(username)
                .map(User -> {
                    User.setPassword(user.getPassword());
                    User.setRole(user.getRole());
                    return userRepository.save(User);
                });
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }




}
