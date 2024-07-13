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
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM assurance WHERE ida = ?")) {

            preparedStatement.setString(1, assuranceId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Assurance(resultSet.getString("ida"), resultSet.getString("libelle"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Assurance> getAllAssurances() {
        ArrayList<Assurance> assurances = new ArrayList<>();
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM assurance");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                assurances.add(new Assurance(resultSet.getString("ida"), resultSet.getString("libelle")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assurances;
    }

    public void addAssurance(Assurance assurance) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO assurance (ida, libelle) VALUES (?, ?)")) {

            preparedStatement.setString(1, assurance.getId());
            preparedStatement.setString(2, assurance.getLib());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAssurance(Assurance assurance) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE assurance SET LIBELLE = ? WHERE ida = ?")) {

            preparedStatement.setString(1, assurance.getLib());
            preparedStatement.setString(2, assurance.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAssurance(String assuranceId) {
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM assurance WHERE ida = ?")) {

            preparedStatement.setString(1, assuranceId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
