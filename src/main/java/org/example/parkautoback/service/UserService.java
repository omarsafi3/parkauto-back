package org.example.parkautoback.service;

import org.example.parkautoback.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private DataSource dataSource;

    public UserService() {
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utilisateurs");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                users.add(new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public User getUser(String username) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utilisateurs WHERE username = ?")) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("role"));
                } else {
                    System.out.println("User not found");
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUser(User user) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utilisateurs (username, password, role) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE utilisateurs SET password = ?, role = ? WHERE username = ?")) {
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM utilisateurs WHERE username = ?")) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
