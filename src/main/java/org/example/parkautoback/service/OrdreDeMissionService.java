package org.example.parkautoback.service;

import org.example.parkautoback.entity.OrdreDeMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service
public class OrdreDeMissionService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public OrdreDeMission getOrdreDeMission(String ordreDeMissionId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM ordre_de_mission WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, ordreDeMissionId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new OrdreDeMission(
                                resultSet.getString("id"),
                                resultSet.getString("objectif"),
                                resultSet.getString("date_dep"),
                                resultSet.getString("date_fin"),
                                resultSet.getString("trajet"),
                                resultSet.getString("courrier"),
                                resultSet.getString("accompagnant")
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

    public ArrayList<OrdreDeMission> getAllOrdresDeMission() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM ordre_de_mission";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<OrdreDeMission> ordresDeMission = new ArrayList<>();
                    while (resultSet.next()) {
                        ordresDeMission.add(new OrdreDeMission(
                                resultSet.getString("id"),
                                resultSet.getString("objectif"),
                                resultSet.getString("date_dep"),
                                resultSet.getString("date_fin"),
                                resultSet.getString("trajet"),
                                resultSet.getString("courrier"),
                                resultSet.getString("accompagnant")
                        ));
                    }
                    return ordresDeMission;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addOrdreDeMission(OrdreDeMission ordreDeMission) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO ordre_de_mission (id, objectif, date_dep, date_fin, trajet, courrier, accompagnant) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, ordreDeMission.getId());
                preparedStatement.setString(2, ordreDeMission.getObjectif());
                preparedStatement.setString(3, ordreDeMission.getDate_dep());
                preparedStatement.setString(4, ordreDeMission.getDate_fin());
                preparedStatement.setString(5, ordreDeMission.getTrajet());
                preparedStatement.setString(6, ordreDeMission.getCourrier());
                preparedStatement.setString(7, ordreDeMission.getAccompagnant());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrdreDeMission(OrdreDeMission ordreDeMission) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE ordre_de_mission SET objectif = ?, date_dep = ?, date_fin = ?, trajet = ?, courrier = ?, accompagnant = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, ordreDeMission.getObjectif());
                preparedStatement.setString(2, ordreDeMission.getDate_dep());
                preparedStatement.setString(3, ordreDeMission.getDate_fin());
                preparedStatement.setString(4, ordreDeMission.getTrajet());
                preparedStatement.setString(5, ordreDeMission.getCourrier());
                preparedStatement.setString(6, ordreDeMission.getAccompagnant());
                preparedStatement.setString(7, ordreDeMission.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrdreDeMission(String ordreDeMissionId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM ordre_de_mission WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, ordreDeMissionId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
