package org.example.parkautoback.service;

import org.example.parkautoback.entity.Assurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Create operation
    public boolean createAssurance(Assurance assurance) {
        String query = "INSERT INTO assurance (id, lib) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, assurance.getId());
            preparedStatement.setString(2, assurance.getLib());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read operation: Retrieve all assurances
    public List<Assurance> getAllAssurances() {
        String query = "SELECT id, lib FROM assurance";
        List<Assurance> assurances = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Assurance assurance = new Assurance();
                assurance.setId(resultSet.getString("id"));
                assurance.setLib(resultSet.getString("lib"));
                assurances.add(assurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assurances;
    }

    // Read operation: Retrieve assurance by ID
    public Assurance getAssuranceById(String id) {
        String query = "SELECT id, lib FROM assurance WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Assurance assurance = new Assurance();
                    assurance.setId(resultSet.getString("id"));
                    assurance.setLib(resultSet.getString("lib"));
                    return assurance;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update operation
    public boolean updateAssurance(Assurance assurance) {
        String query = "UPDATE assurance SET lib = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, assurance.getLib());
            preparedStatement.setString(2, assurance.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete operation
    public boolean deleteAssurance(String id) {
        String query = "DELETE FROM assurance WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
