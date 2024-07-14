package org.example.parkautoback.service;

import org.example.parkautoback.entity.VisiteTechnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;

@Service
public class VisiteTechniqueService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public ArrayList<VisiteTechnique> getAllVisiteTechniques() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM visite_technique";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<VisiteTechnique> visiteTechniques = new ArrayList<>();
                    while (resultSet.next()) {
                        visiteTechniques.add(new VisiteTechnique(resultSet.getString("idvt"), resultSet.getString("date_deb"), resultSet.getString("date_fin"), resultSet.getString("cout"), resultSet.getString("immat")));
                    }
                    return visiteTechniques;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public VisiteTechnique getVisiteTechnique(String idvt) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM visite_technique WHERE idvt = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idvt);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new VisiteTechnique(resultSet.getString("idvt"), resultSet.getString("date_deb"), resultSet.getString("date_fin"), resultSet.getString("cout"), resultSet.getString("immat"));
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

    public void addVisiteTechnique(VisiteTechnique visiteTechnique) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO visite_technique (idvt, date_deb, date_fin, cout, immat) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, visiteTechnique.getIdvt());
                preparedStatement.setString(2, visiteTechnique.getDate_deb());
                preparedStatement.setString(3, visiteTechnique.getDate_fin());
                preparedStatement.setString(4, visiteTechnique.getCout());
                preparedStatement.setString(5, visiteTechnique.getImmat());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVisiteTechnique(VisiteTechnique visiteTechnique) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE visite_technique SET date_deb = TO_DATE(?, 'YYYY-MM-DD'), date_fin = TO_DATE(?, 'YYYY-MM-DD'), cout = ?, immat = ? WHERE idvt = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, visiteTechnique.getDate_deb());
                preparedStatement.setString(2, visiteTechnique.getDate_fin());
                preparedStatement.setString(3, visiteTechnique.getCout());
                preparedStatement.setString(4, visiteTechnique.getImmat());
                preparedStatement.setString(5, visiteTechnique.getIdvt());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVisiteTechnique(String idvt) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM visite_technique WHERE idvt = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idvt);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
