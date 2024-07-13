package org.example.parkautoback.service;

import org.example.parkautoback.entity.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


@Service

public class CartesService {
    @Autowired
    private DataSource dataSource;
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public Carte getCarte(String carteId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM carte WHERE num_carte = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carteId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Carte(resultSet.getString("num_carte"), resultSet.getString("nbr_litres"));
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

    public ArrayList<Carte> getAllCartes() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM CARTE";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Carte> cartes = new ArrayList<>();
                    while (resultSet.next()) {

                        cartes.add(new Carte(resultSet.getString("num_carte"), resultSet.getString("nbr_litres")));
                    }
                    return cartes;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void addCarte(Carte carte) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO carte (num_carte, nbr_litres) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carte.getId());
                preparedStatement.setString(2, carte.getNb_litres());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCarte(Carte carte) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE carte SET nbr_litres = ? WHERE num_carte = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carte.getNb_litres());
                preparedStatement.setString(2, carte.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCarte(String carteId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM carte WHERE num_carte = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carteId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
