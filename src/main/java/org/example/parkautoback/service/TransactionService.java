package org.example.parkautoback.service;

import org.example.parkautoback.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service
public class TransactionService {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Transaction getTransaction(String transactionId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM transaction WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, transactionId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Transaction(
                                resultSet.getString("id"),
                                resultSet.getString("kilometrage"),
                                resultSet.getString("montant"),
                                resultSet.getString("t_date"),
                                resultSet.getString("station")
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

    public ArrayList<Transaction> getAllTransactions() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM transaction";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Transaction> transactions = new ArrayList<>();
                    while (resultSet.next()) {
                        transactions.add(new Transaction(
                                resultSet.getString("id"),
                                resultSet.getString("kilometrage"),
                                resultSet.getString("montant"),
                                resultSet.getString("t_date"),
                                resultSet.getString("station")
                        ));
                    }
                    return transactions;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addTransaction(Transaction transaction) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO transaction (id, kilometrage, montant, t_date, station) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, transaction.getId());
                preparedStatement.setString(2, transaction.getKilometrage());
                preparedStatement.setString(3, transaction.getMontant());
                preparedStatement.setString(4, transaction.getT_date());
                preparedStatement.setString(5, transaction.getStation());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransaction(Transaction transaction) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE transaction SET kilometrage = ?, montant = ?, t_date = ?, station = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, transaction.getKilometrage());
                preparedStatement.setString(2, transaction.getMontant());
                preparedStatement.setString(3, transaction.getT_date());
                preparedStatement.setString(4, transaction.getStation());
                preparedStatement.setString(5, transaction.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaction(String transactionId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM transaction WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, transactionId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
