package org.example.parkautoback.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.*;

@Configuration
public class DatabaseConfig {

    @Bean
    public static Connection connection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
           System.out.println("Connection failed");

        }

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "parkauto";
        String password = "0000";

        return DriverManager.getConnection(url, username, password);
    }
}
