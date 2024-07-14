package org.example.parkautoback.service;

import org.example.parkautoback.entity.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContratService {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Contrat getContrat(String id_contrat) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM contrat WHERE id_contrat = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id_contrat);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Contrat(
                                resultSet.getString("id_contrat"),
                                resultSet.getString("immat"),
                                resultSet.getString("date_deb"),
                                resultSet.getString("date_fin"),
                                resultSet.getString("cout"),
                                resultSet.getString("type")
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

    public List<Contrat> getAllContrats() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM contrat";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Contrat> contrats = new ArrayList<>();
                    while (resultSet.next()) {
                        contrats.add(new Contrat(
                                resultSet.getString("id_contrat"),
                                resultSet.getString("immat"),
                                resultSet.getString("date_deb"),
                                resultSet.getString("date_fin"),
                                resultSet.getString("cout"),
                                resultSet.getString("type")
                        ));
                    }
                    return contrats;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addContrat(Contrat contrat) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO contrat (id_contrat, immat, date_deb, date_fin, cout, type) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, contrat.getId_contrat());
                preparedStatement.setString(2, contrat.getImmat());
                preparedStatement.setString(3, contrat.getDate_deb());
                preparedStatement.setString(4, contrat.getDate_fin());
                preparedStatement.setString(5, contrat.getCout());
                preparedStatement.setString(6, contrat.getType());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateContrat(Contrat contrat) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE contrat SET immat = ?, date_deb = ?, date_fin = ?, cout = ?, type = ? WHERE id_contrat = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, contrat.getImmat());
                preparedStatement.setString(2, contrat.getDate_deb());
                preparedStatement.setString(3, contrat.getDate_fin());
                preparedStatement.setString(4, contrat.getCout());
                preparedStatement.setString(5, contrat.getType());
                preparedStatement.setString(6, contrat.getId_contrat());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContrat(String id_contrat) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM contrat WHERE id_contrat = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id_contrat);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
