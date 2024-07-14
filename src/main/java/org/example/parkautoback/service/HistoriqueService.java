package org.example.parkautoback.service;

import org.example.parkautoback.entity.Historique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service
public class HistoriqueService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Historique getHistorique(String historiqueId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM historique WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, historiqueId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Historique(
                                resultSet.getString("id"),
                                resultSet.getString("h_date"),
                                resultSet.getString("idb"),
                                resultSet.getString("immat")
                        );
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

    public ArrayList<Historique> getAllHistoriques() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM historique";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Historique> historiques = new ArrayList<>();
                    while (resultSet.next()) {
                        historiques.add(new Historique(
                                resultSet.getString("id"),
                                resultSet.getString("h_date"),
                                resultSet.getString("idb"),
                                resultSet.getString("immat")
                        ));
                    }
                    return historiques;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addHistorique(Historique historique) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO historique (id, h_date, idb, immat) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, historique.getId());
                preparedStatement.setString(2, historique.getH_date());
                preparedStatement.setString(3, historique.getIdb());
                preparedStatement.setString(4, historique.getImmat());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHistorique(Historique historique) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE historique SET h_date = ?, idb = ?, immat = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, historique.getH_date());
                preparedStatement.setString(2, historique.getIdb());
                preparedStatement.setString(3, historique.getImmat());
                preparedStatement.setString(4, historique.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHistorique(String historiqueId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM historique WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, historiqueId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
