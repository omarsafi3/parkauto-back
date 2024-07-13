package org.example.parkautoback.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.example.parkautoback.entity.Assurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceService {
    @Autowired
    private DataSource dataSource;

    public AssuranceService() {
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public Assurance getAssurance(String assuranceId) {
        String query = "SELECT * FROM assurance WHERE assurance_id = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, assuranceId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Assurance(resultSet.getString("assurance_id"), resultSet.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Assurance> getAllAssurances() {
        String query = "SELECT * FROM assurance";
        ArrayList<Assurance> assurances = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Assurance assurance = new Assurance(resultSet.getString("assurance_id"), resultSet.getString("description"));
                assurances.add(assurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assurances;
    }

    public void addAssurance(Assurance assurance) {
        String query = "INSERT INTO assurance (assurance_id, description) VALUES (?, ?)";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, assurance.getId());
            preparedStatement.setString(2, assurance.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAssurance(Assurance assurance) {
        String query = "UPDATE assurance SET description = ? WHERE assurance_id = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, assurance.getDescription());
            preparedStatement.setString(2, assurance.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAssurance(String assuranceId) {
        String query = "DELETE FROM assurance WHERE assurance_id = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, assuranceId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
