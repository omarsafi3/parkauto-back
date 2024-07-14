package org.example.parkautoback.service;

import org.example.parkautoback.entity.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service

public class VoitureService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Voiture getVoiture(String immat) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM voiture WHERE immat = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, immat);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Voiture(resultSet.getString("immat"), resultSet.getString("type"), resultSet.getString("fonction"), resultSet.getString("age"), resultSet.getString("mise_en_route"), resultSet.getString("puissance"), resultSet.getString("carburant"), resultSet.getString("prix"), resultSet.getString("gps"));
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Voiture> getAllVoitures() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM VOITURE";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Voiture> voitures = new ArrayList<>();
                    while (resultSet.next()) {
                        voitures.add(new Voiture(resultSet.getString("immat"), resultSet.getString("type"), resultSet.getString("fonction"), resultSet.getString("age"), resultSet.getString("mise_en_route"), resultSet.getString("puissance"), resultSet.getString("carburant"), resultSet.getString("prix"), resultSet.getString("gps")));
                    }
                    return voitures;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addVoiture(Voiture voiture) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO voiture (immat, type, fonction, age, mise_en_route, puissance, carburant, prix, gps) VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, voiture.getImmat());
                preparedStatement.setString(2, voiture.getType());
                preparedStatement.setString(3, voiture.getFonction());
                preparedStatement.setString(4, voiture.getAge());
                preparedStatement.setString(5, voiture.getMise_en_route());
                preparedStatement.setString(6, voiture.getPuissance());
                preparedStatement.setString(7, voiture.getCarburant());
                preparedStatement.setString(8, voiture.getPrix());
                preparedStatement.setString(9, voiture.getGps());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVoiture(Voiture voiture) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE voiture SET type = ?, fonction = ?, age = ?, mise_en_route = TO_DATE(?, 'YYYY-MM-DD'), puissance = ?, carburant = ?, prix = ?, gps = ? WHERE immat = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, voiture.getType());
                preparedStatement.setString(2, voiture.getFonction());
                preparedStatement.setString(3, voiture.getAge());
                preparedStatement.setString(4, voiture.getMise_en_route());
                preparedStatement.setString(5, voiture.getPuissance());
                preparedStatement.setString(6, voiture.getCarburant());
                preparedStatement.setString(7, voiture.getPrix());
                preparedStatement.setString(8, voiture.getGps());
                preparedStatement.setString(9, voiture.getImmat());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVoiture(String immat) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM voiture WHERE immat = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, immat);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
