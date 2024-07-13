package org.example.parkautoback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DatabaseService {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public String printAllUsers() {
        try (Connection connection = getConnection()) {

            String query = "SELECT * FROM utilisateurs";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (resultSet.next()) {
                        stringBuilder.append(resultSet.getString("username")).append("\n");
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String authenticate(String username, String password) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM utilisateurs WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()){
                    return resultSet.getString("role");}
                    else{
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
