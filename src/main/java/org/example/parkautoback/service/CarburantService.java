package org.example.parkautoback.service;

import org.example.parkautoback.entity.Carburant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


@Service
public class CarburantService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Carburant getCarburant(String carburantId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM carburant WHERE idc = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carburantId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Carburant(resultSet.getString("idc"), resultSet.getString("lib"), resultSet.getString("prix_litre"));
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

    public ArrayList<Carburant> getAllCarburants() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM CARBURANT";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Carburant> carburants = new ArrayList<>();
                    while (resultSet.next()) {
                        carburants.add(new Carburant(resultSet.getString("idc"), resultSet.getString("lib"), resultSet.getString("prix_litre")));
                    }
                    return carburants;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addCarburant(Carburant carburant) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO carburant (idc, lib, prix_litre) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carburant.getIdc());
                preparedStatement.setString(2, carburant.getLib());
                preparedStatement.setString(3, carburant.getPrix_litre());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCarburant(Carburant carburant) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE carburant SET lib = ?, prix_litre = ? WHERE idc = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carburant.getLib());
                preparedStatement.setString(2, carburant.getPrix_litre());
                preparedStatement.setString(3, carburant.getIdc());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCarburant(String carburantId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM carburant WHERE idc = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, carburantId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
