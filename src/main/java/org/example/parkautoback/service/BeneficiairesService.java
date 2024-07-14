package org.example.parkautoback.service;

import org.example.parkautoback.entity.Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiairesService {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Beneficiaire getBeneficiaire(String idb) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM beneficiaire WHERE idb = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idb);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Beneficiaire(
                                resultSet.getString("idb"),
                                resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("date_deb"),
                                resultSet.getString("date_fin")
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

    public List<Beneficiaire> getAllBeneficiaires() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM beneficiaire";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Beneficiaire> beneficiaires = new ArrayList<>();
                    while (resultSet.next()) {
                        beneficiaires.add(new Beneficiaire(
                                resultSet.getString("idb"),
                                resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("date_deb"),
                                resultSet.getString("date_fin")
                        ));
                    }
                    return beneficiaires;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addBeneficiaire(Beneficiaire beneficiaire) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO beneficiaire (idb, nom, prenom, date_deb, date_fin) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, beneficiaire.getIdb());
                preparedStatement.setString(2, beneficiaire.getNom());
                preparedStatement.setString(3, beneficiaire.getPrenom());
                preparedStatement.setString(4,beneficiaire.getDate_deb());
                preparedStatement.setString(5, beneficiaire.getDate_fin());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBeneficiaire(Beneficiaire beneficiaire) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE beneficiaire SET nom = ?, prenom = ?, date_deb = ?, date_fin = ? WHERE idb = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, beneficiaire.getNom());
                preparedStatement.setString(2, beneficiaire.getPrenom());
                preparedStatement.setString(4,beneficiaire.getDate_deb());
                preparedStatement.setString(5, beneficiaire.getDate_fin());
                preparedStatement.setString(5, beneficiaire.getIdb());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBeneficiaire(String idb) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM beneficiaire WHERE idb = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idb);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
