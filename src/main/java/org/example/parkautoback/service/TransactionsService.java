package org.example.parkautoback.service;

import org.example.parkautoback.entity.Transactions;
import org.example.parkautoback.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;
    @Autowired
    public TransactionsService(final TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    public Optional<Transactions> getTransactions(String idt) {
        return transactionsRepository.findById(idt);
    }

    public Transactions addTransactions(Transactions transactions) {
        return transactionsRepository.save(transactions);
    }

    public Optional<Transactions> updateTransactions(String idt, Transactions transactions) {
        return transactionsRepository.findById(idt)
                .map(Transactions -> {
                    Transactions.setKilometrage(transactions.getKilometrage());
                    Transactions.setMontant(transactions.getMontant());
                    Transactions.setDatet(transactions.getDatet());
                    Transactions.setStation(transactions.getStation());
                    Transactions.setIdc(transactions.getIdc());
                    Transactions.setNum_carte(transactions.getNum_carte());
                    return transactionsRepository.save(Transactions);
                });
    }
    public void deleteTransactions(String idt) {
        transactionsRepository.deleteById(idt);
    }
}
