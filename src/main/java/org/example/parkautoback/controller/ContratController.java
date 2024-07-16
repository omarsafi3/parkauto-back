package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Contrat;
import org.example.parkautoback.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {
    private final ContratService contratService;
    @Autowired
    public ContratController(final ContratService contratService) {
        this.contratService = contratService;
    }


    @GetMapping
    public ResponseEntity<List<Contrat>> getAllContrats() {
        List<Contrat> contrats = contratService.getAllContrats();
        return ResponseEntity.ok(contrats);
    }

    @GetMapping("/{idc}")
    public ResponseEntity<Contrat> getContrat(@PathVariable String idc) {
        return contratService.getContrat(idc)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contrat> saveContrat(@RequestBody Contrat contrat) {
        Contrat savedContrat = contratService.saveContrat(contrat);
        return ResponseEntity.ok(savedContrat);
    }

    @PutMapping("/{idc}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable String idc, @RequestBody Contrat contrat) {
        return contratService.updateContrat(idc, contrat)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idc}")
    public ResponseEntity<Void> deleteContrat(@PathVariable String idc) {
        contratService.deleteContrat(idc);
        return ResponseEntity.noContent().build();
    }
}
