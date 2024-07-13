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

    public Assurance getAssurance(String Id) {
        try {
            Connection connection = this.getConnection();

            Assurance assurance;
            try {
                String query = "SELECT * FROM assurance WHERE assurance_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, Id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    assurance = new Assurance(resultSet.getString("id"), resultSet.getString("lib"));
                } else {
                    assurance = null;
                }

                resultSet.close();
                preparedStatement.close();
            } finally {
                connection.close();
            }

            return assurance;
        } catch (SQLException var9) {
            var9.printStackTrace();
            return null;
        }
    }

    public ArrayList<Assurance> getAllAssurances() {
        try {
            Connection connection = this.getConnection();

            ArrayList<Assurance> assurances;
            try {
                String query = "SELECT * FROM assurance";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                assurances = new ArrayList<>();
                while (resultSet.next()) {
                    Assurance assurance = new Assurance(resultSet.getString("id"), resultSet.getString("lib"));
                    assurances.add(assurance);
                }

                resultSet.close();
                preparedStatement.close();
            } finally {
                connection.close();
            }

            return assurances;
        } catch (SQLException var10) {
            var10.printStackTrace();
            return null;
        }
    }

    public void addAssurance(Assurance assurance) {
        try {
            Connection connection = this.getConnection();

            try {
                String query = "INSERT INTO assurance (id, lib) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, assurance.getId());
                preparedStatement.setString(2, assurance.getLib());
                preparedStatement.executeUpdate();

                preparedStatement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }
    }

    public void updateAssurance(Assurance assurance) {
        try {
            Connection connection = this.getConnection();

            try {
                String query = "UPDATE assurance SET lib = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, assurance.getLib());
                preparedStatement.setString(2, assurance.getId());
                preparedStatement.executeUpdate();

                preparedStatement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }
    }

    public void deleteAssurance(String Id) {
        try {
            Connection connection = this.getConnection();

            try {
                String query = "DELETE FROM assurance WHERE assurance_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, Id);
                preparedStatement.executeUpdate();

                preparedStatement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }
    }
}
