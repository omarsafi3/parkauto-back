package org.example.parkautoback.service;

import org.example.parkautoback.entity.Fonction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;

@Service
public class FonctionService {
    @Autowired
    private DataSource dataSource;

    public FonctionService() {
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public ArrayList<Fonction> getAllFonctions() {
        ArrayList<Fonction> fonctions = new ArrayList<>();
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM fonction");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                fonctions.add(new Fonction(resultSet.getString("code"), resultSet.getString("lib"), resultSet.getString("part_pre"), resultSet.getString("part_post")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fonctions;
    }

    public Fonction getFonction(String fonctionCode) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM fonction WHERE code = ?")) {

            preparedStatement.setString(1, fonctionCode);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Fonction(resultSet.getString("code"), resultSet.getString("lib"), resultSet.getString("part_pre"), resultSet.getString("part_post"));
                } else {
                    System.out.println("Fonction not found");
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addFonction(Fonction fonction) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO fonction (code, lib, part_pre, part_post) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, fonction.getCode());
            preparedStatement.setString(2, fonction.getLib());
            preparedStatement.setString(3, fonction.getPart_pre());
            preparedStatement.setString(4, fonction.getPart_post());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFonction(Fonction fonction) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE fonction SET lib = ?, part_pre = ?, part_post = ? WHERE code = ?")) {

            preparedStatement.setString(1, fonction.getLib());
            preparedStatement.setString(2, fonction.getPart_pre());
            preparedStatement.setString(3, fonction.getPart_post());
            preparedStatement.setString(4, fonction.getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFonction(String fonctionCode) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM fonction WHERE code = ?")) {

            preparedStatement.setString(1, fonctionCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
