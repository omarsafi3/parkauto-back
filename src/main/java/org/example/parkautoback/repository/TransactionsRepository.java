package org.example.parkautoback.repository;

import org.example.parkautoback.entity.Transactions;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, String> {
}
