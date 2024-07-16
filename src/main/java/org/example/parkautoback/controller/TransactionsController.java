package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Transactions;
import org.example.parkautoback.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        List<Transactions> transactions = transactionsService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{idt}")
    public ResponseEntity<Transactions> getTransactions(@PathVariable String idt) {
        return transactionsService.getTransactions(idt)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transactions> saveTransactions(@RequestBody Transactions transactions) {
        Transactions savedTransactions = transactionsService.addTransactions(transactions);
        return ResponseEntity.ok(savedTransactions);
    }

    @PutMapping("/{idt}")
    public ResponseEntity<Transactions> updateTransactions(@PathVariable String idt,@RequestBody Transactions transactions) {
        return transactionsService.updateTransactions(idt, transactions)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idt}")
    public ResponseEntity<Void> deleteTransactions(@PathVariable String idt) {
        transactionsService.deleteTransactions(idt);
        return ResponseEntity.noContent().build();
    }
}
