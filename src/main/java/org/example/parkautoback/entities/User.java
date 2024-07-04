package org.example.parkautoback.entities;

import org.example.parkautoback.LoginRequest;
import org.example.parkautoback.config.DatabaseConfig;

import java.sql.*;

public class User {
    public static Connection con;

    static {
        try {
            con = DatabaseConfig.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public LoginRequest getUser(String username, String password) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LoginRequest(rs.getString("username"), rs.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
