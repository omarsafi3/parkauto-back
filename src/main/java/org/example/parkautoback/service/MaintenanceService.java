package org.example.parkautoback.service;

import org.example.parkautoback.entity.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Maintenance getMaintenance(String id) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM maintenance WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Maintenance(
                                resultSet.getString("id"),
                                resultSet.getString("type"),
                                resultSet.getString("description"),
                                resultSet.getString("cout"),
                                resultSet.getString("m_date"),
                                resultSet.getString("garage")
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

    public List<Maintenance> getAllMaintenance() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM maintenance";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Maintenance> maintenances = new ArrayList<>();
                    while (resultSet.next()) {
                        maintenances.add(new Maintenance(
                                resultSet.getString("id"),
                                resultSet.getString("type"),
                                resultSet.getString("description"),
                                resultSet.getString("cout"),
                                resultSet.getString("m_date"),
                                resultSet.getString("garage")
                        ));
                    }
                    return maintenances;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addMaintenance(Maintenance maintenance) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO maintenance (id, type, description, cout, m_date, garage) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, maintenance.getId());
                preparedStatement.setString(2, maintenance.getType());
                preparedStatement.setString(3, maintenance.getDescription());
                preparedStatement.setString(4, maintenance.getCout());
                preparedStatement.setString(5, maintenance.getM_date());
                preparedStatement.setString(6, maintenance.getGarage());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMaintenance(Maintenance maintenance) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE maintenance SET type = ?, description = ?, cout = ?, m_date = ?, garage = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, maintenance.getType());
                preparedStatement.setString(2, maintenance.getDescription());
                preparedStatement.setString(3, maintenance.getCout());
                preparedStatement.setString(4, maintenance.getM_date());
                preparedStatement.setString(5, maintenance.getGarage());
                preparedStatement.setString(6, maintenance.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMaintenance(String id) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM maintenance WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
