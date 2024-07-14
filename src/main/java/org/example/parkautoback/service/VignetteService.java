package org.example.parkautoback.service;

import org.example.parkautoback.entity.Vignette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service
public class VignetteService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public ArrayList<Vignette> getAllVignettes() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM vignette";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Vignette> vignettes = new ArrayList<>();
                    while (resultSet.next()) {
                        vignettes.add(new Vignette(resultSet.getString("idv"), resultSet.getString("date_deb"), resultSet.getString("date_fin"), resultSet.getString("cout"), resultSet.getString("status"), resultSet.getString("immat")));
                    }
                    return vignettes;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Vignette getVignette(String idv) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM vignette WHERE idv = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idv);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Vignette(resultSet.getString("idv"), resultSet.getString("date_deb"), resultSet.getString("date_fin"), resultSet.getString("cout"), resultSet.getString("status"), resultSet.getString("immat"));
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

    public void addVignette(Vignette vignette) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO vignette (idv, date_deb, date_fin, cout, status, immat) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, vignette.getIdv());
                preparedStatement.setString(2, vignette.getDate_deb());
                preparedStatement.setString(3, vignette.getDate_fin());
                preparedStatement.setString(4, vignette.getCout());
                preparedStatement.setString(5, vignette.getStatus());
                preparedStatement.setString(6, vignette.getImmat());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVignette(Vignette vignette) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE vignette SET date_deb = TO_DATE(?, 'YYYY-MM-DD'), date_fin = TO_DATE(?, 'YYYY-MM-DD'), cout = ?, status = ?, immat = ? WHERE idv = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, vignette.getDate_deb());
                preparedStatement.setString(2, vignette.getDate_fin());
                preparedStatement.setString(3, vignette.getCout());
                preparedStatement.setString(4, vignette.getStatus());
                preparedStatement.setString(5, vignette.getImmat());
                preparedStatement.setString(6, vignette.getIdv());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVignette(String idv) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM vignette WHERE idv = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idv);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
